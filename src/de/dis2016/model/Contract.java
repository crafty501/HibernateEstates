package de.dis2016.model;

import java.sql.Date;

public abstract class Contract {
	private int contractno;
	private Date date;
	private String place;
	
	public Contract(int contractno, Date date, String place){
		this.contractno = contractno;
		this.date = date;
		this.place = place;
	}
	
	public int getContractno() {
		return contractno;
	}
	public Date getDate() {
		return date;
	}
	public String getPlace() {
		return place;
	}
    
	public void setContractno(int contractno) {
		this.contractno = contractno;
	}
	public void setDate(Date date) {
		this.date = date ;
	}
	public void setPlace(String place ) {
		this.place = place;
	}
	
}
