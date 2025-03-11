package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility;

public class Person {
	
	private String name;
	private Place place;
	private List<Thing> possessions;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Place getPlace() { return place; }
	public List<Thing> getPossessions() { return possessions; }

	public Person(String name, Place place) {
		super();
		this.name = name;
		this.place = place;
		this.possessions = new ArrayList<Thing>();
		place.gain(this);
	}
	
	public void say(String text) {
		Utility.displayMessage("At " + place + ": " + this + " says -- " + text);
	}
	
	public List<Thing> otherThingsAtSamePlace() {
		List<Thing> otherThingsAtSamePlace = new ArrayList<Thing>();
		for (Thing thing : place.getContents()) {
			if (!possessions.contains(thing)) {
				otherThingsAtSamePlace.add(thing);
			}
		}
		return otherThingsAtSamePlace;
	}
	
	public List<Person> otherPeopleAtSamePlace() {
		List<Person> otherPeopleAtSamePlace = new ArrayList<Person>();
		for (Person occupant : place.getOccupants()) {
			if (!occupant.equals(this)) {
				otherPeopleAtSamePlace.add(occupant);
			}
		}
		return otherPeopleAtSamePlace;
	}
	
	public void lookAround() {
		say("I see " + Utility.verbalizeList(otherPeopleAtSamePlace(), "no people") +
				" and " + Utility.verbalizeList(otherThingsAtSamePlace(), "no objects") +
				" and can go " + Utility.verbalizeList(place.exits(), "nowhere"));
	}
	
	public void listPossessions() {
		say("I have " + Utility.verbalizeList(possessions, "nothing"));
	}
	
	public Thing hasPossession(Class<?> classType) {
		for(int i = 0; i < this.possessions.size(); i++) {
			if(this.possessions.get(i).getClass() == classType) {
				return this.possessions.get(i);
			}
		}
		return null;
	}
	
	public void read(Scroll scroll) {
		if ((scroll.isOwned()) && (scroll.getOwner().equals(this))) {
			scroll.beRead();
		} else {
			Utility.displayMessage(this + " does not have " + scroll);
		}
	}
	
	public void eat(Food item) {
		if ((item.isOwned()) && (item.getOwner().equals(this))) {
			item.beEaten();
		} else {
			Utility.displayMessage(this + " does not have " + item);
		}
	}
	
	public void haveFit() {
		say("Yaaaah! I am upset");
	}
	
	public void moveTo(Place newPlace) {
		Utility.displayMessage(this + " moves from " + place + " to " + newPlace);
		place.lose(this);
		newPlace.gain(this);
		for(Thing possession : possessions) {
			place.lose(possession);
			newPlace.gain(possession);
		}
		place = newPlace;
		greet(otherPeopleAtSamePlace());
	}
	
	public void go(String direction) {
		Place newPlace = place.neighborTowards(direction);
		if (newPlace == null) {
			Utility.displayMessage("You cannot go " + direction + " from " + place);
		} else {
			moveTo(newPlace);
		}
	}
	
	public void take(Thing thing) {
		if (equals(thing.getOwner())) {
			Utility.displayMessage(this + " already has " + thing);
		} else {
			if (thing.isOwned()) {
				Person owner = thing.getOwner();
				owner.lose(thing);
				owner.haveFit();
			}
			thing.setOwner(this);
			possessions.add(thing);
			say(thing.getOwner() + " took " + thing);
		}
	}
	
	//Add give function to give people the stuffs
	public void give(Thing thing, Person person){
	    if (equals(thing.getOwner())) {
	    	//We currently have this
		    lose(thing);
		    thing.setOwner(person);
		    person.possessions.add(thing);
		    say("I gave " + thing + " to " + person);
	    }
	    else{
	       Utility.displayMessage("I dont have this " + thing + " so I can't give it");
	    }
	}
	
	public void lose(Thing thing) {
		if (!equals(thing.getOwner())) {
			Utility.displayMessage(this + " doesn't have " + thing);
		} else {
			thing.becomeUnowned();
			possessions.remove(thing);
			say("I lose " + thing);
		}
	}
	
	public void remove(Thing thing) {
		if (!equals(thing.getOwner())) {
			Utility.displayMessage(this + " doesn't have " + thing);
		} else {
			thing.becomeUnowned();
			possessions.remove(thing);
		}
	}
	
	public void greet(List<Person> people) {
		if (!people.isEmpty()) {
			say("Hi " + Utility.verbalizeList(people, "no one")); // "no one" can't happen
		}
	}
	
	@Override
	public String toString() {
		return name;
	}
}
