package com.nttdata.petstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.nttdata.petstore.dbcon.ConnectionHolder;
import com.nttdata.petstore.dbcon.DBConnectionException;
import com.nttdata.petstore.dbfw.DBFWException;
import com.nttdata.petstore.dbfw.DBHelper;
import com.nttdata.petstore.dbfw.ParamMapper;
import com.nttdata.petstore.domain.Customer;

public class UserDAO {
	public static final Logger LOG = Logger.getLogger("ProductDAO.class");
	
	public boolean validateUser(String userId, String password)
			throws PetStoreDAOException {
		boolean isValidated = false;
		Connection con = null;
		ConnectionHolder holder=null;

		try {
			LOG.info("establishing Connection");
			holder=ConnectionHolder.getInstance();
			con=holder.getConnection();
			// List list = new ArrayList();
			// Customer customer = new Customer();
			isValidated = DBHelper.validateUser(con, SQLMapper.SELECT_VALIDATE,
					SQLMapper.RES_MAPPER_TWO, userId, password);

		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				LOG.info("closing Connection");
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isValidated;

	}

	public Object registerUser(final Customer customerObject)
			throws PetStoreDAOException, DBConnectionException {
		boolean isInserted = false;
		int rows = 0;
		int rowsOne = 0;
		int rowsTwo = 0;
		Connection con = null;
		ConnectionHolder holder=null;

		try {
			LOG.info("establishing Connection");
		
			holder=ConnectionHolder.getInstance();
			con=holder.getConnection();
			ParamMapper mapParam = new ParamMapper() {

				public void mapParams(PreparedStatement preStmt)
						throws DBFWException, SQLException {
					// TODO Auto-generated method stub
					preStmt.setString(1, customerObject.getCustId());
					preStmt.setString(2, customerObject.getPasword());
				}
			};
			ParamMapper mapParamTwo = new ParamMapper() {

				public void mapParams(PreparedStatement preStmt)
						throws DBFWException, SQLException {
					// TODO Auto-generated method stub
					preStmt.setInt(1, customerObject.getCreditCardno());
					preStmt.setString(2, customerObject.getCardType());
					preStmt.setString(3, customerObject.getCardExpiryDate());
				}
			};

			ParamMapper mapParamOne = new ParamMapper() {

				public void mapParams(PreparedStatement preStmt)
						throws DBFWException, SQLException {
					// TODO Auto-generated method stub
					preStmt.setString(1, customerObject.getCustId());
					preStmt.setString(2, customerObject.getFirstName());
					preStmt.setString(3, customerObject.getLastName());
					preStmt.setString(4, customerObject.getDateOfBirth());
					preStmt.setString(5, customerObject.getAddress());
					preStmt.setInt(6, customerObject.getContactNumber());
					preStmt.setInt(7, customerObject.getCreditCardno());

				}
			};
			LOG.info("connecting to the dbhelper to execute update query");
			rowsTwo = DBHelper.executeUpdate(con, SQLMapper.INSERT_CREDIT_INFO,
					mapParamTwo);
			rowsOne = DBHelper.executeUpdate(con,
					SQLMapper.INSERT_CUSTOMER_DETAILS, mapParamOne);
			rows = DBHelper.executeUpdate(con, SQLMapper.INSERT_USER, mapParam);

			if ((rows > 0) && (rowsOne > 0) && (rowsTwo > 0)) {
				isInserted = true;
			System.out.println(isInserted);
			} else {
				isInserted = false;
				System.out.println(isInserted);
			}
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new DBConnectionException(e.getMessage());
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error("Throws a DBFW exception");
			throw new DBConnectionException(e.getMessage());
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		return customerObject;
	}
}
