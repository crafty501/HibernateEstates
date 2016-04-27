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
	
	public final JTextField tfCity;
	public final JTextField tfPostalCode;
	public final JTextField tfStreet;
	public final JTextField tfStreetNr;
	public final JTextField tfsquareArea;
	public final JTextField tfPersonId;
	public final JTextField tfContractNr;

	
	private final JLabel lbCity;
	private final JLabel lbPostalCode;
	private final JLabel lbStreet;
	private final JLabel lbStreetNr;
	private final JLabel lbSquareArea;
	private final JLabel lbPersonId;
	private final JLabel lbContractNr;

	protected Estate estate;
	
	
	public EstatePanel() {
		tfCity = new JTextField();
		tfPostalCode = new JTextField();
		tfsquareArea = new JTextField();
		tfStreet = new JTextField();
		tfStreetNr = new JTextField();
		tfPersonId = new JTextField();
		tfContractNr = new JTextField();
		lbCity = new JLabel("city");
		lbPostalCode = new JLabel("code");
		lbSquareArea = new JLabel("qm");
		lbStreet = new JLabel("street");
		lbStreetNr = new JLabel("streetnr");
		lbPersonId = new JLabel("personid");
		lbContractNr = new JLabel("ContractNr");

		
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
		add(lbContractNr);
		add(tfContractNr);
	}
	
	
	public EstatePanel(Estate estate) {
		
		
		
		tfCity = new JTextField();
		tfPostalCode = new JTextField();
		tfsquareArea = new JTextField();
		tfStreet = new JTextField();
		tfStreetNr = new JTextField();
		tfPersonId = new JTextField();
		tfContractNr = new JTextField();
		lbCity = new JLabel("city");
		lbPostalCode = new JLabel("code");
		lbSquareArea = new JLabel("qm");
		lbStreet = new JLabel("street");
		lbStreetNr = new JLabel("streetnr");
		lbPersonId = new JLabel("personid");
		lbContractNr = new JLabel("ContractNr");

		
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
		add(lbContractNr);
		add(tfContractNr);
		
		tfCity.setText(estate.getCity());
		tfPostalCode.setText(estate.getPostalCode());
		tfsquareArea.setText(String.valueOf(estate.getSuareArea()));
		tfStreet.setText(estate.getStreet());
		tfStreetNr.setText(estate.getStreetNr());
		tfPersonId.setText(String.valueOf(estate.getPersonid()));
		tfContractNr.setText(String.valueOf(estate.getContractnr()));
		
		this.estate = estate;
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
	
	public int getSuareArea() {
		return Integer.parseInt(tfsquareArea.getText());
	}
	
	public int getContractNr() {
		return Integer.parseInt(tfContractNr.getText());
	}
	
	
	public int getPersonId() {
		return Integer.parseInt(tfPersonId.getText());
	}

	
	public void setEditable(boolean b) {
		tfCity.setEditable(b);
		tfPostalCode.setEditable(b);
		tfsquareArea.setEditable(b);
		tfStreet.setEditable(b);
		tfStreetNr.setEditable(b);
		tfPersonId.setEditable(b);
		tfContractNr.setEditable(b);
	}
	




	public void updateEstate() {
		estate.setCity(getCity());
		estate.setContractnr(getContractNr());
		estate.setPostalCode(getPostalCode());
		estate.setStreet(getStreet());
		estate.setStreetNr(getStreetNr());
		estate.setSquareArea(getSuareArea());
		estate.setPersonid(getPersonId());
	}

}
