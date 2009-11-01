package org.grumpysoft.pl;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;


public class JSONResponseTranslator implements ResponseTranslator {

	public ArrayList<Pub> fromString(String input) {
		ArrayList<Pub> to_return = new ArrayList<Pub>();
		try {
			JsonParser jp = new JsonParser();
			JsonElement el = jp.parse(input);
			JsonObject root = el.getAsJsonObject();
			JsonArray pubs = root.getAsJsonArray("pubs");
			Gson gs = new Gson();
			for (JsonElement je: pubs) {
				to_return.add(gs.fromJson(je, Pub.class));
			}
		}
		catch (JsonParseException jse) {
			System.err.println(jse.getMessage());
		}
		return to_return;
	}

}
