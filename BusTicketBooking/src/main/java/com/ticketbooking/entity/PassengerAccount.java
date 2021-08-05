package com.ticketbooking.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PassengerAccount {
	
	//List<PassengerAccount> passengerAccounts = new ArrayList<>();
	private  int phoneNumber;
	private String name ;
	private String address;
	private String emailId;
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public PassengerAccount(int phoneNumber, String name, String address, String emailId) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.address = address;
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "PassengerAccount [phoneNumber=" + phoneNumber + ", name=" + name + ", address=" + address + ", emailId="
				+ emailId + "]";
	}
	public PassengerAccount() {
		super();
	}

	
	
}
