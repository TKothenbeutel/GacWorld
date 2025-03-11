package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

public class Map extends Thing {
	
	public Map(String title) {
		super(title);
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
