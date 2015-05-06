package nl.edu.avans.ivp4c2.main;

import javax.swing.JFrame;
import javax.swing.JPanel;



import nl.edu.avans.ivp4c2.manager.BarManager;
import nl.edu.avans.ivp4c2.presentation.BarGUI;
//import nl.edu.avans.ivp4c2.presentation.BarGUI;
import nl.edu.avans.ivp4c2.presentation.BorderLayoutPanel;

public class Main extends JFrame {
public static void main(String args[] ) {
	BarManager barmanager = new BarManager();
	JFrame frame = new Main();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Bedieningsysteem");
	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	JPanel panel = new BarGUI(barmanager);
	frame.setContentPane(panel);
	frame.setVisible(true);
	
	
}
}
