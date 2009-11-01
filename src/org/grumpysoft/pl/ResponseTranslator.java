package org.grumpysoft.pl;

import java.util.ArrayList;

public interface ResponseTranslator {
	public ArrayList<Pub> fromString(String input);
}
