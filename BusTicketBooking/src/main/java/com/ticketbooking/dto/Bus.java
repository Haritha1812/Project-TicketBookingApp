package com.ticketbooking.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bus {
// creating the fields of the bus
	private  String number;
	private String name;
	private int numberOfSeats;
	private Date createdTime;
	private Date updatedTime;
	//constructor to set values to the fields

	public Bus(String number, String name, int numberOfSeats, Date createdTime, Date updatedTime) {
		super();
		this.number = number;
		this.name = name;
		this.numberOfSeats = numberOfSeats;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}


	
	public Bus() {
		// TODO Auto-generated constructor stub
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getNumberOfSeats() {
		return numberOfSeats;
	}



	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}



	public Date getcreatedTime() {
		return createdTime;
	}



	public void setcreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}



	public Date getupdatedTime() {
		return updatedTime;
	}



	public void setupdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}



	@Override
	public String toString() {
		return "Bus [number=" + number + ", name=" + name + ", numberOfSeats=" + numberOfSeats + ", createdTime="
				+ createdTime + ", updatedTime=" + updatedTime + "]";
	}




	
}