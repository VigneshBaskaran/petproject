package com.nttdata.petstore.dao;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;


import com.nttdata.petstore.dbfw.DBFWException;
import com.nttdata.petstore.domain.Cart;
import com.nttdata.petstore.domain.CartItem;
import com.nttdata.petstore.domain.Item;

public class OrderDAOTest {

@Test
	public void testPlaceOrder() {
		//fail("Not yet implemented");
	Item expectedDetail = new Item();
	expectedDetail.setItemId(12);
	expectedDetail.setProductId(81);
	expectedDetail.setCategoryId(31);
	expectedDetail.setItemName("Healthy Biscuits");
	expectedDetail.setItemDescription("healthy food for dogs");
	expectedDetail.setItemPrice(525);

	OrderDAO data = new OrderDAO();
		Object actualList=null;

		try {
			actualList = data.getPurchaseDetails(121);
		} catch (DBFWException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			}

		assertTrue(expectedDetail.equals(actualList));
	}

	@Test
	public void testInsertNewOrder() {
		fail("Not yet implemented");
	}

	


		@Test
		public void testGetPurchaseDetails() {
			Item expectedDetail = new Item();
			Item actItem = new Item();
			expectedDetail.setItemId(12);
			expectedDetail.setProductId(81);
			expectedDetail.setCategoryId(31);
			expectedDetail.setItemName("Healthy Biscuits");
			expectedDetail.setItemDescription("healthy food for dogs");
			expectedDetail.setItemPrice(525);
			System.out.println(expectedDetail);

			OrderDAO data = new OrderDAO();
			List actualList;

			try {

				actualList = (List) data.getPurchaseDetails(121);
				System.out.println(actualList);
				Iterator iterate = actualList.iterator();
				while (iterate.hasNext()) {
					actItem = (Item) iterate.next();
				}
				assertTrue(expectedDetail.equals(actItem));
			} catch (DBFWException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

	}

