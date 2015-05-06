package nl.edu.avans.ivp4c2.domain;

import java.sql.Time;
import java.util.ArrayList;


public class Order {
	private int orderNumber;
	private String orderStatus;
	private Time orderTime;
	private ArrayList<Product> products;
	private Table table;
	
	public Order(int orderNumber, String orderStatus, Time orderTime, Table table) {
		this.orderNumber = orderNumber;
		this.orderStatus = orderStatus;
		this.orderTime = orderTime;
		ArrayList<Product> products = new ArrayList<Product>();
		this.table = table;
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
	
	public void setOrderStatus(String newStatus) {
		this.orderStatus = newStatus;
	}
	
	public Table getTable() {
		return table;
	}
}
