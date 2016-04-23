package de.dis2016.ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class EstatesPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField tfCity;
	private JTextField tfPostalCode;
	private JTextField tfStreet;
	private JTextField tfStreetNr;
	private JTextField tfsquareArea;
	
	private JLabel lbCity;
	private JLabel lbPostalCode;
	private JLabel lbStreet;
	private JLabel lbStreetNr;
	private JLabel lbSquareArea;
	
	public EstatesPanel() {
		setLayout(new GridLayout(0, 2));
		add(lbCity);
		add(tfCity);
		add(lbPostalCode);
		add(tfPostalCode);
		add(lbStreet);
		add(tfStreet);
		add(lbStreetNr);
		add(tfStreetNr);
		add(lbSquareArea);
		add(tfsquareArea);
	}

}
