package com.nttdata.petstore.domain;

public class Product {
	private int productId;
	private int categoryId;
	private String productName;
	private String productDesc;

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryId=" + categoryId
				+ ", productName=" + productName + ", productDesc="
				+ productDesc + "]";
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Product(int productId, int categoryId, String productName,
			String productDesc) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.productDesc = productDesc;
	}

	public Product() {
		super();
	}
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Product prod = (Product) obj;
		if(this.categoryId == prod.getCategoryId() && this.productId == prod.getProductId() && this.productName.equals(prod.getProductName()) && this.productId == prod.getProductId()){
			return true;
		}
		return false;
	}
	
	


}
