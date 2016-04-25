package de.dis2016.model;

public class Purchase extends Contract{
	
	private int noOfInstallments;
	private int intrestRate;

	public Purchase(int contractno, int date, String place, int noOfInstallments, int intrestRate){
		super(contractno, date, place);
		this.noOfInstallments = noOfInstallments;
		this.intrestRate = intrestRate;
	}
	
	public int getNoOfInstallments() {
		return noOfInstallments;
	}
	public int getIntrestRate(int intrestRate) {
		return intrestRate;
	}
    
	public void setNoOfInstallments(int noOfInstallments) {
		this.noOfInstallments = noOfInstallments;
	}
	public void setIntrestRate(int intrestRate) {
		this.intrestRate = intrestRate;
	}
}
