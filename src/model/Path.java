package model;

import java.io.Serializable;
import java.util.List;

public class Path implements Serializable{
	private int pathID;
	private int orgin;
	private int destination;
	private List<Place> though;

	public Path() {

	}

	public Path(int pathID, int orgin, int destination) {
		//super();
		this.pathID = pathID;
		this.orgin = orgin;
		this.destination = destination;
	}

	public int getPathID() {
		return pathID;
	}

	public void setPathID(int pathID) {
		this.pathID = pathID;
	}

	public int getOrgin() {
		return orgin;
	}

	public void setOrgin(int orgin) {
		this.orgin = orgin;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public List<Place> getThough() {
		
		return though;
	}

	public void setThough(List<Place> though) {
		this.though = though;
	}

	@Override
	public String toString() {
		return "Path [pathID=" + pathID + ", orgin=" + orgin + ", destination=" + destination + ", though=" + though
				+ "]";
	}

}
