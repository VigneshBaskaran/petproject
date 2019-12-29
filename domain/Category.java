package com.nttdata.petstore.domain;

public class Category {

	private int categoryId;
	private String categoryName;
	private String categoryDescription;

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", categoryDescription=" + categoryDescription
				+ "]";
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Category(int categoryId, String categoryName,
			String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Category cat = (Category) obj;
		if(this.categoryId == cat.getCategoryId() && this.categoryName.equals(cat.getCategoryName()) && this.categoryDescription.equals(cat.getCategoryDescription())){
			return true;
		}
		return false;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}
}
