package com.goofy.models;

import java.util.ArrayList;
import java.util.Date;

public class PlaceDetail extends Place{
	
	private ArrayList<String> visitors;
	private ArrayList<Byte[]> photos;
	
	public PlaceDetail(int id, String title, String description, String country,
			Location location, Date lastVisited, ArrayList<Byte[]> photos, ArrayList<String> visitors)
    {
		super(id, title, description, country, location);
        this.setVisitors(visitors);
        this.setPhotos(photos);
    }

	public ArrayList<String> getVisitors() {
		return visitors;
	}

	public void setVisitors(ArrayList<String> visitors) {
		this.visitors = visitors;
	}

	public ArrayList<Byte[]> getPhotos() {
		return photos;
	}

	public void setPhotos(ArrayList<Byte[]> photos) {
		this.photos = photos;
	}
}
