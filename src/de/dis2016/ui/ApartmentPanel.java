package de.dis2016.ui;


import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ApartmentPanel extends EstatePanel {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JTextField tfFloor;
	private JTextField tfRent;
	private JTextField tfRooms;
	private JCheckBox cbxKitchen;
	private JCheckBox cbxBalcony;
	
	private JLabel lbFloor;
	private JLabel lbRent;
	private JLabel lbRooms;
	private JLabel lbKitchen;
	private JLabel lbBalcony;
	public ApartmentPanel() {
		super();
		add(lbFloor);
		add(tfFloor);
		add(lbRent);
		add(tfRent);
		add(lbRooms);
		add(tfRooms);
		add(lbKitchen);
		add(cbxKitchen);
		add(lbBalcony);
		add(cbxBalcony);
	}
	
	

}
