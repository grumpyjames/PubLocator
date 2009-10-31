package org.grumpysoft.pl;

import java.util.ArrayList;

public interface PubSource {
	ArrayList<Pub> findPubs(double latitude, double longitude);
	ArrayList<Pub> findPubs(String postcode);
}
