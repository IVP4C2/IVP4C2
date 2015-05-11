package nl.edu.avans.ivp4c2.manager;

import java.sql.ResultSet;
import java.util.ArrayList;

import nl.edu.avans.ivp4c2.datastorage.KitchenDAO;
import nl.edu.avans.ivp4c2.datastorage.OrderDAO;
import nl.edu.avans.ivp4c2.datastorage.TableDAO;
import nl.edu.avans.ivp4c2.domain.Table;

public class KitchenManager {
	
	// Attributes
	private ArrayList<Table> readyOrders;  //Arraylist for all orders that are ready to delivery from Kitchen
	private ArrayList<Table> emptyTables; //ArrayList for all empty tables
	private TableDAO tabledao;
	
	// Constructor
	public KitchenManager() {
		readyOrders = new ArrayList<Table>();
		emptyTables = new ArrayList<Table>();
		
	}
	
	// Methods
	
	public ResultSet getReadyOrders() {
		ResultSet resultset = null;
		KitchenDAO kitchendao = new KitchenDAO();
		resultset = kitchendao.getReadyOrders();
		return resultset;
	}
}
