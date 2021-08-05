package com.ticketbooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ticketbooking.exceptions.UserNameException;
import com.ticketbooling.util.DBConnection;
import com.ticketbooking.entity.Bus;
import com.ticketbooking.entity.PassengerAccount;

public class PassengerAccountOperationsImplementation implements PassengerAccountOperations {

	Connection connection = DBConnection.getDBConnection();
	
PassengerAccount passengerAccount = new PassengerAccount();
Scanner sc = new Scanner(System.in);
private static Logger logger1= Logger.getLogger("StartApp");

private final String ADD_PASSENGER_DETAILS_QUERY = "insert into hr.passenger values(?,?,?,?)";
private final String DELETE_PASSENGER__DETAILS_QUERY = "delete from hr.passenger where emailId=?";
private final String UPDATE_PASSENGER__DETAILS_QUERY = "update hr.passenger set phoneNumber =?,name =?,address=? where emailId =? ";
private final String VIEW_PASSENGER_DETAILS_QUERY = "select * from hr.passenger where emailId = ?";

PassengerAccount passeAccount = new PassengerAccount();
private static Logger logger = Logger.getLogger("PassengerAccountOperationsImplementation");



	@Override
	public boolean addUserDetails(PassengerAccount passengerAccount) throws UserNameException  {
		
		
		int result = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(ADD_PASSENGER_DETAILS_QUERY);
			statement.setInt(1, passengerAccount.getPhoneNumber());
			statement.setString(2, passengerAccount.getName());
			statement.setString(3,passengerAccount.getAddress());
			statement.setString(4,passengerAccount.getEmailId());
			result = statement.executeUpdate();
		}
		catch (SQLException e) {
			logger1.info("Email already exists");
		}
		
		if(result == 0)
			return false;
		else 
			return true;
    
	}

	
	
	@Override
	public boolean updateUserDetails(String emailID) throws UserNameException{
		int res =0;
		logger.info("Enter the mail Id");
		String emailId = sc.next();
		logger.info("Enter your phone number");
		int userPhoneNUmber= sc.nextInt();
		logger.info("Enter your name");
		String userName = sc.next();
		sc.nextLine();
		logger.info("Enter the address");
		String address = sc.next();
		
		PassengerAccount user1 =  new PassengerAccount(userPhoneNUmber, userName, address, emailId);
		int result = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(UPDATE_PASSENGER__DETAILS_QUERY);
			statement.setInt(1, passengerAccount.getPhoneNumber());
			statement.setString(2, passengerAccount.getName());
			statement.setString(3,passengerAccount.getAddress());
			statement.setString(4,passengerAccount.getEmailId());
			result = statement.executeUpdate();
			
		}
		catch (SQLException e) {
			
		}
		
		if(res== 0)
			return false;
		else 
			return true;
    
		
	}

	@Override
	public boolean deleteUserDetails(String emailId) {
		int res =0;
		PreparedStatement st;
		try {
			st = connection.prepareStatement(DELETE_PASSENGER__DETAILS_QUERY);
			st.setString(1, emailId);
			res = st.executeUpdate();
		}catch (SQLException e) {
			
		}
		
		if(res == 0)
			return false;
		else 
			return true;
    
	}
	

	@Override
	public PassengerAccount viewUserDetails() {
		logger1.info("Passenger Details");
		return passeAccount;
		
}



	


	@Override
	public boolean ispassengerExists(String emailId) {
		// TODO Auto-generated method stub
		return false;
	}




	

}
