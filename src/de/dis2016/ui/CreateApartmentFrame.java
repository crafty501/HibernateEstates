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
				
				Apartment apartment = new Apartment(-1, panel.getCity(), panel.getPostalCode(), panel.getStreet(), panel.getStreetNr(), panel.getSuareArea(),panel.getFloor(),panel.getRent(),panel.getRooms(),panel.hasKitchen(),panel.hasBalcony(), makler.getLogin(), panel.getPersonId(), panel.getContractNr());
				try {
					presenter.addApartment(apartment);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
				dispose();
//				boolean success = 				if (success) {
//					setVisible(false);
//					dispose();
//				}
			}
		});
	}
}
