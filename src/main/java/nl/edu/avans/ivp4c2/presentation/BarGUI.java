package nl.edu.avans.ivp4c2.presentation;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import nl.edu.avans.ivp4c2.manager.BarManager;

public class BarGUI extends JPanel {

	// Attributes
	private JLabel logo;
	private JLabel startText;

	// Buttons
	private JButton barOrderButton;
	private JButton kitchenOrderButton;
	private JButton loginButton;
	private JButton logoutButton;
	// Temporary employee button, in i2 there will be a ComboBox with employees
	private JButton employeesButton;

	private JButton completeOrderButton;

	private JButton signupButton;
	private final int AMOUNT_OF_TABLEBUTTONS = 11;
	private JButton[] tableButton;

	// Panels
	private JPanel panelNorth;
	private JPanel panelNorthLeft;
	private JPanel panelNorthRight;
	private JPanel panelWest;
	private JPanel panelEast;
	private JPanel panelCenter;

	static Vector<String> columnNames;
	private BarManager barmanager;

	public BarGUI(BarManager barmanager) {
		this.barmanager = barmanager;

		setLayout(new BorderLayout());

		Font font = new Font("SansSerif", Font.PLAIN, 24);

		// create new panels
		panelNorth = new JPanel();
		panelNorthLeft = new JPanel();
		panelNorthRight = new JPanel();
		panelWest = new JPanel();
		panelEast = new JPanel();
		panelCenter = new JPanel();

		panelNorth.setLayout(new GridLayout(1, 2));
		panelNorthLeft.setLayout(new GridLayout(1, 2));
		panelNorthRight.setLayout(new GridLayout(2, 5));
		panelWest.setLayout(new GridLayout(5, 1));
		panelEast.setLayout(new BorderLayout());
		panelCenter.setLayout(new GridLayout(1, 2));

		// Setup North navigation
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon(
				"C:\\Users\\Bram\\Documents\\EclipsProjects\\ivp4c2\\src\\main\\resources\\logo.jpg"));
		panelNorthLeft.add(logo);

		signupButton = new JButton("Inschrijven");
		signupButton.setFont(font);
		panelNorthLeft.add(signupButton);

		// Array with the ten table buttons
		tableButton = new JButton[AMOUNT_OF_TABLEBUTTONS];
		for (int tb = 1; tb <= 10; tb++) {
			tableButton[tb] = new JButton("Tafel " + tb);
			tableButton[tb].setFont(font);
		}

		for (int tb = 1; tb <= 10; tb++) {
			panelNorthRight.add(tableButton[tb]);
		}

		// Setup West panel
		barOrderButton = new JButton("Barbestellingen");
		barOrderButton.setBackground(Color.DARK_GRAY);
		barOrderButton.setForeground(Color.WHITE);
		barOrderButton.setFont(font);
		kitchenOrderButton = new JButton("Keukenbestellingen");
		kitchenOrderButton.setFont(font);
		employeesButton = new JButton("Employees");
		employeesButton.setFont(font);
		loginButton = new JButton("Inloggen");
		loginButton.setFont(font);
		logoutButton = new JButton("Uitloggen");
		logoutButton.setFont(font);

		panelWest.add(barOrderButton);
		panelWest.add(kitchenOrderButton);
		panelWest.add(employeesButton);
		panelWest.add(loginButton);
		panelWest.add(logoutButton);

		// Setup east panel
		completeOrderButton = new JButton("Afronden");
		completeOrderButton.setMinimumSize(new Dimension(100, 100));
		completeOrderButton.setPreferredSize(new Dimension(100, 100));
		completeOrderButton.setFont(font);
		panelEast.add(completeOrderButton);

		// Setup center - left
		JTable tableLeft = null;
		try {
			tableLeft = new JTable(buildTableModel(barmanager.getOrders()));
			tableLeft.setBorder(BorderFactory.createEtchedBorder());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Panel center - right
		JTable tableRight = null;
		try {
			tableRight = new JTable(buildTableModel(barmanager.getOrders()));
			tableRight.setBorder(BorderFactory.createEtchedBorder());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		panelCenter.add(tableLeft);
		panelCenter.add(tableRight);
		panelCenter.setBackground(Color.YELLOW);

		// Add all panels
		add(panelNorth, BorderLayout.NORTH);
		panelNorth.add(panelNorthLeft);
		panelNorth.add(panelNorthRight);
		add(panelCenter, BorderLayout.CENTER);
		add(panelWest, BorderLayout.WEST);
		add(panelEast, BorderLayout.SOUTH);

		setActiveTables();
		setPaymentTables();
	}

	// Methods
	public void setActiveTables() {
		for (int tb = 1; tb <= 10; tb++) {
			if (tb == barmanager.getActiveTables().get(tb - 1).getTableNumber()) {
				tableButton[tb].setBackground(Color.ORANGE);
			}
		}
	}

	public void setPaymentTables() {
		for (int tb = 1; tb <= 10; tb++) {
			if (tb == barmanager.getPaymentTables().get(tb - 1)
					.getTableNumber()) {
				tableButton[tb].setBackground(Color.RED);
			}
		}
	}

	// Method to create JTable
	public static DefaultTableModel buildTableModel(ResultSet rs)
			throws SQLException {

		ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

//		 names of columns
		columnNames = new Vector<String>();
		columnNames.add("ProductNummer");
		columnNames.add("ProductNaam");
		columnNames.add("Merk");
		columnNames.add("BestellingNummer");
		columnNames.add("TafelNummer");
		
		// data of the table
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= 5; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);

	}
}