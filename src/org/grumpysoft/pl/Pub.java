package org.grumpysoft.pl;

public final class Pub {
	private String name;
	private int rating, id;
	private double latitude,longitude;
	
	public Pub(String name, int rating, double lat, double longitude, int id) {
		this.name = name;
		this.rating = rating;
		this.latitude = lat;
		this.longitude = longitude;
		this.id = id;
	}
	
	public Pub() {}; //for gson deserialization
	
	public final String name() { return name; }
	public final int rating() { return rating; }
	public final double latitude() { return latitude; }
	public final double longitude() { return longitude; }
	public final int id() { return id;}
}
