
package de.dis2011.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;

import de.dis2016.model.Apartment;
import de.dis2016.model.Estate;
import de.dis2016.model.House;

public class DB2 extends DB2ConnectionManager {

	public DB2() {
		super();

	}

	/**
	 * Diese Methode sendet eine SQL Anfrage an die Datenbank und wirft ggf.
	 * eine SQLException
	 * 
	 * @param S
	 * 
	 * @param result
	 *            , falls die SQL-Anfrage ein Result hat muss hier true
	 *            angegeben werden
	 * @return
	 * @throws SQLException
	 */
	private ResultSet SendQuery(String S, boolean result) throws SQLException {

		try {

			Statement stm = this.con.createStatement();

			if (result) {
				if (stm.execute(S)) {
					// return stm.getResultSet();
					return stm.executeQuery(S);
				} else {
					return null;
				}
			} else {
				stm.execute(S);
				return null;
			}

		} catch (SQLException e) {
			throw e;

		}
	}

	public void Save_new_Makler(Makler m) {

		String Adresse = m.getAddress();
		String Name = m.getName();
		String Login = m.getLogin();
		String Passwort = m.getPassword();

		String Anfrage = "INSERT INTO Estate_Agent " + "(Name,Addres,Login,Passwort) " + "VALUES" + "('" + Name + "','"
				+ Adresse + "','" + Login + "','" + Passwort + "')";
		try {
			this.SendQuery(Anfrage, false);
			System.out.println(Anfrage);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Die Anfrage konnte nicht verarbeitet werden!" + e.getMessage());
		}
	}

