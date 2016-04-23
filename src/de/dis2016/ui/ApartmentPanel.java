package de.dis2016.ui;


import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.dis2016.model.Apartment;

public class ApartmentPanel extends EstatePanel {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private final JTextField tfFloor;
	private final JTextField tfRent;
	private final JTextField tfRooms;
	private final JCheckBox cbxKitchen;
	private final JCheckBox cbxBalcony;
	
	private final JLabel lbFloor;
	private final JLabel lbRent;
	private final JLabel lbRooms;
	private final JLabel lbKitchen;
	private final JLabel lbBalcony;
	public ApartmentPanel() {
		super();
		tfRent = new JTextField();
		tfRooms = new JTextField();
		tfFloor = new JTextField();
		cbxBalcony = new JCheckBox();
		cbxKitchen = new JCheckBox();
		lbBalcony= new JLabel("balcony");
		lbFloor = new JLabel("floor");
		lbKitchen = new JLabel("kitchen");
		lbRent = new JLabel("rent");
		lbRooms = new JLabel("rooms");
		
		
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
	
	
	public ApartmentPanel(Apartment estate) {
		super(estate);
		tfRent = new JTextField();
		tfRooms = new JTextField();
		tfFloor = new JTextField();
		cbxBalcony = new JCheckBox();
		cbxKitchen = new JCheckBox();
		lbBalcony= new JLabel("balcony");
		lbFloor = new JLabel("floor");
		lbKitchen = new JLabel("kitchen");
		lbRent = new JLabel("rent");
		lbRooms = new JLabel("rooms");
		
		
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
		
		//TODO error check
		tfFloor.setText(String.valueOf(estate.getFloor()));
		tfRent.setText(String.valueOf(estate.getRent()));
		tfRooms.setText(String.valueOf(estate.getRooms()));
		
		cbxBalcony.setSelected(estate.isBalcony());
		cbxKitchen.setSelected(estate.isKitchen());
	}


	public int getFloor() {
		return Integer.valueOf(tfFloor.getText());
	}
	
	public int getRent() {
		return Integer.valueOf(tfRent.getText());
	}
	
	public int getRooms() {
		return Integer.valueOf(tfRooms.getText());
	}
	
	public boolean hasKitchen() {
		return cbxKitchen.isSelected();
	}
	
	public boolean hasBalcony() {
		return cbxBalcony.isSelected();
	}
	

	
	public void setEditable(boolean b) {
		super.setEditable(b);
		tfFloor.setEditable(b);
		tfRent.setEditable(b);
		tfRooms.setEditable(b);
		cbxBalcony.setEnabled(b);
		cbxKitchen.setEnabled(b);
	}

}
