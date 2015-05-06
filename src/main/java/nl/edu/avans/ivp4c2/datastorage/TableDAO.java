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
    
    public TableDAO()
    {
        // Nothing to be initialized. This is a stateless class. Constructor
        // has been added to explicitely make this clear.
    }
    
    public ArrayList<Table> getTable()
    {
        ArrayList<Table> tables = new ArrayList();
        
        
        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if(connection.openConnection())
        {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet resultset = connection.executeSQLSelectStatement(
                "SELECT * FROM `tafel` WHERE tafelStatus = 'Bestelling';");

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
    
    
    public ArrayList<Table> getPaymentTable()
    {
        ArrayList<Table> tables = new ArrayList();
        
        
        // First open a database connnection
        DatabaseConnection connection = new DatabaseConnection();
        if(connection.openConnection())
        {
            // If a connection was successfully setup, execute the SELECT statement.
            ResultSet resultset = connection.executeSQLSelectStatement(
                "SELECT * FROM `tafel` WHERE tafelStatus = 'Afrekenen';");

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
