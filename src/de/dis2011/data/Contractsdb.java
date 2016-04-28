package de.dis2011.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import de.dis2011.data.DB2ConnectionManager;
import de.dis2016.model.Contract;

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
	
	
}
