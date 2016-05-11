package de.dis2016.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import de.dis2016.model.Apartment;
import de.dis2016.model.House;
import de.dis2016.model.Makler;
import de.dis2016.presenter.EstatesPresenter;

public class CreateApartmentFrame extends AbstractEstateFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CreateApartmentFrame(final EstatesPresenter presenter, final Makler makler) {
		super();

		final ApartmentPanel panel = new ApartmentPanel();
		super.add(panel, BorderLayout.CENTER);
		
		weiter.setText("Erstellen");
		
		weiter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Apartment apartment = new Apartment();
				apartment.setId(-1);
				apartment.setCity(panel.getCity());
				apartment.setPostalCode(panel.getPostalCode());
				apartment.setStreet(panel.getStreet());
				apartment.setStreetNr(panel.getStreetNr());
				apartment.setSquareArea(panel.getSuareArea());
				apartment.setFloor(panel.getFloor());
				apartment.setRent(panel.getRent());
				apartment.setRooms(panel.getRooms());
				apartment.setKitchen(panel.hasKitchen());
				apartment.setBalcony(panel.hasBalcony());
				apartment.setPersonid(panel.getPersonId());
				apartment.setContractnr(panel.getContractNr());
				
				try {
					
					presenter.addApartment(apartment);
					setVisible(false);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					
					JOptionPane.showMessageDialog(getFocusOwner(),
						    e1.getMessage(),
						    "Inane error",
						    JOptionPane.ERROR_MESSAGE);
					
				}
				
//				boolean success = 				if (success) {
//					setVisible(false);
//					dispose();
//				}
			}
		});
	}
}
