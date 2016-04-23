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
		Makler makler = data.Gib_Makler(login);
		boolean success = true;
		if (success) {
			view.setMakler(makler);
			view.setEstates(data.getEstates(makler));
		}
		return success;
		
	}


	public void deleteEstate(Makler makler, Estate estate) {
		data.deleteEstate(makler,estate);
		view.setEstates(data.getEstates(makler));
	}



	public void addHouse(Makler makler, House house) {
		data.addHouse(makler,house);
		view.setEstates(data.getEstates(makler));		
	}


	public void addApartment(Makler makler, Apartment apartment) {
		data.addApartment(makler, apartment);
		view.setEstates(data.getEstates(makler));
	}


	public void updateEstate(Makler makler, Estate estate) {
		data.updateEstate(makler, estate);
		view.setEstates(data.getEstates(makler));
	}
	
}
