package de.dis2016.presenter;

import de.dis2011.data.DB2;
import de.dis2011.data.Makler;
import de.dis2016.model.Apartment;
import de.dis2016.model.Estate;
import de.dis2016.model.House;
import de.dis2016.ui.EstatesFrame;

public class EstatesPresenter {

	
	EstatesFrame view;
	private DB2 data;
	public EstatesPresenter(EstatesFrame view, DB2 data) {
		this.view = view;
		this.data = data;
	}
	

	public boolean logIn(String login) {
		// TODO Auto-generated method stub
		Makler makler;// = data.Gib_Makler(login);
		
		//TODO loeschen
		makler = new Makler();
		makler.setLogin("test");
//		***************
		boolean success = false;
		if (makler!=null) {
			success = true;
		}
		
		if (success) {
			view.setMakler(makler);
			view.setEstates(data.getEstates(login));
		}
		return success;
		
	}


	public void deleteEstate(Estate estate) {
		data.deleteEstate(estate);
		view.setEstates(data.getEstates(estate.getLogin()));
	}



	public void addHouse(House house) {
		data.addHouse(house);
		view.setEstates(data.getEstates(house.getLogin()));		
	}


	public void addApartment(Apartment apartment) {
		data.addApartment(apartment);
		view.setEstates(data.getEstates(apartment.getLogin()));
	}


	public void updateEstate(Estate estate) {
		data.updateEstate(estate);
		view.setEstates(data.getEstates(estate.getLogin()));
	}
	
}
