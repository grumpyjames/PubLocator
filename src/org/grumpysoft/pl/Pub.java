package org.grumpysoft.pl;

public final class Pub {
	private final String name_;
	private final int rating_;
	private final double latitude_,longitude_;
	
	public Pub(String name, int rating, double lat, double longitude) {
		name_ = name;
		rating_ = rating;
		latitude_ = lat;
		longitude_ = longitude;
	}
	
	public final String name() { return name_; }
	public final int rating() { return rating_; }
	public final double latitude() { return latitude_; }
	public final double longitude() { return longitude_; }
}
