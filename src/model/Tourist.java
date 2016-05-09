package model;

import java.io.Serializable;
import java.util.Date;

public class Tourist implements Serializable{
	private int touristID;
	private String name;
	private String phoneNum;
	private String source;
	private String placeName;
	private Date time;
	private Path path;

	public Tourist() {

	}

	

	public Tourist(int touristID, String name, String phoneNum, String source, String placeName, Date time, Path path) {
		super();
		this.touristID = touristID;
		this.name = name;
		this.phoneNum = phoneNum;
		this.source = source;
		this.placeName = placeName;
		this.time = time;
		this.path = path;
	}



	public int getTouristID() {
		return touristID;
	}

	public void setTouristID(int touristID) {
		this.touristID = touristID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}



	public Path getPath() {
		return path;
	}



	public void setPath(Path path) {
		this.path = path;
	}



	@Override
	public String toString() {
		return "Tourist [touristID=" + touristID + ", name=" + name + ", phoneNum=" + phoneNum + ", source=" + source
				+ ", placeName=" + placeName + ", time=" + time + ", path=" + path + "]";
	}
	
	

//	public int getPathID() {
//		return pathID;
//	}
//
//	public void setPathID(int pathID) {
//		this.pathID = pathID;
//	}
//
//	@Override
//	public String toString() {
//		return "Tourist [touristID=" + touristID + ", name=" + name + ", phoneNum=" + phoneNum + ", source=" + source
//				+ ", placeName=" + placeName + ", time=" + time + ", pathID=" + pathID + "]";
//	}
	

}
