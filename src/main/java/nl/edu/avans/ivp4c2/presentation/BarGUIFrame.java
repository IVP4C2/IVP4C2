package nl.edu.avans.ivp4c2.presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nl.edu.avans.ivp4c2.manager.BarManager;
import nl.edu.avans.ivp4c2.manager.KitchenManager;

public class BarGUIFrame extends JFrame {
	BarManager barmanager;
	
	public BarGUIFrame(BarManager barmanager, KitchenManager kitchenmanager) {
		this.barmanager = barmanager;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Bedieningsysteem");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JPanel panel = new BarGUI(barmanager, kitchenmanager);
		this.setContentPane(panel);
		this.setVisible(true);
	}
}
