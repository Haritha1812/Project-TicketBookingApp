package com.ticketbooking.dao;

import java.util.List;

import com.ticketbooking.exceptions.UserNameException;
import com.ticketbooking.entity.Bus;
import com.ticketbooking.entity.PassengerAccount;

public interface PassengerAccountOperations {
	public int addUserDetails(PassengerAccount passengerAccounts ) throws UserNameException;
    public int updateUserDetails(String UserName)throws UserNameException;
	public int deleteUserDetails(String UserName) ;
	public void viewUserDetails();
	
}
