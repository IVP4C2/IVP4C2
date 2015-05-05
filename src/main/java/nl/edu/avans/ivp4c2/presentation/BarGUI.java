package nl.edu.avans.ivp4c2.presentation;

import java.awt.*;

import javax.swing.*;


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
	private final int AMOUNT_OF_TABLEBUTTONS = 10;
	private JButton[] tableButton;
	
	// Panels
	private JPanel panelNorth;
	private JPanel panelNorthLeft;
	private JPanel panelNorthRight;
	private JPanel panelWest;
	private JPanel panelEast;
	private JPanel panelCenter;
	
	
	
	public BarGUI() {
		setLayout(new BorderLayout());
		
		Font font = new Font("SansSerif", Font.PLAIN, 24);
		
		// create new panels
		panelNorth = new JPanel();
		panelNorthLeft = new JPanel();
		panelNorthRight = new JPanel();
		panelWest = new JPanel();
		panelEast = new JPanel();
		panelCenter = new JPanel();
		
		panelNorth.setLayout(new GridLayout(1,2));
		panelNorthLeft.setLayout(new GridLayout(1, 2));
		panelNorthRight.setLayout(new GridLayout(2,5));
		panelWest.setLayout(new GridLayout(5,1));
		panelEast.setLayout(new BorderLayout());
		panelCenter.setLayout(new BorderLayout());
		
		
		// Setup North navigation
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("C:\\Users\\Bram\\Documents\\EclipsProjects\\ivp4c2\\src\\main\\resources\\logo.jpg"));
		panelNorthLeft.add(logo);
		//logo.setMaximumSize(new Dimension(250, 250));
		
		signupButton = new JButton("Inschrijven");
		signupButton.setFont(font);
		panelNorthLeft.add(signupButton);
		
		// Array with the ten table buttons 
		tableButton = new JButton[AMOUNT_OF_TABLEBUTTONS];
		for(int tb = 0; tb <= 9; tb++) {
			tableButton[tb] = new JButton("Tafel " + tb);
			tableButton[tb].setFont(font);
		}
		
		for(int tb = 0; tb <= 9; tb++) {
			panelNorthRight.add(tableButton[tb]);
		}
		
		// Setup west panel
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
		completeOrderButton.setMinimumSize(new Dimension(100,100));
		completeOrderButton.setPreferredSize(new Dimension(100,100) );
		completeOrderButton.setFont(font);
		panelEast.add(completeOrderButton);
		
		// Setup center panel
		//overviewTableOrders = new JLabel("Selecteer eerst een bestelling!");
		startText = new JLabel("Selecteer eerst een tafel met een bestelling boven in het menu!");
		startText.setFont(font);
		
		panelCenter.add(startText);
		panelCenter.setBackground(Color.YELLOW);
		//panelCenter.add(overviewCurrentTableOrder);
		
		// Add all panels 
		add(panelNorth, BorderLayout.NORTH);
		panelNorth.add(panelNorthLeft);
		panelNorth.add(panelNorthRight);
		add(panelCenter, BorderLayout.CENTER);
		add(panelWest, BorderLayout.WEST);
		add(panelEast, BorderLayout.SOUTH);

		
		
		
	}
}