package de.dis2016.ui;


import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import de.dis2016.model.House;

public class HousePanel extends EstatePanel {

	
	private final JTextField tfFloors;
	private final JTextField tfPrice;
	private final JCheckBox cbxGarden;

	
	private final JLabel lbFloors;
	private final JLabel lbPrice;
	private final JLabel lbGarden;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HousePanel() {
		super();
		tfFloors = new JTextField();
		tfPrice = new JTextField();
		cbxGarden = new JCheckBox();
		lbFloors = new JLabel("floors");
		lbGarden = new JLabel("garden");
		lbPrice = new JLabel("price");
		
		
		add(lbFloors);
		add(tfFloors);
		add(lbPrice);
		add(tfPrice);
		add(lbGarden);
		add(cbxGarden);

	}
	
	
	public HousePanel(House estate) {
		super(estate);
		tfFloors = new JTextField();
		tfPrice = new JTextField();
		cbxGarden = new JCheckBox();
		lbFloors = new JLabel("floors");
		lbGarden = new JLabel("garden");
		lbPrice = new JLabel("price");
		
		add(lbFloors);
		add(tfFloors);
		add(lbPrice);
		add(tfPrice);
		add(lbGarden);
		add(cbxGarden);
		
		tfFloors.setText(String.valueOf(estate.getFloors()));
		tfPrice.setText(String.valueOf(estate.getPrice()));
		cbxGarden.setSelected(estate.isGarden());
	}


	public String getFloors() {
		return tfFloors.getText();
	}
	
	public String getPrice() {
		return tfPrice.getText();
	}
	
	public boolean hasGarden() {
		return cbxGarden.isSelected();
	}
	
	
	public void setEditable(boolean b) {
		super.setEditable(b);
		tfFloors.setEditable(b);
		tfPrice.setEditable(b);
		cbxGarden.setEnabled(b);
	}

}
