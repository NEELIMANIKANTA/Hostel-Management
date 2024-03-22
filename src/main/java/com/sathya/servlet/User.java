package com.sathya.servlet;

import java.sql.Date;

public class User {
	private String userName;
	private String name;
	private String password;
	private String confirmpassword;
	private String email;
	private long mobile;
	private String address;
	
	
	//rooms available data
	private String category;
	private int rooms_Available;
	private double pricing;
	
	private Date check_in_date;
	private Date check_out_date;
	private int duration;
	private byte[] adhaar;
	private double totalPrice;
	private double totalrent;
	private double sgst;
	private double cgst;
	private double discount;
	private String bookingId;
	private String comments;
	
	
	
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public double getTotalrent() {
		return totalrent;
	}

	public void setTotalrent(double totalrent) {
		this.totalrent = totalrent;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getPricing() {
		return pricing;
	}

	public void setPricing(double pricing) {
		this.pricing = pricing;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getRooms_Available() {
		return rooms_Available;
	}

	public void setRooms_Available(int rooms_Available) {
		this.rooms_Available = rooms_Available;
	}

	public byte[] getAdhaar() {
		return adhaar;
	}

	public void setAdhaar(byte[] adhaar) {
		this.adhaar = adhaar;
	}

	
	
	public Date getCheck_in_date() {
		return check_in_date;
	}

	public void setCheck_in_date(Date check_in_date) {
		this.check_in_date = check_in_date;
	}

	public Date getCheck_out_date() {
		return check_out_date;
	}

	public void setCheck_out_date(Date check_out_date) {
		this.check_out_date = check_out_date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
