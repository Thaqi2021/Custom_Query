package com.dynamicQuery.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	int id;
	
	String name;
	String age;
	String desig;
	String expense;
	Date date;
	long mobno;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
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
	
	
	
	
}
