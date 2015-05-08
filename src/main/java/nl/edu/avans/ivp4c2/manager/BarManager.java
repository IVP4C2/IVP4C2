package nl.edu.avans.ivp4c2.manager;

import java.sql.ResultSet;
import java.util.ArrayList;

import nl.edu.avans.ivp4c2.datastorage.*;
import nl.edu.avans.ivp4c2.domain.Order;
import nl.edu.avans.ivp4c2.domain.Table;


public class BarManager {
	
//	private ArrayList<Order> orders;
	private ArrayList<Table> orderTables; //Arraylist for all order tables
	private ArrayList<Table> paymentTables; //ArrayList for all payment tables
	private ArrayList<Table> emptyTables; //ArrayList for all empty tables
	private TableDAO tabledao;
	public BarManager()
	{
//		orders = new ArrayList<Order>();
		orderTables = new ArrayList<Table>();
		paymentTables = new ArrayList<Table>();
		emptyTables = new ArrayList<Table>();
		tabledao = new TableDAO();
		getActiveTables();
		getPaymentTables();
		getEmptyTables();
	}
	
	public ArrayList<Table> getActiveTables()
	{

		for(Table t : tabledao.getTableOrder())
		{
			orderTables.add(t);
		};
		return orderTables;
	}
	
	public ArrayList<Table> getPaymentTables()
	{

		for(Table t : tabledao.getTablePayment())
		{
			paymentTables.add(t);
		};
		return paymentTables;
	}
	
	public ArrayList<Table> getEmptyTables() {
		for(Table t : tabledao.getTableEmpty()) {
			emptyTables.add(t);
		}
		return emptyTables;
	}
	
	// Get the resultset from the DAO
	public ResultSet getOrders(int tableNumber, int orderNumber) { 
		ResultSet resultset = null;
		OrderDAO orderdao = new OrderDAO();
		resultset = orderdao.getOrder(tableNumber, orderNumber);
		return resultset;
	}

	public ResultSet getTableOrders(int tableNumber) {
		ResultSet resultset = null;
		OrderDAO orderdao = new OrderDAO();
		resultset = orderdao.getTableOrders(tableNumber);
		return resultset;
	}
	
//	public void printTables() {
//		System.out.println("Overzicht:");
//		for(Table t : tables) {
//			t.print();
//		}
//	}
	
}
