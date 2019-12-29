package com.nttdata.petstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.nttdata.petstore.dbcon.ConnectionHolder;
import com.nttdata.petstore.dbcon.DBConnectionException;
import com.nttdata.petstore.dbfw.DBFWException;
import com.nttdata.petstore.dbfw.DBHelper;
import com.nttdata.petstore.dbfw.ParamMapper;
import com.nttdata.petstore.domain.Cart;
import com.nttdata.petstore.domain.CartItem;

public class OrderDAO {
	public static final Logger LOG = Logger.getLogger("ProductDAO.class");

	// placing an order in the cart.
	public Object placeOrder(final Cart shoppingCart) {

		Integer place = null;
		try {
			place = insertNewOrder(shoppingCart);

		} catch (DBFWException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}

		return place;

	}

	// inserting a new order in the list, a user want to buy.
	public int insertNewOrder(final Cart shoppingCart) throws DBFWException {
		boolean isUpdated = false;
		int result = 0;
		Connection con = null;
		ConnectionHolder holder=null;
		try {
			holder=ConnectionHolder.getInstance();
			con=holder.getConnection();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List cartList = shoppingCart.getItemDetails();
		Iterator iterator = cartList.iterator();
		while (iterator.hasNext()) {
			final CartItem cartItem = (CartItem) iterator.next();

			ParamMapper mapParam = new ParamMapper() {

				public void mapParams(PreparedStatement preStmt)
						throws DBFWException, SQLException {
					// TODO Auto-generated method stub

					preStmt.setInt(1, shoppingCart.getOrderId());
					preStmt.setString(2, shoppingCart.getCustId());
					preStmt.setInt(3, cartItem.getItem().getItemId());
					preStmt.setInt(4, cartItem.getItem().getProductId());
					preStmt.setInt(5, cartItem.getItem().getCategoryId());
					preStmt.setInt(6, cartItem.getQuantity());

				}
			};
			try {
				result = DBHelper.executeUpdate(con,
						SQLMapper.INSERT_PURCHASE_DETAILS, mapParam);
			} catch (DBFWException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				throw new DBFWException(e.getMessage());
			}
			if (result > 1) {
				isUpdated = true;
			}
		}
		return result;
	}

	public Object getPurchaseDetails(final int orderId) throws DBFWException {

		ResultSet resSet = null;
		
		Connection con = null;
		ConnectionHolder holder=null;
		PreparedStatement preStmt = null;
		List<Object> products;
		try {
			
			holder=ConnectionHolder.getInstance();
			con=holder.getConnection();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ParamMapper mapParam = new ParamMapper() {

			public void mapParams(PreparedStatement preStmt)
					throws DBFWException, SQLException {
				// TODO Auto-generated method stub
				preStmt.setInt(1, orderId);

			}
		};
		products = DBHelper.executeSelect(con, SQLMapper.SELECT_NEW_PURCHASE,
				SQLMapper.RES_MAPPER_THREE, mapParam);
		System.out.println(products);
	
		return products;
	}

	// method for generating random OrderID for the new List of Purchases.
	public int generateOrderID() throws DBFWException, PetStoreDAOException {
		List orderId;
		int order = 0;
		int newOrder = 0;
		Connection con = null;
		ConnectionHolder holder=null;
		try {
			holder=ConnectionHolder.getInstance();
			con=holder.getConnection();
			orderId = DBHelper.executeSelect(con, SQLMapper.SELECT_ORDERID,
					SQLMapper.RES_MAPPER_SEVEN);
			Iterator iterate = orderId.iterator();
			while (iterate.hasNext()) {
				order = (Integer) iterate.next();
				newOrder = order + 1;
				System.out.println(order);
			}
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LOG.error("Throws a DBFW exception");
			throw new PetStoreDAOException(e.getMessage());
			
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				LOG.error("Throws a DBFW exception");

				//e.printStackTrace();
				throw new PetStoreDAOException(e.getMessage());
			}
		
		
		return newOrder;
	}
}
}
