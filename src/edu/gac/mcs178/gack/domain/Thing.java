package edu.gac.mcs178.gack.domain;

public class Thing {
	
	private String name;
	private Person owner;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Person getOwner() { return owner; }
	public void setOwner(Person owner) { this.owner = owner; }

	public Thing(String name) {
		super();
		this.name = name;
	}
	
	public boolean isOwned() {
		return owner != null;
	}
	
	public void becomeUnowned() {
		owner = null;
	}
	
	//Adding a beEaten function for the chocolates
	//When a chocolate is eaten, the owner loses it and 
	//it is gone from the place where the owner is located.
	//Not entirely sure this is where beEaten should go.
	public void beEaten(String name) {
		becomeUnowned();
	}
	
	@Override
	public String toString() {
		return name;
	}
}
