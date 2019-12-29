package com.nttdata.petstore.domain;

public class CartItem {

	private Item Item;
	private int quantity;

	public CartItem(Item item, int quantity) {
		super();
		Item = item;
		this.quantity = quantity;
	}

	public CartItem() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CartItem [Item=" + Item + ", quantity=" + quantity + "]";
	}

	public Item getItem() {
		return Item;
	}

	public void setItem(Item item) {
		Item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
