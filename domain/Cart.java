package com.nttdata.petstore.domain;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.petstore.dao.ProductDAO;

public class Cart {

	private int orderId;
	private String custId;
	private List itemDetails = new ArrayList();

	public List getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(List itemDetails) {
		this.itemDetails = itemDetails;
	}

	public CartItem getCart() {
		return getCart();
	}

	//
	public CartItem addCartItem(Item item, int quantity) {
		CartItem cartItem = new CartItem(item, quantity);
		itemDetails.add(cartItem);
		return cartItem;
	}

	ProductDAO dao = new ProductDAO();

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public List name(String custId, CartItem cartItem) {

		List list = new ArrayList();
		list.add(custId);
		list.add(cartItem);
		return list;
	}

}
