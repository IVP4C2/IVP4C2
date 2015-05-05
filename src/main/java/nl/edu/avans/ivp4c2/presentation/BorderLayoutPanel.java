package nl.edu.avans.ivp4c2.presentation;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BorderLayoutPanel extends JPanel {
	// Attributes
	private JButton barOrderButton, kitchenOrderButton;
	
	// Constructor
	public BorderLayoutPanel() {
		setLayout(new BorderLayout() ); 
			barOrderButton = new JButton("Bar orders");
			kitchenOrderButton = new JButton("Kitchen orders");
			add(barOrderButton, BorderLayout.WEST);
			add(kitchenOrderButton, BorderLayout.WEST);
		
	}
	
}
