package de.dis2016.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.dis2016.model.Apartment;
import de.dis2016.model.Estate;
import de.dis2016.model.House;
import de.dis2016.presenter.EstatesPresenter;

public class DeleteEstateFrame extends AbstractEstateFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	


	public DeleteEstateFrame(final EstatesPresenter presenter, final String login,final Estate estate) {
		super();
		
		EstatePanel panel = new HousePanel();
		if (estate instanceof House) {
			panel = new HousePanel((House) estate);
		} else if (estate instanceof Apartment) {
			panel = new ApartmentPanel((Apartment) estate);
		}
		panel.setEditable(false);
		super.add(panel, BorderLayout.CENTER);
		
		weiter.setText("Loeschen");
		
		weiter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean success = presenter.deleteEstate(login, estate);
				if (success) {
					setVisible(false);
					dispose();
				}
			}
		});
	}
}
