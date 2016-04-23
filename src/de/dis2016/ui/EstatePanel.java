package de.dis2016.ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.dis2016.model.Estate;

public abstract class EstatePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JTextField tfCity;
	private final JTextField tfPostalCode;
	private final JTextField tfStreet;
	private final JTextField tfStreetNr;
	private final JTextField tfsquareArea;
	private final JTextField tfPersonId;
	
	private final JLabel lbCity;
	private final JLabel lbPostalCode;
	private final JLabel lbStreet;
	private final JLabel lbStreetNr;
	private final JLabel lbSquareArea;
	private final JLabel lbPersonId;
	
	
	
	public EstatePanel() {
		tfCity = new JTextField();
		tfPostalCode = new JTextField();
		tfsquareArea = new JTextField();
		tfStreet = new JTextField();
		tfStreetNr = new JTextField();
		tfPersonId = new JTextField();
		lbCity = new JLabel("city");
		lbPostalCode = new JLabel("code");
		lbSquareArea = new JLabel("qm");
		lbStreet = new JLabel("streen");
		lbStreetNr = new JLabel("streetnr");
		lbPersonId = new JLabel("personid");
		
		
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
		add(lbPersonId);
		add(tfPersonId);
	}
	
	
	public EstatePanel(Estate estate) {
		tfCity = new JTextField();
		tfPostalCode = new JTextField();
		tfsquareArea = new JTextField();
		tfStreet = new JTextField();
		tfStreetNr = new JTextField();
		tfPersonId = new JTextField();
		lbCity = new JLabel("city");
		lbPostalCode = new JLabel("code");
		lbSquareArea = new JLabel("qm");
		lbStreet = new JLabel("streen");
		lbStreetNr = new JLabel("streetnr");
		lbPersonId = new JLabel("personid");
		
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
		add(lbPersonId);
		add(tfPersonId);
		
		tfCity.setText(estate.getCity());
		tfPostalCode.setText(estate.getPostalCode());
		tfsquareArea.setText(estate.getSuareArea());
		tfStreet.setText(estate.getStreet());
		tfStreetNr.setText(estate.getStreetNr());

	}
	
	public String getCity() {
		return tfCity.getText();
	}
	
	public String getPostalCode() {
		return tfPostalCode.getText();
	}
	
	public String getStreet() {
		return tfStreet.getText();
	}
	
	public String getStreetNr() {
		return tfStreetNr.getText();
	}
	
	public String getSuareArea() {
		return tfsquareArea.getText();
	}

	
	public void setEditable(boolean b) {
		tfCity.setEditable(b);
		tfPostalCode.setEditable(b);
		tfsquareArea.setEditable(b);
		tfStreet.setEditable(b);
		tfStreetNr.setEditable(b);
		tfPersonId.setEditable(b);
	}
	


	public int getPersonId() {
		return Integer.parseInt(tfPersonId.getText());
	}

}
