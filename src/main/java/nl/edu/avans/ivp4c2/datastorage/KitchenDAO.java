package nl.edu.avans.ivp4c2.datastorage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import nl.edu.avans.ivp4c2.domain.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author IVP4C2
 */
public class KitchenDAO {

	public KitchenDAO() {
		// Nothing to be initialized. This is a stateless class. Constructor
		// has been added to explicitely make this clear.
	}

	public ResultSet getReadyOrders() {
		
		ResultSet resultset = null;

		// First open a database connnection
		DatabaseConnection connection = new DatabaseConnection();
		if (connection.openConnection()) {
			// If a connection was successfully setup, execute the SELECT
			// statement.
			resultset = connection
					.executeSQLSelectStatement("SELECT * FROM `keuken_bestelling` WHERE bestellingStatus = 'Klaarstaand';");
			
			// close resultset nog maken!!!!@@@@!!!$%&!@#%@!*~@*

		}
		return resultset;
	}
}
