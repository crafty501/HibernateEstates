package de.dis2016.model;

public class Apartment extends Estate{

	private int floor;
	private int rent;
	private int rooms;
	private boolean kitchen;
	private boolean balcony;
	
	private Person person;
	
	
	
	public Apartment(String id, String city, String postalCode, String street, String streetNr, String squareArea,
			int floor, int rent, int rooms, boolean kitchen, boolean balcony, Person person) {
		super(id, city, postalCode, street, streetNr, squareArea);
		this.floor = floor;
		this.rent = rent;
		this.rooms = rooms;
		this.kitchen = kitchen;
		this.balcony = balcony;
		this.person = person;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public boolean isKitchen() {
		return kitchen;
	}
	public void setKitchen(boolean kitchen) {
		this.kitchen = kitchen;
	}
	public boolean isBalcony() {
		return balcony;
	}
	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
}
