package com.nttdata.petstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.nttdata.petstore.dbcon.ConnectionHolder;
import com.nttdata.petstore.dbcon.DBConnectionException;
import com.nttdata.petstore.dbfw.DBFWException;
import com.nttdata.petstore.dbfw.DBHelper;
import com.nttdata.petstore.dbfw.ParamMapper;
import com.nttdata.petstore.domain.Category;
import com.nttdata.petstore.domain.Item;
import com.nttdata.petstore.domain.Product;

public class ProductDAO {
	public static final Logger LOG = Logger.getLogger("ProductDAO.class");

	// return all the categories list
	public List<Category> getCategories() throws DBConnectionException {
		List<Category> categoryList = null;
		Connection con = null;
		ConnectionHolder holder=null;
		
		try {
			LOG.info("establishing Connection");
			holder=ConnectionHolder.getInstance();
			con=holder.getConnection();
			LOG.debug("connecting to the dbhelper to execute select query");
			categoryList = DBHelper.executeSelect(con,
					SQLMapper.SELECT_ALL_CATEG, SQLMapper.RES_MAPPER);
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			LOG.error("Throws a DBFW exception");
			e.printStackTrace();
		}
		return categoryList;
	}

	// returns a particular list matching the categId;
	public List<Category> getCatbyID(final int categId) throws DBFWException, PetStoreDAOException {
		Connection con = null;
		List<Category> categoryList;
		PreparedStatement prestmt = null;
	
		ConnectionHolder holder=null;
		try {
			LOG.info("establishing Connection");
			holder=ConnectionHolder.getInstance();
			con=holder.getConnection();
		} catch (DBConnectionException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			throw new PetStoreDAOException(e1.getMessage());
		}
		ParamMapper mapParam = new ParamMapper() {

			public void mapParams(PreparedStatement preStmt)
					throws DBFWException {
				// TODO Auto-generated method stub
				try {
					LOG.debug("setting the values");
					preStmt.setInt(1, categId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					LOG.error("Throws a DBFW exception");
					throw new DBFWException();
				}
			}
		};
		LOG.debug("connecting to the dbhelper for execute select");
		categoryList = DBHelper.executeSelect(con, SQLMapper.SELECT_CATEGORIES,
				SQLMapper.RES_MAPPER, mapParam);
		return categoryList;
	}

	// return all the products as in the product table;
	public List getProductList(final int categId) throws DBFWException {
		Connection con = null;
		
		ConnectionHolder holder=null;
		List<Product> productList;
		PreparedStatement prestmt = null;
		try {
			LOG.info("establishing Connection");
			holder=ConnectionHolder.getInstance();
			con=holder.getConnection();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ParamMapper mapParam = new ParamMapper() {

			public void mapParams(PreparedStatement preStmt)
					throws DBFWException, SQLException {
				LOG.debug("Inserting value");
				preStmt.setInt(1, categId);
			}
		};
		LOG.debug("connecting to the dbhelper to execute select query");
		productList = DBHelper.executeSelect(con,
				SQLMapper.SELECT_PRODUCT_LIST_ON_CATEG,
				SQLMapper.RES_MAPPER_ONE, mapParam);
		return productList;
	}

	// gets the specific product list matching the categId and the productId;
	public List getProduct(final int categId, final int productId)
			throws DBFWException {
		// will return a single list;
		Connection con = null;
		ConnectionHolder holder=null;
		List<Product> specificProductList;
		try {
			LOG.info("establishing Connection");
			holder=ConnectionHolder.getInstance();
			con=holder.getConnection();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ParamMapper mapParam = new ParamMapper() {

			public void mapParams(PreparedStatement preStmt)
					throws DBFWException, SQLException {
				LOG.debug("Inserting  the values");
				preStmt.setInt(1, categId);
				preStmt.setInt(2, productId);
			}
		};
		LOG.debug("connecting to the DBhelper to execute select query");
		specificProductList = DBHelper.executeSelect(con,
				SQLMapper.SELECT_SPECIFIC_PRODUCT_LIST_ON_CATEG,
				SQLMapper.RES_MAPPER_ONE, mapParam);
		return specificProductList;
	}

	// for the given productid and the categId get the item details;
	public List getItemList(final int categId, final int prodId)
			throws DBFWException {
		Connection con = null;
		ConnectionHolder holder=null;
		List<Item> itemList;
		try {
			LOG.info("Establishing Connection");
			holder=ConnectionHolder.getInstance();
			con=holder.getConnection();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ParamMapper mapParam = new ParamMapper() {

			public void mapParams(PreparedStatement preStmt)
					throws DBFWException, SQLException {
				LOG.debug("Inserting  the value");
				preStmt.setInt(1, categId);
				preStmt.setInt(2, prodId);
			}
		};
		LOG.debug("connecting to the dbhelper for execute select");
		itemList = DBHelper.executeSelect(con, SQLMapper.SELECT_ITEMS_ALL,
				SQLMapper.RES_MAPPER_SIX, mapParam);
		return itemList;
	}

	// for the given product id and the custid AND THE ITEM ID get the singular
	// list;
	public List getItem(final int categId, final int prodId, final int itemId)
			throws DBFWException, DBConnectionException {
		// return a single statement;
		Connection con = null;
		ConnectionHolder holder=null;
		List<Item> specificItemList=null;
		try {
			LOG.info("establishing Connection");
			holder=ConnectionHolder.getInstance();
			con=holder.getConnection();
		ParamMapper mapParam = new ParamMapper() {

			public void mapParams(PreparedStatement preStmt)
					throws DBFWException, SQLException {
				LOG.debug("Inserting values");
				preStmt.setInt(1, categId);
				preStmt.setInt(2, prodId);
				preStmt.setInt(3, itemId);
			}
		};
		LOG.debug("connecting to the dbhelper to execute select query");
		specificItemList = DBHelper.executeSelect(con,
				SQLMapper.SELECT_ITEMS_PARTICULAR, SQLMapper.RES_MAPPER_SIX,
				mapParam);
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				throw new DBConnectionException(e.getMessage());
			}
		}
		return specificItemList;
	}
}
