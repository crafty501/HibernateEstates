package de.dis2016.model;

public abstract class Contract {
	private int contractno;
	private int date;
	private String place;
	
	public Contract(int contractno, int date, String place){
		this.contractno = contractno;
		this.date = date;
		this.place = place;
	}
	
	public int getContractno() {
		return contractno;
	}
	public int getDate() {
		return date;
	}
	public String getPlace() {
		return place;
	}
    
	public void setContractno(int contractno) {
		this.contractno = contractno;
	}
	public void setDate(int date) {
		this.date = date ;
	}
	public void setPlace(String place ) {
		this.place = place;
	}
	
}
