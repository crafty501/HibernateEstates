package de.dis2016.ui;


import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HousePanel extends EstatePanel {

	
	private JTextField tfFloors;
	private JTextField tfPrice;
	private JCheckBox cbxGarden;
	
	private JLabel lbFloors;
	private JLabel lbPrice;
	private JLabel lbGarden;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public HousePanel() {
		super();
		add(lbFloors);
		add(tfFloors);
		add(lbPrice);
		add(tfPrice);
		add(lbGarden);
		add(cbxGarden);
	}
	
	

}
