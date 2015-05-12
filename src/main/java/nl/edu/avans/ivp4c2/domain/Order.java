package nl.edu.avans.ivp4c2.domain;

import java.sql.Time;
import java.util.ArrayList;


public class Order {
	private int orderNumber;
	private String orderStatus;
	private Time orderTime;
	private ArrayList<Product> products;
	
	public Order(int orderNumber, String orderStatus, Time orderTime) {
		this.orderNumber = orderNumber;
		this.orderStatus = orderStatus;
		this.orderTime = orderTime;
		products = new ArrayList<Product>();
		
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}

	public Time getOrderTime() {
		return orderTime;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void setOrderStatus(String newStatus) {
		this.orderStatus = newStatus;
	}

}
