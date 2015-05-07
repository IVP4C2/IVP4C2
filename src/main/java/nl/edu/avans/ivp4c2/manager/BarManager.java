package nl.edu.avans.ivp4c2.manager;

import java.sql.ResultSet;
import java.util.ArrayList;

import nl.edu.avans.ivp4c2.datastorage.*;
import nl.edu.avans.ivp4c2.domain.Order;
import nl.edu.avans.ivp4c2.domain.Table;


public class BarManager {
	
//	private ArrayList<Order> orders;
	private ArrayList<Table> tables;
	private ArrayList<Table> paymentTables;
	
	public BarManager()
	{
//		orders = new ArrayList<Order>();
		tables = new ArrayList<Table>();
		paymentTables = new ArrayList<Table>();
		
		getActiveTables();
		getPaymentTables();
	}
	
	public ArrayList<Table> getActiveTables()
	{
		TableDAO tabledao = new TableDAO();
		for(Table t : tabledao.getTable())
		{
			tables.add(t);
		};
		return tables;
	}
	
	public ArrayList<Table> getPaymentTables()
	{
		TableDAO tabledao = new TableDAO();
		for(Table t : tabledao.getPaymentTable())
		{
			paymentTables.add(t);
		};
		return paymentTables;
	}
	
	// Get out the dao the resultset
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
