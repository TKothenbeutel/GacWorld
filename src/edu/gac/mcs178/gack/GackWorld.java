package edu.gac.mcs178.gack;

import edu.gac.mcs178.gack.domain.AutoPerson;
import edu.gac.mcs178.gack.domain.Person;
import edu.gac.mcs178.gack.domain.Place;
import edu.gac.mcs178.gack.domain.Scroll;
import edu.gac.mcs178.gack.domain.Map;
import edu.gac.mcs178.gack.domain.Thing;
import edu.gac.mcs178.gack.domain.Witch;
import edu.gac.mcs178.gack.domain.Wizard;
import edu.gac.mcs178.gack.domain.Food;

public class GackWorld extends World {
	
	public GackWorld() {
		super();
		Place foodService = new Place("Food Service");
		Place po = new Place("Post Office");
		Place alumniHall = new Place("Alumni Hall");
		Place chamberOfWizards = new Place("Chamber of Wizards");
		Place library = new Place("Library");
		Place goodShipOlin = new Place("Good Ship Olin");
		Place lounge = new Place("Lounge");
		Place computerLab = new Place("Computer Lab");
		Place offices = new Place("Offices");
		Place dormitory = new Place("Dormitory");
		Place pond = new Place("Pond");
		Place lund = new Place("Lund");
		
		foodService.addNewNeighbor("down", po);
		po.addNewNeighbor("south", alumniHall);
		alumniHall.addNewNeighbor("north", foodService);
		alumniHall.addNewNeighbor("east", chamberOfWizards);
		alumniHall.addNewNeighbor("west", library);
		chamberOfWizards.addNewNeighbor("west", alumniHall);
		chamberOfWizards.addNewNeighbor("south", dormitory);
		dormitory.addNewNeighbor("north", chamberOfWizards);
		dormitory.addNewNeighbor("west", goodShipOlin);
		library.addNewNeighbor("east", library);
		library.addNewNeighbor("south", goodShipOlin);
		goodShipOlin.addNewNeighbor("north", library);
		goodShipOlin.addNewNeighbor("east", dormitory);
		goodShipOlin.addNewNeighbor("up", lounge);
		lounge.addNewNeighbor("west", computerLab);
		lounge.addNewNeighbor("south", offices);
		computerLab.addNewNeighbor("east", lounge);
		offices.addNewNeighbor("north", lounge);
		
		dormitory.addNewNeighbor("northwest", lund);
		//Added neighbor to lund because if you go there rn, ur stuck
		lund.addNewNeighbor("southeast", dormitory);
		
		new AutoPerson("Max", offices, 2);
		new AutoPerson("Karl", computerLab, 4);
		new Witch("Barbara", offices, 3, pond);
		new Wizard("Elvee", offices, 1, chamberOfWizards);
		
		lounge.gain(new Thing("Karl's glasses"));
		//New thing chocolates! in food service
		foodService.gain(new Food("White Chocolate"));
		foodService.gain(new Food("Dark Chocolate"));
		foodService.gain(new Food("Milk Chocolate"));
		
		library.gain(new Scroll("Scroll of Enlightenment"));
		String[] someTitles = {"War and Peace", "Iliad", "Collected Works of Rilke"};
		for (String title : someTitles) {
			library.gain(new Scroll(title));
		}
		computerLab.gain(new Scroll("Unix Programmers Manual"));
		computerLab.gain(new Scroll("NeXT User's Reference"));
		
		lund.gain(new Scroll("Louis blows up"));
		//New Scroll "late lab report"
		dormitory.gain(new Scroll("Late Lab Report"));
		
		//New Map type "Gack Map"
		library.gain(new Map("Gack Map"));
		
		
		setPlayer(new Person("player", dormitory));
	}
}
