package de.dis2016.model;

public class Tenancy extends Contract{
	
	private int startDate;
	private int duration;
	private int additionalCosts;
	
	public Tenancy(int contractno, int date, String place, int startDate, int duration, int additionalCosts){
		super(contractno, date, place);
		this.startDate = startDate;
		this.duration = duration;
		this.additionalCosts = additionalCosts;
	}
	public int getStartDate() {
		return startDate;
	}
	public int getDuration() {
		return duration;
	}
	public int getAdditionalCosts() {
		return additionalCosts;
	}
    
	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void setAdditionalCosts(int additionalCosts) {
		this.additionalCosts = additionalCosts;
	}
	
}
