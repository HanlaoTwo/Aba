package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.Data;

@Entity
@Table(name="message")
public class Message {
	@Id
	@GeneratedValue
	private int id;
	private int sectionid;
	private String weather;
	private Date time_data;
	private String tration;
	private String emergency;
	
	
	public Message() {
		super();
	}

	public Message(int sectionid, String weather, Date time_data, String tration,
			String emergency) {
		
		super();
		System.out.println("constracter>>>>>>>>>>>>>>>>>>>"+emergency);
		this.sectionid = sectionid;
		this.weather = weather;
		this.time_data = time_data;
		this.tration = tration;
		this.emergency = emergency;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public Date getTime_data() {
		return time_data;
	}

	public void setTime_data(Date time_data) {
		this.time_data = time_data;
	}

	public String getTration() {
		return tration;
	}

	public void setTration(String tration) {
		this.tration = tration;
	}

	public String getEmergency() {
		return emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	public int getSectionid() {
		return sectionid;
	}

	public void setSectionid(int sectionid) {
		this.sectionid = sectionid;
	}
	
}
