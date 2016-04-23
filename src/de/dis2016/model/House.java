package de.dis2016.model;

public class House extends Estate{
	
	private String floors;
	private String price;
	private boolean garden;
	private Person person;
	
	
	
	
	public House(String id, String city, String postalCode, String street, String streetNr, String squareArea,
			String floors, String price, boolean garden, Person person) {
		super(id, city, postalCode, street, streetNr, squareArea);
		this.floors = floors;
		this.price = price;
		this.garden = garden;
		this.person = person;
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
	public Person getSells() {
		return person;
	}
	public void setSells(Person sells) {
		this.person = sells;
	}
	
	
	
	
	

}
