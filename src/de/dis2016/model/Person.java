package de.dis2016.model;

public class Person {

	private String firstname;
	private String name;
	private String address;
	
	
	
	public Person(String firstname, String name, String address) {
		super();
		this.firstname = firstname;
		this.name = name;
		this.address = address;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
