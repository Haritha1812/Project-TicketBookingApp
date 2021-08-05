package com.ticketbooking.dao;

import java.util.List;

import com.ticketbooking.exceptions.UserNameException;
import com.ticketbooking.entity.Bus;
import com.ticketbooking.entity.PassengerAccount;

public interface PassengerAccountOperations {
	public boolean addUserDetails(PassengerAccount passengerAccounts ) throws UserNameException;
    public boolean updateUserDetails(String UserName)throws UserNameException;
	public boolean deleteUserDetails(String UserName) ;
	public PassengerAccount viewUserDetails();
	public boolean ispassengerExists(String emailId);
	
}
