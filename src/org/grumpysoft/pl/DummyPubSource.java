package org.grumpysoft.pl;

import java.util.ArrayList;

//for UI testing only. Do not use in reality.
public class DummyPubSource implements PubSource {

	public ArrayList<Pub> findPubs(double latitude, double longitude) {
		Pub one = new Pub("Jerusalem Tavern", 5, 51.521129, -.103496);
		Pub two = new Pub("Hand and Shears", 4, 51.2, -.08923);
		ArrayList<Pub> to_return = new ArrayList<Pub>();
		to_return.add(one);
		to_return.add(two);
		return to_return;
	}

	public ArrayList<Pub> findPubs(String postcode) {
		// TODO Auto-generated method stub
		return null;
	}

}
