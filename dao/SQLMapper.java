package com.nttdata.petstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nttdata.petstore.dbfw.DBFWException;
import com.nttdata.petstore.dbfw.ResultMapper;
import com.nttdata.petstore.domain.Category;
import com.nttdata.petstore.domain.Customer;
import com.nttdata.petstore.domain.Item;
import com.nttdata.petstore.domain.Product;

public class SQLMapper {

	public static final String INSERT_PRODUCT_LINE_DETAILS = "insert into Product_Line_Details_89517 values (?,?,?,?,?,?)";
	public static final String INSERT_PURCHASE_DETAILS = "insert into Purchase_Detail_89517 values(?,?,?,?,?,?)";
	public static final String SELECT_VALIDATE = "select * from User_89517 where CustID =? and password =?";
	public static final String INSERT_USER = "insert into User_89517 values(?,?)";
	public static final String INSERT_CUSTOMER_DETAILS = "insert into Customer_89517 values(?,?,?,?,?,?,?)";
	public static final String INSERT_CREDIT_INFO = "insert into CreditCard_Info_89517 values(?,?,?)";
	public static final String SELECT_PURCHASE = "select * from Purchase_Detail_89517 where OrderID =?";
	public static final String SELECT_NEW_PURCHASE = " select p.ItemID,p.ProdID,p.CategID,p.ItemName,p.ItemDesc,p.Price from Product_Line_Items_89517 p inner join Purchase_Detail_89517 d on p.ItemID=d.ItemID where OrderID=?";
	public static final String SELECT_PURCHASE_DETAILS = "select s.ItemID, s.ProdID, s.CategID, ItemDesc, ItemName,Price from Purchase_detail_89517 s inner join Category_Product_89517 d on s.ProdID = d.ProdID where OrderId =?";
	public static final String INSERT_PLACE_ORDER = "insert into Purchase_Detail_89517 values (?,?,?,?) where OrderID = ?";
	public static final String SELECT_ALL_CATEG = "select * from Categories_89517";
	public static final String SELECT_CATEGORIES = "select * from Categories_89517 where CategID =?";
	public static final String SELECT_SEPCIFIC_CATEGORIES = "select Category, ProdID, CategID, ProdDesc, ProdName from Categories_89517 c inner join Category_Proucts_89517 e on c.CategID = e.CategID where CategID = ?";
	public static final String SELECT_PRODUCT_LIST_ON_CATEG = "select ProdID, CategID, ProdName, ProdDesc from Category_Products_89517 where CategID =?";
	public static final String SELECT_SPECIFIC_PRODUCT_LIST_ON_CATEG = "select ProdID, CategID, ProdName, ProdDesc from Category_Products_89517 where CategID =? and ProdID=?";
	public static final String SELECT_ITEMS_ALL = "select * from Product_Line_Items_89517 where CategID = ? and ProdID = ?";
	public static final String SELECT_ITEMS_PARTICULAR = "select ItemID, ProdID, CategID, ItemName, ItemDesc, Price from Product_Line_Items_89517 where CategID = ? and ProdID=? and ItemID =?";
	public static final String SELECT_ORDERID = "select max(OrderID) as ordernew from Purchase_Detail_89517";
	

	
	public static final ResultMapper RES_MAPPER = new ResultMapper() {

		public Object mapRow(ResultSet resSet) throws DBFWException,
				SQLException {
			// TODO Auto-generated method stub
			return new Category(resSet.getInt("CategID"),
					resSet.getString("CategName"),
					resSet.getString("CategDesc"));
		}
	};

	public static final ResultMapper RES_MAPPER_ONE = new ResultMapper() {

		public Object mapRow(ResultSet resSet) throws DBFWException,
				SQLException {
			// TODO Auto-generated method stub
			return new Product(resSet.getInt("ProdID"),
					resSet.getInt("CategID"), resSet.getString("ProdName"),
					resSet.getString("ProdDesc"));
		}
	};

	public static ResultMapper RES_MAPPER_TWO = new ResultMapper() {

		public Object mapRow(ResultSet resSet) throws DBFWException,
				SQLException {
			Customer customer = new Customer();
			String custid = resSet.getString("CustID");
			String pass = resSet.getString("Password");
			// TODO Auto-generated method stub
			customer.setCustId(custid);
			customer.setPasword(pass);
			return customer;

		}
	};

	public static ResultMapper RES_MAPPER_THREE = new ResultMapper() {

		public Object mapRow(ResultSet resSet) throws DBFWException,
				SQLException {
			return new Item(resSet.getInt("ItemID"), resSet.getInt("ProdID"),
					resSet.getInt("CategID"), resSet.getString("ItemName"),
					resSet.getString("ItemDesc"), resSet.getInt("Price"));
		}
	};

	public static ResultMapper RES_MAPPER_FOUR = new ResultMapper() {

		public Object mapRow(ResultSet resSet) throws DBFWException,
				SQLException {
			// TODO Auto-generated method stub
			return new Customer(resSet.getString("FirstName"),
					resSet.getString("LastName"), resSet.getString("DOB"),
					resSet.getString("Address"), resSet.getInt("ContactNo"));
		}
	};

	public static ResultMapper RES_MAPPER_FIVE = new ResultMapper() {

		public Object mapRow(ResultSet resSet) throws DBFWException,
				SQLException {
			// TODO Auto-generated method stub
			return new Customer(resSet.getInt("CreditCardno"),
					resSet.getString("Credit"), resSet.getString("ExpiryDt"));
		}
	};

	public static ResultMapper RES_MAPPER_SIX = new ResultMapper() {

		public Object mapRow(ResultSet resSet) throws DBFWException,
				SQLException {
			// TODO Auto-generated method stub
			return new Item(resSet.getInt("ItemID"), resSet.getInt("ProdID"),
					resSet.getInt("CategID"), resSet.getString("ItemName"),
					resSet.getString("ItemDesc"), resSet.getInt("Price"));
		}
	};

	public static ResultMapper RES_MAPPER_SEVEN = new ResultMapper() {

		public Object mapRow(ResultSet resSet) throws DBFWException,
				SQLException {
			// TODO Auto-generated method stub
			int orderNew = resSet.getInt("ordernew");
			return orderNew;
		}
	};
}
