package com.ticketbooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
private final String DELETE_PASSENGER__DETAILS_QUERY = "delete from hr.passenger where emailid=?";
private final String UPDATE_PASSENGER__DETAILS_QUERY = "update hr.passenger set phoneNumber=?,passengername=?,address=? where emailId=?";
private final String VIEW_PASSENGER_DETAILS_QUERY = "select * from hr.passenger where emailId = ?";

PassengerAccount passeAccount = new PassengerAccount();
private static Logger logger = Logger.getLogger("PassengerAccountOperationsImplementation");



	@Override
	public boolean addUserDetails(PassengerAccount passengerAccount2) throws UserNameException  {
		
		
		int result = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(ADD_PASSENGER_DETAILS_QUERY);
			statement.setString(1, passengerAccount2.getPhoneNumber());
			statement.setString(2, passengerAccount2.getName());
			statement.setString(3,passengerAccount2.getAddress());
			statement.setString(4,passengerAccount2.getEmailId());
			result = statement.executeUpdate();
		}
		catch (SQLException e) {
			//logger1.info("Email already exists");
		}
		
		if(result == 0)
			return false;
		else 
			return true;
    
	}

	
	
	@Override
	public boolean updateUserDetails(String emailID) throws UserNameException{
		
		logger.info("Enter your phone number");
		String userPhoneNUmber= sc.next();
		logger.info("Enter your name");
		String userName = sc.next();
		sc.nextLine();
		logger.info("Enter the address");
		String address = sc.next();
		
		
		int result = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(UPDATE_PASSENGER__DETAILS_QUERY);
			statement.setString(1, userPhoneNUmber);
			statement.setString(2, userName);
			statement.setString(3,address);
			statement.setString(4,emailID);
			result = statement.executeUpdate();
			
		}
		catch (SQLException e) {
			
		}
		
		if(result== 0)
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
	public PassengerAccount viewUserDetails(String emailid) {
		PassengerAccount passengerAccount = null;
		List<PassengerAccount> passengeraccounts = new ArrayList<PassengerAccount>();
		
		PreparedStatement st;
		try {
			st = connection.prepareStatement(VIEW_PASSENGER_DETAILS_QUERY);
			st.setString(1,emailid);
			ResultSet resultset = st.executeQuery();
			passengerAccount = new PassengerAccount();
			while(resultset.next())
			{
				
				passengerAccount.setPhoneNumber(resultset.getString(1));
				passengerAccount.setName(resultset.getString(2));
				passengerAccount.setAddress(resultset.getString(3)); 
				 passengerAccount.setEmailId(resultset.getString(4));
			}
			
		
		
		} catch (SQLException e) {
			logger.error("User mailid doesn't exist");
		}
		logger.info(passengerAccount);
		return passengerAccount;
		
}



	


	@Override
	public boolean ispassengerExists(String emailId) {
		
		
boolean result = false;
		
		try {
			PreparedStatement st = connection.prepareStatement("Select * from hr.passenger where emailid = ?");
			st.setString(1,emailId);
			ResultSet res = st.executeQuery();
			if(res.next()) {
				result = true;
			}
		}
			catch(SQLException e){
				
				
			}
			return result;
		}
	
		
		
		
		
		
		
	}




	


