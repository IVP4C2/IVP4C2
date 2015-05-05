package nl.edu.avans.ivp4c2.presentation;

import java.awt.*;

import javax.swing.*;

import nl.edu.avans.ivp4c2.domain.Employee;

public class BarGUI extends JPanel {
	
	// Attributes 
	private JLabel logo;
	//private ImageIcon logo;
	
	// Buttons
	private JButton barOrderButton;
	private JButton kitchenOrderButton;
	private JButton loginButton;
	private JButton logoutButton;
	// Tijdelijk even een button voor de werknemers
	private JButton employeesButton;
	//private JComboBox<Employee> employeesCombobox;
	private JButton completeOrderButton;
	

	private JButton signupButton;
	private JButton[] tablebuttons;
	private JButton buttonTable1;
	private JButton tableButton1;
	private JButton tableButton2;
	private JButton tableButton3;
	private JButton tableButton4;
	private JButton tableButton5;
	private JButton tableButton6;
	private JButton tableButton7;
	private JButton tableButton8;
	private JButton tableButton9;
	private JButton tableButton10;
	
	// Panels
	private JPanel panelNorth;
	private JPanel panelNorthLeft;
	private JPanel panelNorthRight;
	private JPanel panelWest;
	private JPanel panelEast;
	
	
	
	public BarGUI() {
		setLayout(new BorderLayout());
		
		Font font = new Font("SansSerif", Font.PLAIN, 24);
		
		// create new panels
		panelNorth = new JPanel();
		panelNorthLeft = new JPanel();
		panelNorthRight = new JPanel();
		panelWest = new JPanel();
		panelEast = new JPanel();
		
		panelNorth.setLayout(new GridLayout(1,2));
		panelNorthLeft.setLayout(new GridLayout(1, 2));
		panelNorthRight.setLayout(new GridLayout(2,5));
		panelWest.setLayout(new GridLayout(5,1));
		panelEast.setLayout(new BorderLayout());
		
		
		// Setup North navigation
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("C:\\Users\\Bram\\Documents\\EclipsProjects\\ivp4c2\\src\\main\\resources\\logo.jpg"));
		panelNorthLeft.add(logo);
		logo.setMaximumSize(new Dimension(250, 250));
		
		signupButton = new JButton("Inschrijven");
		panelNorthLeft.add(signupButton);
		
		tableButton1 = new JButton("Tafel 1");
		tableButton1.setFont(font);
		tableButton2 = new JButton("Tafel 2");
		tableButton3 = new JButton("Tafel 3");
		tableButton4 = new JButton("Tafel 4");
		tableButton5 = new JButton("Tafel 5");
		tableButton6 = new JButton("Tafel 6");
		tableButton7 = new JButton("Tafel 7");
		tableButton8 = new JButton("Tafel 8");
		tableButton9 = new JButton("Tafel 9");
		tableButton10 = new JButton("Tafel 10");
		
		panelNorthRight.add(tableButton1);
		panelNorthRight.add(tableButton2);
		panelNorthRight.add(tableButton3);
		panelNorthRight.add(tableButton4);
		panelNorthRight.add(tableButton5);
		panelNorthRight.add(tableButton6);
		panelNorthRight.add(tableButton7);
		panelNorthRight.add(tableButton8);
		panelNorthRight.add(tableButton9);
		panelNorthRight.add(tableButton10);
		
		// Setup west navigation
		
		barOrderButton = new JButton("Barbestellingen");
		barOrderButton.setBackground(Color.DARK_GRAY);
		barOrderButton.setForeground(Color.WHITE);
		kitchenOrderButton = new JButton("Keukenbestellingen");
		employeesButton = new JButton("Employees");
		loginButton = new JButton("Inloggen");
		logoutButton = new JButton("Uitloggen");
		
		panelWest.add(barOrderButton);
		panelWest.add(kitchenOrderButton);
		panelWest.add(employeesButton);
		panelWest.add(loginButton);
		panelWest.add(logoutButton);
		
		// Setup panel East
		completeOrderButton = new JButton("Afronden");
		completeOrderButton.setMinimumSize(new Dimension(100,100));
		completeOrderButton.setPreferredSize(new Dimension(100,100) );
		panelEast.add(completeOrderButton);
		
		add(panelNorth, BorderLayout.NORTH);
		panelNorth.add(panelNorthLeft);
		panelNorth.add(panelNorthRight);
	
		add(panelWest, BorderLayout.WEST);
		add(panelEast, BorderLayout.SOUTH);

		
		
		
	}
}