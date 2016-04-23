package de.dis2016.model;

public class House extends Estate{
	
	private String floors;
	private String price;
	private boolean garden;
	
	
	
	
	public House(String id, String city, String postalCode, String street, String streetNr, String squareArea,
			String floors, String price, boolean garden, String login, int personid, int contractnr) {
		super(id, city, postalCode, street, streetNr, squareArea, login, personid, contractnr);
		this.floors = floors;
		this.price = price;
		this.garden = garden;
	}
	public String getFloors() {
		return floors;
	}
	public void setFloors(String floors) {
		this.floors = floors;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public boolean isGarden() {
		return garden;
	}
	public void setGarden(boolean garden) {
		this.garden = garden;
	}
	

}
