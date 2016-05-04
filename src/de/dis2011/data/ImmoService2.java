package de.dis2011.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import de.dis2016.model.Apartment;
import de.dis2016.model.Contract;
import de.dis2016.model.Estate;
import de.dis2016.model.House;
import de.dis2016.model.Makler;
import de.dis2016.model.Person;
import de.dis2016.model.Purchase;
import de.dis2016.model.Tenancy;

/**
 * Klasse zur Verwaltung aller Datenbank-Entitäten.
 * 
 * TODO: Aktuell werden alle Daten im Speicher gehalten. Ziel der Übung
 * ist es, schrittweise die Datenverwaltung in die Datenbank auszulagern.
 * Wenn die Arbeit erledigt ist, werden alle Sets dieser Klasse überflüssig.
 */
public class ImmoService2 implements IDB2 {
	//Datensätze im Speicher

	private SessionFactory sessionFactory;
	
	public ImmoService2() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	
	@Override
	public int addContract(Contract contract) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contract> getContracts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTenancy(Tenancy tenancy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMakler(Makler makler, String old_login) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addMakler(Makler makler) {
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
	

	}

	@Override
	public List<Makler> getMarklers() {

		//Hibernate Session erzeugen
			Session session = sessionFactory.openSession();
		
			session.beginTransaction();
		
			List<Makler> liste =   session.createCriteria(Makler.class).list();

			
			return liste;
	}

	@Override
	public Makler getMakler(String login) {
		//Hibernate Session erzeugen
		Session session = sessionFactory.openSession();
	
		session.beginTransaction();
		
		Makler m = new Makler();
	
		Makler m2 = (Makler)session.get(Makler.class, login);
		
		
		return null;
	
	}

	

	@Override
	public List<Estate> getEstates(String login) {
		List<Estate> estates = new ArrayList<>();
		estates.addAll(getHouses(login));
		estates.addAll(getApartments(login));
		return null;
	}

	@Override
	public List<Estate> getHouses(String login) {
		List<Estate> list = sessionFactory.getCurrentSession().createCriteria(House.class)
			    .add( Restrictions.like("login", login))
			    .list();
		return list;
	}

	@Override
	public List<Estate> getApartments(String login) {
		List<Estate> list = sessionFactory.getCurrentSession().createCriteria(Apartment.class)
			    .add( Restrictions.like("login", login))
			    .list();
		return list;
	}

	
	private void deleteObject(Object o) {
		Transaction tx = null;
	    Session session = sessionFactory.getCurrentSession();
	    try {
	      tx = session.beginTransaction();
	      session.delete(o);
	      tx.commit();
	    } catch (RuntimeException e) {
	      if (tx != null && tx.isActive()) {
	        try {
	          tx.rollback();
	        } catch (HibernateException e1) {
	          System.err.println("Error rolling back transaction");
	        }
	        throw e;
	      }
	    }
	}
	private void addObjekt(Object o){
		Transaction tx = null;
	    Session session = sessionFactory.getCurrentSession();
	    try {
	      tx = session.beginTransaction();
	      session.save(o);
	      tx.commit();
	    } catch (RuntimeException e) {
	      if (tx != null && tx.isActive()) {
	        try {
	          tx.rollback();
	        } catch (HibernateException e1) {
	          System.err.println("Error rolling back transaction");
	        }
	        throw e;
	      }
	    }
	}


	private void updateObject(Object o) {
	    Transaction tx = null;
	    Session session = sessionFactory.getCurrentSession();
	    try {
	      tx = session.beginTransaction();
	      session.update(o);
	      tx.commit();
	    } catch (RuntimeException e) {
	      if (tx != null && tx.isActive()) {
	        try {
	          tx.rollback();
	        } catch (HibernateException e1) {
	          
	        }
	        throw e;
	      }
	    }
	  }


	@Override
	public void deleteEstate(Estate estate) {
		deleteObject(estate);		
	}
	
	@Override
	public void addApartment(Apartment apartment) {
		//unused
	}

	@Override
	public void addHouse(House house) {
		//unused
	}

	@Override
	public int addEstate(Estate estate) throws SQLException {
		addObjekt(estate);
		return 0; //unused
	}

	@Override
	public void updateEstate(Estate estate) {
		updateObject(estate);
	}
	

	@Override
	public void updateApartment(Apartment estate) throws SQLException {
		// unused
	}

	@Override
	public void updateHouse(House estate) throws SQLException {
		// unused
	}

	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePerson(Person person, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Person> getPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
