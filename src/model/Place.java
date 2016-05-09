package model;

import java.io.Serializable;
import java.util.Date;

public class Place implements Serializable{
	private int placeID;
	private String name;
	private int maxTourist;
	private int currentTourist;
	private Date time;

	public Place() {

	}

	public Place(int placeID, String name, int maxTourist, int currentTourist, Date time) {
		// super();
		this.placeID = placeID;
		this.name = name;
		this.maxTourist = maxTourist;
		this.currentTourist = currentTourist;
		this.time = time;
	}

	public int getPlaceID() {
		return placeID;
	}

	public void setPlaceID(int placeID) {
		this.placeID = placeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxTourist() {
		return maxTourist;
	}

	public void setMaxTourist(int maxTourist) {
		this.maxTourist = maxTourist;
	}

	public int getCurrentTourist() {
		return currentTourist;
	}

	public void setCurrentTourist(int currentTourist) {
		this.currentTourist = currentTourist;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Place [placeID=" + placeID + ", name=" + name + ", maxTourist=" + maxTourist + ", currentTourist="
				+ currentTourist + ", time=" + time + "]";
	}

}
