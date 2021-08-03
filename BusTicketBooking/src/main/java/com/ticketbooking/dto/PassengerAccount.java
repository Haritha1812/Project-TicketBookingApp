package com.ticketbooking.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PassengerAccount {
	
	List<PassengerAccount> passengerAccounts = new ArrayList<>();
	private  int phoneNumber;
	private String name ;
	private String address;
	private String emailId;
	public int getUserPhoneNumber() {
		return phoneNumber;
	}
	public void setUserPhoneNumber(int userPhoneNumber) {
		this.phoneNumber = userPhoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String userName) {
		this.name = userName;
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
	public PassengerAccount(int phoneNumber, String userName, String address, String emailId) {
		super();
		this.phoneNumber = phoneNumber;
		this.name = userName;
		this.address = address;
		this.emailId = emailId;
	}
	public PassengerAccount() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "\n PassengerAccount [phoneNumber=" + phoneNumber + ", name=" + name + ", address=" + address
				+ ", emailId=" + emailId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, emailId, name, phoneNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassengerAccount other = (PassengerAccount) obj;
		return Objects.equals(address, other.address) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(name, other.name) && phoneNumber == other.phoneNumber;
	}
	
}
