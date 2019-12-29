package com.nttdata.petstore.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;




import com.nttdata.petstore.dbcon.DBConnectionException;
import com.nttdata.petstore.dbfw.DBFWException;
import com.nttdata.petstore.domain.Category;
import com.nttdata.petstore.domain.Item;
import com.nttdata.petstore.domain.Product;

public class ProductDAOTest {

//	@Test
//	public void testGetCategories() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGetCatbyID() throws PetStoreDAOException, DBFWException {
		//fail("Not yet implemented");

			Category expectedDetails = new Category();
			Category actItem = new Category();
			expectedDetails.setCategoryId(31);
			expectedDetails.setCategoryName("DOG");
			expectedDetails.setCategoryDescription("German Shepherd");

			ProductDAO data = new ProductDAO();
			List actualList = null;

//			try {
				actualList = data.getCatbyID(31);
				assertNotNull(actualList);
//			} catch (DBFWException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Iterator iterate = actualList.iterator();
//			if (iterate.hasNext()) {
//				actItem = (Category) iterate.next();
//			}
//			assertTrue(expectedDetails.equals(actItem));
			}
	

	@Test
	public void testGetProductList() {
//		fail("Not yet implemented");

		Product expecedDetail = new Product();
		Product actItem = new Product();
		expecedDetail.setProductId(81);
		expecedDetail.setCategoryId(31);
		expecedDetail.setProductDesc("bone biscuits");
		expecedDetail.setProductName("Pedigree");
	
		ProductDAO data = new ProductDAO();
		List actualList = null;

		try {
			actualList = data.getProductList(31);
			
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Product> iterate = actualList.iterator();
		if (iterate.hasNext()) {
			actItem = iterate.next();
		}
		assertTrue(expecedDetail.equals(actItem));
	}
	
	

	@Test
	public void testGetProduct() {
		//fail("Not yet implemented");

		Product expecedDetail = new Product();
		Product actItem = new Product();
		expecedDetail.setProductId(81);
		expecedDetail.setCategoryId(31);
		expecedDetail.setProductDesc("bone biscuits");
		expecedDetail.setProductName("Pedigree");

		ProductDAO data = new ProductDAO();
		List actualList = null;

		try {
			actualList = data.getProduct(31, 81);
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator iterate = actualList.iterator();
		while (iterate.hasNext()) {
			actItem = (Product) iterate.next();
		}
		assertTrue(expecedDetail.equals(actItem));
	}
//
	@Test
	public void testGetItemList() {
//		fail("Not yet implemented");
		Item expecedDetail = new Item();
		Item actItem = new Item();
		expecedDetail.setItemId(12);
		expecedDetail.setProductId(81);
		expecedDetail.setCategoryId(31);
		expecedDetail.setItemName("Healthy Biscuits");
		expecedDetail.setItemDescription("healthy food for dogs");
		expecedDetail.setItemPrice(525);
		List expect = new ArrayList();
		expect.add(expecedDetail);

		ProductDAO data = new ProductDAO();
		List actualList = null;

		try {
			boolean isTrue;
			actualList = data.getItemList(31, 81);
			isTrue = expect.containsAll(actualList);
			System.out.println(isTrue);
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
////
	@Test
	public void testGetItem() throws DBConnectionException {
		//fail("Not yet implemented");
		Item expecedDetail = new Item();
		Item act = new Item();
		expecedDetail.setItemId(12);
		expecedDetail.setProductId(81);
		expecedDetail.setCategoryId(31);
		expecedDetail.setItemName("Healthy Biscuits");
		expecedDetail.setItemDescription("healthy food for dogs");
		expecedDetail.setItemPrice(525);

		ProductDAO data = new ProductDAO();
		List expect = new ArrayList();
		expect.add(expecedDetail);
		List actualList = null;

		try {
			actualList = data.getItem(31, 81, 12);
			boolean isTrue;
			//actualList = data.getItem(25895, 1234, 26);
			isTrue = expect.containsAll(actualList);
			System.out.println(isTrue);
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



