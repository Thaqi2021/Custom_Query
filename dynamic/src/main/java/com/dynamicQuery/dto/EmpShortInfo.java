package com.dynamicQuery.dto;

import java.util.Date;

public class EmpShortInfo {
	Integer id;
	String name;
	String desig;
	Date date;
	long mobno;
	
	
	public EmpShortInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public EmpShortInfo(Integer id, String name, String desig, Date date, long mobno) {
		super();
		this.id = id;
		this.name = name;
		this.desig = desig;
		this.date = date;
		this.mobno = mobno;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public long getMobno() {
		return mobno;
	}



	public void setMobno(long mobno) {
		this.mobno = mobno;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	
	

}