	public ArrayList<Makler> Gib_alle_Markler() {

		String Anfrage = "SELECT NAME,ADDRES,LOGIN,PASSWORT FROM Estate_Agent";

		try {
			ResultSet s = this.SendQuery(Anfrage, true);
			System.out.println(Anfrage);
			ArrayList liste = new ArrayList<Makler>();

			// System.out.println("ResultSet row count = " + s.getRow());

			while (s.next()) {

				String Name = s.getString("NAME");
				String Adresse = s.getString("ADDRES");
				String Login = s.getString("LOGIN");
				String Passwort = s.getString("PASSWORT");
				System.out.println(Name + " " + Adresse + " " + Login + " " + Passwort);

				Makler m = new Makler();
				m.setAddress(Adresse);
				m.setName(Name);
				m.setLogin(Login);
				m.setPassword(Passwort);

				liste.add(m);

			}

			return liste;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * CREATE Estate_Agent( Name varchar(255), Addres text, Login varchar(255)
	 * NOT NULL UNIQUE, Passwort varchar(255) NOT NULL, PRIMARY KEY(Login) );
	 * 
	 * @param Login
	 * @return Makler
	 */
	public Makler Gib_Makler(String Login) {

		String Anfrage = "SELECT * FROM Estate_Agent WHERE Login='" + Login + "'";
		System.out.println(Anfrage);
		try {
			ResultSet result = this.SendQuery(Anfrage, true);
			int size = 0;
			if (result == null) {
				return null;
			} else {
				size = result.getFetchSize();
				System.out.println("size=" + size);
				if (result.next()) {
					String Name = result.getString(1);
					String Addres = result.getString(2);
					String Login_id = result.getString(3);
					String Pass = result.getString(4);

					Makler m = new Makler();
					m.setName(Name);
					m.setAddress(Addres);
					m.setLogin(Login_id);
					m.setPassword(Pass);

					return m;
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public void Save_existing_Makler(Makler m, String old_login) {
		String Name = m.getName();
		String Adresse = m.getAddress();
		String Login = m.getLogin();
		String Passwort = m.getPassword();

		String Anfrage = "UPDATE Estate_Agent SET NAME='" + Name + "',ADDRES='" + Adresse + "',LOGIN='" + Login
				+ "',PASSWORT='" + Passwort + "' WHERE LOGIN='" + old_login + "'";
		System.out.println(Anfrage);
		try {
			this.SendQuery(Anfrage, false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Estate> getEstates(String login) {
		List<Estate> estatesList = new ArrayList<>();
		estatesList.addAll(getHouses(login));
		estatesList.addAll(getApartments(login));
		return estatesList;
	}

	private static final String GET_HOUSES = "SELECT e.ID,e.City, e.Postal_Code,e.Street,e.Street_Number,e.Square_Area,e.Login,e.person_id,e.Contract_No,h.Floors,h.Price,h.Garden FROM Estate e,House h WHERE e.ID = h.ESTATE_ID AND login = ?";

	public List<Estate> getHouses(String login) {
		List<Estate> list = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(GET_HOUSES);
			ps.setString(1, login);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String city = rs.getString("City");
				String postalCode = rs.getString("Postal_Code");
				String street = rs.getString("Street");
				String streetNr = rs.getString("Street_Number");
				int squareArea = rs.getInt("Square_Area");
				int personid = rs.getInt("person_id");
				int contractnr = rs.getInt("Contract_No");
				int floors = rs.getInt("Floors");
				int price = rs.getInt("Price");
				boolean garden = rs.getInt("Garden") == 1 ? true : false;

				list.add(new House(id, city, postalCode, street, streetNr, squareArea, floors, price, garden, login,
						personid, contractnr));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	private static final String GET_APARTMENT = "SELECT e.ID,e.City, e.Postal_Code,e.Street,e.Street_Number,e.Square_Area,e.Login,e.person_id,e.Contract_No,a.App_Floor,a.Rent,a.Rooms,a.Balcony,a.Built_in_Kitchen FROM Estate e,Apartment a WHERE  e.ID = a.ESTATE_ID AND login = ?";

	public List<Estate> getApartments(String login) {
		List<Estate> list = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(GET_APARTMENT);
			ps.setString(1, login);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String city = rs.getString("City");
				String postalCode = rs.getString("Postal_Code");
				String street = rs.getString("Street");
				String streetNr = rs.getString("Street_Number");
				int squareArea = rs.getInt("Square_Area");
				int personid = rs.getInt("person_id");
				int contractnr = rs.getInt("Contract_No");
				int floor = rs.getInt("App_Floor");
				int rent = rs.getInt("Rent");
				int rooms = rs.getInt("Rooms");
				boolean kitchen = rs.getInt("Built_in_Kitchen") == 1 ? true : false;
				boolean balcony = rs.getInt("Balcony") == 1 ? true : false;

				list.add(new Apartment(id, city, postalCode, street, streetNr, squareArea, floor, rent, rooms, kitchen,
						balcony, login, personid, contractnr));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	private static final String DELETE_ESTATE = "DELETE FROM Estate WHERE ID = ?";

	public void deleteEstate(Estate estate) {
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_ESTATE);
			ps.setInt(1, estate.getId());

			// house und paparment werden cascadiert gelöscht
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static final String ADD_APARTMENT = "INSERT INTO Apartment (ESTATE_ID, App_Floor, Rent, Rooms, Balcony, Built_in_Kitchen, person_id) VALUES(?,?,?,?,?,?,?)";

	public void addApartment(Apartment apartment) {
		try {
			int id = addEstate(apartment);

			PreparedStatement ps = con.prepareStatement(ADD_APARTMENT);

			ps.setInt(1, id);
			ps.setInt(2, apartment.getFloor());
			ps.setInt(3, apartment.getRent());
			ps.setInt(4, apartment.getRooms());
			ps.setInt(5, apartment.isBalcony() ? 1 : 0);
			ps.setInt(6, apartment.isKitchen() ? 1 : 0);
			ps.setInt(6, apartment.getPersonid());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static final String ADD_HOUSE = "INSERT INTO House (ESTATE_ID,Floors,Price,Garden,person_id,purchase_contract) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public void addHouse(House house) {

		try {
			int id = addEstate(house);

			PreparedStatement addHouse = con.prepareStatement(ADD_HOUSE);

			addHouse.setInt(1, id);
			addHouse.setInt(2, house.getFloors());
			addHouse.setInt(3, house.getPrice());
			addHouse.setInt(4, house.isGarden() ? 1 : 0);
			addHouse.setInt(5, house.getPersonid());
			addHouse.setInt(6, house.getContractnr());

			addHouse.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static final String ADD_ESTATE = "INSERT INTO Estate (City,Postal_Code,Street,Street_Number,Square_Area,Login,person_id,Contract_No) VALUES(?,?,?,?,?,?,?,?)";

	private int addEstate(Estate estate) throws SQLException {

		PreparedStatement addEstate = con.prepareStatement(ADD_ESTATE, Statement.RETURN_GENERATED_KEYS);

		addEstate.setString(1, estate.getCity());
		addEstate.setString(2, estate.getPostalCode());
		addEstate.setString(3, estate.getStreet());
		addEstate.setString(4, estate.getStreetNr());
		addEstate.setInt(5, estate.getSuareArea());
		addEstate.setString(6, estate.getLogin());
		addEstate.setInt(7, estate.getPersonid());
		addEstate.setInt(8, estate.getContractnr());

		addEstate.executeUpdate();

		ResultSet rs = addEstate.getGeneratedKeys();
		if (rs.next()) {
			return rs.getInt(1);
		}
		return -1;
	}

	private static final String UPDATE_ESTATE = "UPDATE Estate SET City = ?,Postal_Code = ?,Street = ?,Street_Number = ?,Square_Area = ?,Login = ?,person_id = ?,Contract_No = ? WHERE ID = ?";
	private static final String UPDATE_APARTMENT = "UPDATE Apartment Set ESTATE_ID = ?, App_Floor = ?, Rent = ?, Rooms = ?, Balcony = ?, Built_in_Kitchen = ?, person_id = ? WHERE ESTATE_ID = ?";
	private static final String UPDATE_HOUSE = "UPDATE House SET ESTATE_ID = ?,Floors = ?,Price = ?,Garden = ?,person_id = ?,purchase_contract = ? WHERE ESTATE_ID = ?";

	public void updateEstate(Estate estate) {
		PreparedStatement addEstate;
		try {
			if (estate instanceof House) {
				updateHouse((House) estate);
			} else if (estate instanceof Estate) {
				updateApartment((Apartment) estate);
			}

			addEstate = con.prepareStatement(UPDATE_ESTATE);
			addEstate.setString(1, estate.getCity());
			addEstate.setString(2, estate.getPostalCode());
			addEstate.setString(3, estate.getStreet());
			addEstate.setString(4, estate.getStreetNr());
			addEstate.setInt(5, estate.getSuareArea());
			addEstate.setString(6, estate.getLogin());
			addEstate.setInt(7, estate.getPersonid());
			addEstate.setInt(8, estate.getContractnr());
			addEstate.setInt(9, estate.getId());

			addEstate.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void updateHouse(House estate) throws SQLException {

		PreparedStatement addHouse = con.prepareStatement(UPDATE_HOUSE);

		addHouse.setInt(1, estate.getFloors());
		addHouse.setInt(2, estate.getPrice());
		addHouse.setInt(3, estate.isGarden() ? 1 : 0);
		addHouse.setInt(4, estate.getPersonid());
		addHouse.setInt(5, estate.getContractnr());
		addHouse.setInt(6, estate.getId());

		addHouse.executeUpdate();

	}

	private void updateApartment(Apartment estate) throws SQLException {

		PreparedStatement ps = con.prepareStatement(UPDATE_APARTMENT);

		ps.setInt(1, estate.getFloor());
		ps.setInt(2, estate.getRent());
		ps.setInt(3, estate.getRooms());
		ps.setInt(4, estate.isBalcony() ? 1 : 0);
		ps.setInt(5, estate.isKitchen() ? 1 : 0);
		ps.setInt(6, estate.getPersonid());
		ps.setInt(7, estate.getId());

		ps.executeUpdate();
	}

}
