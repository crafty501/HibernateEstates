package de.dis2016.presenter;

import java.sql.SQLException;

import de.dis2011.data.IDB2;
import de.dis2016.model.Apartment;
import de.dis2016.model.Estate;
import de.dis2016.model.House;
import de.dis2016.model.Makler;
import de.dis2016.ui.EstatesFrame;

public class EstatesPresenter {

	EstatesFrame view;
	private IDB2 db;
	public EstatesPresenter(EstatesFrame view, IDB2 db) {
		this.view = view;
		this.db = db;
	}
	
	public boolean logIn(String login) {
		
		Makler makler = db.getMakler(login);
		boolean success = false;
		if (makler!=null) {
			success = true;
		}
		
		if (success) {
			view.setMakler(makler);
			view.setEstates(db.getEstates(login));
		}
		return success;
		
	}


	public void deleteEstate(Estate estate) {
		db.deleteEstate(estate);
		view.setEstates(db.getEstates(estate.getLogin()));
	}



	public void addHouse(House house) throws SQLException {
		db.addEstate(house);
		view.setEstates(db.getEstates(house.getLogin()));		
	}


	public void addApartment(Apartment apartment) throws SQLException {
		db.addEstate(apartment);
		view.setEstates(db.getEstates(apartment.getLogin()));
	}


	public void updateEstate(Estate estate) {
		db.updateEstate(estate);
		view.setEstates(db.getEstates(estate.getLogin()));
	}
	
}
