package edu.gac.mcs178.gack;

import edu.gac.mcs178.gack.ui.GraphicalUserInterface;

//Temp
import edu.gac.mcs178.gack.domain.Place;

public class Game {
	
	public static void main(String[] args) {
		Place p1 = new Place("1");
		Place p2 = new Place("2");
		Place p3 = new Place("3");
		
		p1.addNewNeighbor("North", p2);
		p1.addNewNeighbor("Up", p3);
		System.out.println(p1.exits());
		System.out.println(p1.neighborTowards("North"));
		GraphicalUserInterface.main(args);
	}
}
