package de.dis2016.model;

public class House extends Estate{
	
	private int floors;
	private int price;
	private boolean garden;
	
	
	
	
	public House(int id, String city, String postalCode, String street, String streetNr, int squareArea,
			int floors, int price, boolean garden, String login, int personid, int contractnr) {
		super(id, city, postalCode, street, streetNr, squareArea, login, personid, contractnr);
		this.floors = floors;
		this.price = price;
		this.garden = garden;
	}
	public int getFloors() {
		return floors;
	}
	public void setFloors(int floors) {
		this.floors = floors;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isGarden() {
		return garden;
	}
	public void setGarden(boolean garden) {
		this.garden = garden;
	}
	

}
