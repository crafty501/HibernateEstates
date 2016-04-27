package de.dis2011.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.dis2011.data.DB2ConnectionManager;

/**
 CREATE TABLE Contract(
        Contract_No             integer NOT NULL GENERATED ALWAYS AS IDENTITY,
        Contract_Date           date,
        Place                   varchar(255),
        PRIMARY KEY (Contract_No)
);
  
  
CREATE TABLE Tenancy_Contract(
        ID                  integer NOT NULL GENERATED ALWAYS AS IDENTITY ,
        Contract_No         integer NOT NULL,
        Start_Date          date NOT NULL,
        Duration            integer NOT NULL, -- Zeit wird in Tagen angegeben
        Additional_Costs    decimal(4,2),
        PRIMARY KEY(ID)
);
  
 
CREATE TABLE Purchase_Contract(
        ID                    integer NOT NULL GENERATED ALWAYS AS IDENTITY,
        Contract_No           integer NOT NULL,
        No_of_Installments    integer NOT NULL,
        Interest_Rate         integer NOT NULL,
        PRIMARY KEY(ID)
);
 */
public class Contractsdb {
	private int contractNo = -1;
	private Date date;
	private String place;
	private Date startDate;
	private int duration;
	private int additionalCosts;
	private int noOfInstallments;
	private int interestRate;
	private boolean _tenancy;
	
	public int getContractNo() {
		return contractNo;
	}
	
	public void setContractNo(int contractNo) {
		this.contractNo = contractNo;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public void setTenency(boolean set){
		this._tenancy = set;
	}
	
	
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date date2) {
		this.startDate = date2;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public boolean getTenency(){
		return this._tenancy;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getAdditionalCosts() {
		return additionalCosts;
	}
	
	public void setAdditionalCosts(int additionalCosts) {
		this.additionalCosts = additionalCosts;
	}
	public int getNoOfInstallments() {
		return noOfInstallments;
	}
	
	public void setNoOfInstallments(int noOfInstallments) {
		this.noOfInstallments = noOfInstallments;
	}
	public int getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
	
	/**
	 * Lädt einen Makler aus der Datenbank
	 * @param id ID des zu ladenden Maklers
	 * @return Makler-Instanz
	 */
	public static Contractsdb load(int contractsNo) {
		try {
			// Hole Verbindung
			Connection con = DB2ConnectionManager.getInstance().getConnection();

			// Erzeuge Anfrage
			String selectSQL = "SELECT * FROM Contract WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, contractsNo);

			// Führe Anfrage aus
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Contractsdb ts = new Contractsdb();
				ts.setContractNo(contractsNo);
				//ts.setDate(rs.getInt("Date"));
				ts.setPlace(rs.getString("Place"));
				//ts.setStartDate(rs.getInt("Start_Date"));
				ts.setDuration(rs.getInt("Duration"));
				//ts.setAdditionalCosts(rs.getInt("Additional_Costs"));
				ts.setNoOfInstallments(rs.getInt("No_of_Installments"));
				ts.setInterestRate(rs.getInt("Interest_Rate"));

				rs.close();
				pstmt.close();
				return ts;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void  Save_as_New(){
		
		
		String ContractDate 	= date.toString();
		String Place 			= getPlace();
		String Anfrage = "INSERT INTO Tenancy_Contract (Contract_Date,Place) VALUES ('"+ContractDate+"','"+Place+"')";
		System.out.println(Anfrage);
		
		DB2 db = new DB2();
		int ID = -1;
		try {
			ID = db.Sendinsert(Anfrage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(_tenancy){
			
			String StartDate 		= startDate.toString();
			String Duration 		= String.valueOf(duration);
			String Additional_Cost	= String.valueOf(additionalCosts);
			Anfrage = "INSERT INTO Tenancy_Contract (Contract_No,Start_Date,Duration,Additional_Cost) VALUES ('"+ID+"','"+StartDate+"','"+Duration+"','"+Additional_Cost+"')";
			System.out.println(Anfrage);
		}else{
			
			
		}
		
	}
	
	
	/**
	 * Speichert den Makler in der Datenbank. Ist noch keine ID vergeben
	 * worden, wird die generierte Id von DB2 geholt und dem Model übergeben.
	 */
	public void save() {
		// Hole Verbindung
		Connection con = DB2ConnectionManager.getInstance().getConnection();

		try {
			// FC<ge neues Element hinzu, wenn das Objekt noch keine ID hat.
			if (getContractNo() == -1) {
				// Achtung, hier wird noch ein Parameter mitgegeben,
				// damit spC$ter generierte IDs zurC<ckgeliefert werden!
				
				
				
				String insertSQL = "INSERT INTO Contract(Contract_Date, Place) VALUES (?, ?)";

				
				
				PreparedStatement pstmt = con.prepareStatement(insertSQL,
						Statement.RETURN_GENERATED_KEYS);

				// Setze Anfrageparameter und fC<hre Anfrage aus
				//pstmt.setInt(1, getDate());
				pstmt.setString(2, getPlace());
				pstmt.executeUpdate();

				// Hole die Id des engefC<gten Datensatzes
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					setContractNo(rs.getInt(1));
				}

				rs.close();
				pstmt.close();
			} else {
				// Falls schon eine ID vorhanden ist, mache ein Update...
				String updateSQL = "UPDATE Contract SET Contract_Date = ?, Place = ? WHERE Contract_No = ?";
				PreparedStatement pstmt = con.prepareStatement(updateSQL);

				// Setze Anfrage Parameter
				//pstmt.setInt(1, getDate());
				pstmt.setString(2, getPlace());
				pstmt.setInt(5, getContractNo());
				pstmt.executeUpdate();

				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
