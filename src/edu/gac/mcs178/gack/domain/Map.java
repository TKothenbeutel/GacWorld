package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility;

public class Map extends Thing {
	
	public Map(String title) {
		super(title);
	}

	public void beRead() {
		Person owner = getOwner();
		if (owner == null) {
			Utility.displayMessage("No one has " + getName());
		} else {
			owner.say("I have read " + getName());
		}
	}
	
	public static List<Place> neighborsTo(Place place){
		ArrayList<Place> nearbyPlaces = new ArrayList<Place>();
		
		return nearbyPlaces;
	}
	
	public static List<Map> mapsIn(Place place) {
		ArrayList<Map> mapsIn = new ArrayList<Map>();
		for (Thing thing : place.getContents()) {
			if (thing instanceof Map) {
				mapsIn.add((Map) thing);
			}
		}
		return mapsIn;
	}
}
