/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.edu.avans.ivp4c2.datastorage;


import nl.edu.avans.ivp4c2.domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ppthgast
 */
public class TableDAO {
    /*These string will be used to complete the SQL select statement
     * Since the only variable in the SQL statment is the table status and the status is an ENUM, 
     * we can use final Strins to complete the select statement*/
	private final String tableOrder = "Bestelling";
	private final  String tablePayment = "Afrekenen";
	private final  String tableEmpty = "Leeg";
	
    public TableDAO()
    {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }
    
    /*get all tables with status order(Bestelling)*/
    public ArrayList<Table> getTableOrder() {
    	ArrayList<Table> fetchedTables = new ArrayList<Table>();
    	fetchedTables = getTable(tableOrder);
    	return fetchedTables;
    }
    
    /*get all tables with status payment(Afrekenen)*/
    public ArrayList<Table> getTablePayment() {
    	ArrayList<Table> fetchedTables = new ArrayList<Table>();
    	fetchedTables = getTable(tablePayment);
    	return fetchedTables;
    }
    
    /*get all tables with status empty(Leeg)*/
    public ArrayList<Table> getTableEmpty() {
    	ArrayList<Table> fetchedTables = new ArrayList<Table>();
    	fetchedTables = getTable(tableEmpty);
    	return fetchedTables;
    }
    
	/*In this method, the tables get fetched depending on the 'status' variable in the SQL statement
	 * The value for this variable is declared in the method head. This value gets passes as and argument when the method is calles*/
	public ArrayList<Table> getTable(String status)
    {
        ArrayList<Table> tables = new ArrayList();
        
        
        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if(connection.openConnection())
        {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet resultset = connection.executeSQLSelectStatement(
                "SELECT * FROM `tafel` WHERE tafelStatus = '"+status+"';");

            if(resultset != null)
            {
                try
                {
                    while(resultset.next())
                    {
                       Table newTable = new Table(
    
                                resultset.getInt("tafelNummer"),
                                resultset.getString("tafelStatus"),
                                resultset.getInt("aantalpersonen"));

                        tables.add(newTable);
                    }
                    
                }
                catch(SQLException e)
                {
                    System.out.println(e);
                    tables = null;
                }
            }

            connection.closeConnection();
        }
        
        return tables;
    }
}
