package de.dis2016.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.dis2016.model.Apartment;
import de.dis2016.model.Estate;
import de.dis2016.model.House;
import de.dis2016.model.Makler;
import de.dis2016.presenter.EstatesPresenter;

public class ModifyEstateFrame extends AbstractEstateFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EstatePanel _panel;

	public ModifyEstateFrame(final EstatesPresenter presenter, final Makler makler, final Estate estate) {
		super();

		_panel = new HousePanel();
		if (estate instanceof House) {
			_panel = new HousePanel((House) estate);
			
			
		} else if (estate instanceof Apartment) {
			_panel = new ApartmentPanel((Apartment) estate);
			
			
		}
		super.add(_panel, BorderLayout.CENTER);
		
		weiter.setText("Aktualisieren");
		
		weiter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Estate es = null;
				//House house = new House(-1, panel.getCity(), panel.getPostalCode(), panel.getStreet(), panel.getStreetNr(), panel.getSuareArea(), panel.getFloors(), panel.getPrice(), panel.hasGarden(),makler.getLogin(),panel.getPersonId(), 0);

				if(_panel instanceof HousePanel){
					HousePanel panel = ((HousePanel)_panel);
					
					es = new House(estate.getId(), panel.getCity(), panel.getPostalCode(), panel.getStreet(), panel.getStreetNr(), panel.getSuareArea(), panel.getFloors(), panel.getPrice(), panel.hasGarden(),makler.getLogin(),panel.getPersonId(), panel.getContractNr());

				} else if (_panel instanceof ApartmentPanel) {
					ApartmentPanel panel = ((ApartmentPanel)_panel);
					es = new Apartment(estate.getId(), panel.getCity(), panel.getPostalCode(), panel.getStreet(), panel.getStreetNr(), panel.getSuareArea(),panel.getFloor(),panel.getRent(),panel.getRooms(),panel.hasKitchen(),panel.hasBalcony(), makler.getLogin(), panel.getPersonId(), panel.getContractNr());
				}
				
				
				presenter.updateEstate(es);
				setVisible(false);
				dispose();
				
//				boolean success = presenter.updateEstate(makler, estate);
//				if (success) {
//					setVisible(false);
//					dispose();
//				}
			}
		});
	}
}
