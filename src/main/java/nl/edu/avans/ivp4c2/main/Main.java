package nl.edu.avans.ivp4c2.main;

import javax.swing.JFrame;

import nl.edu.avans.ivp4c2.manager.BarManager;
import nl.edu.avans.ivp4c2.manager.KitchenManager;
import nl.edu.avans.ivp4c2.presentation.BarGUIFrame;
public class Main{
	public static void main(String args[] ) {
		BarManager barmanager = new BarManager();
		KitchenManager kitchenmanager = new KitchenManager();
		JFrame frame = new BarGUIFrame(barmanager, kitchenmanager);
		
	}
}