package de.dis2016.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import de.dis2011.data.Makler;
import de.dis2016.model.House;
import de.dis2016.presenter.EstatesPresenter;

public class CreateHouseFrame extends AbstractEstateFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public CreateHouseFrame(final EstatesPresenter presenter,final Makler makler) {
		super();

		final HousePanel panel = new HousePanel();
		super.add(panel, BorderLayout.CENTER);
		
		weiter.setText("Erstellen");
		
		weiter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				House house = new House(-1, panel.getCity(), panel.getPostalCode(), panel.getStreet(), panel.getStreetNr(), panel.getSuareArea(), panel.getFloors(), panel.getPrice(), panel.hasGarden(),makler.getLogin(),panel.getPersonId(), 0);
				presenter.addHouse(house);
				setVisible(false);
				dispose();
//				boolean success = presenter.addHouse(makler,house);
//				if (success) {
//					setVisible(false);
//					dispose();
//				}
			}
		});
	}
}
