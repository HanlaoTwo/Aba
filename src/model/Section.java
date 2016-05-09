package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="section")
public class Section {
	
	@Id
	@GeneratedValue
	private int id;
	private String msg;
	private String description;
	protected Section() {
	}
	public Section(int id, String msg, String description) {
		super();
		this.id = id;
		this.msg = msg;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
