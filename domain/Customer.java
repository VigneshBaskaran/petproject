package com.nttdata.petstore.domain;

public class Customer {

	private String custId;
	private String pasword;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String address;
	private int contactNumber;
	private int creditCardno;

	public int getCreditCardno() {
		return creditCardno;
	}

	public void setCreditCardno(int cardNumber) {
		this.creditCardno = cardNumber;
	}

	private String cardType;
	private String cardExpiryDate;

	public Customer() {

	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public Customer(String custId, String pasword) {
		super();
		this.custId = custId;
		this.pasword = pasword;
	}

	public Customer(String firstName, String lastName, String dateOfBirth,
			String address, int contactNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.contactNumber = contactNumber;
	}

	public Customer(int creditCardno, String cardType, String cardExpiryDate) {
		super();
		this.creditCardno = creditCardno;
		this.cardType = cardType;
		this.cardExpiryDate = cardExpiryDate;
	}

}
