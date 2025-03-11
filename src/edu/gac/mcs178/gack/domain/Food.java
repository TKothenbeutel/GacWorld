package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility;

public class Food extends Thing {
	
	public Food(String title) {
		super(title);
	}
	//Adding a beEaten function for the chocolates
		//When a chocolate is eaten, the owner loses it and 
		//it is gone from the place where the owner is located.
		//Not entirely sure this is where beEaten should go.
	public void beEaten() {
		Person owner = getOwner();
		if (owner == null) {
			Utility.displayMessage("No one has " + getName());
		} else {
			owner.say("I ate " + getName());
			owner.lose(this);
		}
	}
	
	public static List<Food> foodIn(Place place) {
		ArrayList<Food> foodIn = new ArrayList<Food>();
		for (Thing thing : place.getContents()) {
			if (thing instanceof Food) {
				foodIn.add((Food) thing);
			}
		}
		return foodIn;
	}

}