package de.dis2016.presenter;

import java.util.Vector;

import de.dis2011.data.DB2;
import de.dis2016.model.Estate;
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
		boolean success = true;
		if (success) {
			view.setLogin(login);
			view.setEstates(data.getEstates(login));
		}
		return success;
		
	}

	public Vector getHouses() {
		// TODO Auto-generated method stub
		return null;
	}



	public void deleteEstate(String login, Estate estate) {
		data.deleteEstate(login,estate);
		view.setEstates(data.getEstates(login));
	}

	
}
