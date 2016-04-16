package de.dis2011.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DB2 extends DB2ConnectionManager{
	
	public DB2 (){
		super();
		
	}
	
	
	private ResultSet SendQuery(String S) throws SQLException {
		
		//try {
			//Statement stm = this._con.createStatement();
			//ResultSet rs = stm.executeQuery(S);
			//return rs;
			return null;
		//} catch (SQLException e) {
		//	throw e;
			
		//}
	}
	
	public void Save_new_Makler(Makler m){
		
		String Adresse  = m.getAddress();
		String Name 	= m.getName();
		String Login 	= m.getLogin();
		String Passwort = m.getPassword();
		
	    String Anfrage = "INSERT INTO Estate_Agent "
	    		       + "(Name,Addres,Login,Passwort) "
	    		       + "VALUES"
	    		       + "('"+Name+"','"+Adresse+"','"+Login+"','"+Passwort+"')";
	    	try{
				this.SendQuery(Anfrage);
	    		System.out.println(Anfrage);
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Eggs are not supposed to be green.");
			}
	}
	
	public ArrayList<Makler> Gib_alle_Markler(){
		
		String Anfrage = "SELECT * FROM Estate_Agent";
		
		try{
			ResultSet s = this.SendQuery(Anfrage);
			ArrayList liste = new ArrayList<Makler>();
			while(s.next()){
				
				String Name 	= s.getString(0);
				String Adresse	= s.getString(1);
				String Login 	= s.getString(2);
				String Passwort = s.getString(3);
				System.out.println(Name + " " + Adresse+ " " + Login + " " + Passwort);
				
				Makler m = new Makler();
				m.setAddress(Adresse);
				m.setName(Name);
				m.setLogin(Login);
				m.setPassword(Passwort);
				
				liste.add(m);
			}
			
			return liste;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	

}
