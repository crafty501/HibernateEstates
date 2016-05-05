
package de.dis2011.data;

import java.sql.SQLException;
import java.util.List;
import de.dis2016.model.Apartment;
import de.dis2016.model.Contract;
import de.dis2016.model.Estate;
import de.dis2016.model.House;
import de.dis2016.model.Makler;
import de.dis2016.model.Person;
import de.dis2016.model.Purchase;
import de.dis2016.model.Tenancy;


public interface IDB2  {

	//Contracts
	public int addContract(Contract contract);
	public List<Contract>  getContracts();
	public void addTenancy(Tenancy tenancy);
	public void addPurchase(Purchase purchase); 
	
	
	//Makler
	public void addMakler(Makler makler);
	public List<Makler> getMarklers() ;
	public Makler getMakler(String login) ;
	public void updateMakler(Makler makler, String old_login) ;
	
	//Estates
	public List<Estate> getEstates(String login) ;
	public List<Estate> getHouses(String login);
	public List<Estate> getApartments(String login) ;
	public void deleteEstate(Estate estate) ;
	public void addApartment(Apartment apartment) ;
	public void addHouse(House house) ;
	public int addEstate(Estate estate) throws SQLException;
	public void updateEstate(Estate estate);
	public void updateApartment(Apartment estate) throws SQLException ;
	public void updateHouse(House estate) throws SQLException;
	
	//personen
	public void addPerson(Person person);
	public void updatePerson(Person person);
	public List<Person> getPersons();
	public Person getPerson(int id);
}
