package com.nttdata.petstore.domain;

public class Item {

	private int itemId;
	private int productId;
	private int categoryId;
	private String itemName;
	private String itemDescription;
	private int itemPrice;
	CartItem obj1 = new CartItem();
	Cart cart = new Cart();

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public CartItem getObj1() {
		return obj1;
	}

	public void setObj1(CartItem obj1) {
		this.obj1 = obj1;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", productId=" + productId
				+ ", categoryId=" + categoryId + ", itemName=" + itemName
				+ ", itemDescription=" + itemDescription + ", itemPrice="
				+ itemPrice + "]";
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Item(int itemId, int productId, int categoryId, String itemName,
			String itemDescription, int itemPrice) {
		super();
		this.itemId = itemId;
		this.productId = productId;
		this.categoryId = categoryId;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
	}

	public Item() {
		super();
	}

	public Item(int int1, int int2, int int3) {

	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Item item = (Item) obj;
		if(this.itemId == item.getItemId() && this.productId == item.getProductId() && this.itemName.equals(item.getItemName()) && this.itemDescription.equals(item.getItemDescription()) && this.itemPrice == item.getItemPrice()){
			return true;
		}
		return false;
	}

}
