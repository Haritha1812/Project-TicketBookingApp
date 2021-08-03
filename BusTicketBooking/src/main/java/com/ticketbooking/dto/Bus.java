package com.ticketbooking.dto;

import java.util.ArrayList;
import java.util.List;

public class Bus {
// creating the fields of the bus
	private  int number;
	private String name;
	private int numberOfSeats;
	List<Bus> bus_list = new ArrayList<Bus>();
	//constructor to set values to the fields
	public Bus(int busNumber, String busname, int numberOfSeats) {
		
		this.number = busNumber;
		this.name = busname;
		this.numberOfSeats = numberOfSeats;
	}

	// getter setter method to get the value of the fields
	public Bus() {
		
	}

	public  int getNumber() {
		return number;
	}

	public void setNumber(int busNumber) {
		this.number = busNumber;
	}

	public String getBusName() {
		return name;
	}

	public void setBusName(String busName) {
		this.name = busName;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public String toString() {
		return "\n Bus [number=" + number + ", busName=" + name + ", numberOfSeats=" + numberOfSeats + "]";
	}


	
}
