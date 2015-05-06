package nl.edu.avans.ivp4c2.domain;

import java.util.ArrayList;

public class Table {
	private int tableNumber;
	private String tableStatus;
	private int amountPersons;
	private ArrayList<Order> orders;
	
	public Table(int tableNumber, String tableStatus, int amountPersons) {
		this.tableNumber = tableNumber;
		this.tableStatus = tableStatus;
		this.amountPersons = amountPersons;
		ArrayList<Order> orders = new ArrayList<Order>();
	}
	
	public int getTableNumber() {
		return tableNumber;
	}
	
	public String getTableStatus() {
		return tableStatus;
	}
	
	public int getAmountPersons() {
		return amountPersons;
	}
	
	public String toString() {
		return String.format("%-20s %-20s %-20s", tableNumber, tableStatus, amountPersons);
	}
	
	public void print() {
		System.out.println(tableNumber + tableStatus + amountPersons);
	}
}
