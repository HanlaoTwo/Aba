package com.aba.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class test implements Serializable {

	
	private static final long serialVersionUID = 2588199709884487540L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int name;
	private int passw;
	

	public test() {

	}


	public test(int id, int name, int passw) {
		super();
		this.id = id;
		this.name = name;
		this.passw = passw;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getName() {
		return name;
	}


	public void setName(int name) {
		this.name = name;
	}


	public int getPassw() {
		return passw;
	}


	public void setPassw(int passw) {
		this.passw = passw;
	}



	
}
