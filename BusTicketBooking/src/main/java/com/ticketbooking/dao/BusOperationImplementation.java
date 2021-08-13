package com.ticketbooking.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ticketbooking.exceptions.BusNumberException;
import com.ticketbooling.util.DBConnection;
import com.ticketbooking.entity.Bus;

public class BusOperationImplementation implements BusOperations {
	
	Connection connection = DBConnection.getDBConnection();
	Scanner sc =new Scanner(System.in);
	Integer res =0;
	 
	//  prepared statement to store busdetails in database

private final String ADD_BUS_DETAILS_QUERY     = "insert into hr.Bus values(?,?,?,?,?)";
private final String DELETE_BUS__DETAILS_QUERY = "delete from hr.Bus where numberplate=?";
private final String UPDATE_BUS__DETAILS_QUERY = "update hr.Bus set  busname=?,numberofseats=?,updatedtime=?, numberplate=? where numberplate=?";
private final String VIEW_BUS__DETAILS_QUERY   = "select * from hr.Bus where numberplate=?";

	
	Bus bus = new Bus();
	 private static Logger logger = Logger.getLogger("StartApp");
	@Override
	public Integer addBusDetails(Bus bus) throws BusNumberException {
			
			
				
				try {
					PreparedStatement statement = connection.prepareStatement(ADD_BUS_DETAILS_QUERY);
					statement.setString(1, bus.getNumber());
					statement.setString(2, bus.getName());
					statement.setInt(3,bus.getNumberOfSeats());
					statement.setTimestamp(4,java.sql.Timestamp.from(java.time.Instant.now()));
					statement.setTimestamp(5, java.sql.Timestamp.from(java.time.Instant.now()));
					res = statement.executeUpdate();
				}
				catch (SQLException e) {
					
				}
				
				return res;
		    
	}
	//method to update bus details
	@Override
	public Integer updateBusDetails(String busNumber) throws BusNumberException {
		
		logger.info("Enter Bus number to change");
		String busNum= sc.next();
		logger.info("Enter bus name");
		String busName = sc.next();
		sc.nextLine();
		logger.info("Enter the number of seats");
		int number = sc.nextInt();
		Date date = new Date();
		try {
			PreparedStatement statement = connection.prepareStatement(UPDATE_BUS__DETAILS_QUERY);
			
			statement.setString(1,busName);
			statement.setInt(2,number);
			statement.setTimestamp(3, java.sql.Timestamp.from(java.time.Instant.now()));
			statement.setString(4,busNum);
			statement.setString(5,busNumber);
			res = statement.executeUpdate();
			
		}
		catch (SQLException e) {
			
		}
		
		return res;

		
			
	}
     // method to delete the bus details
	@Override
	public Integer deleteBusDetails(String busNumber) {
	
		
		PreparedStatement st;
		try {
			st = connection.prepareStatement(DELETE_BUS__DETAILS_QUERY);
			st.setString(1, busNumber);
			res = st.executeUpdate();
		}catch (SQLException e) {
			
		}
		
	return res;
	}
     // method to view busdetails by busnumber
	@Override
	public Bus viewBusDetails(String busNumber) {
		Bus bus = null;
		
		try {
			PreparedStatement st = connection.prepareStatement(VIEW_BUS__DETAILS_QUERY);
			st.setString(1, busNumber);
			ResultSet resultset = st.executeQuery();
			bus = new Bus();
			while(resultset.next())
			{
				
				bus.setNumber(resultset.getString(1));
				bus.setName(resultset.getString(2));
				bus.setNumberOfSeats(resultset.getInt(3));
				bus.setcreatedTime(resultset.getTimestamp(4));
				bus.setupdatedTime(resultset.getTimestamp(5));
				
			}
		}
			catch (SQLException e) {
				logger.error("Bus number doesn't exist");
			}
		      
			logger.info(bus);
			return bus;
		
	

	}
	
	//check if already the busnumber exists
	public Integer isBusExists(String busumber) {
		
		
		try {
			PreparedStatement st = connection.prepareStatement("Select * from hr.bus where numberplate = ?");
			st.setString(1, busumber);
			ResultSet result = st.executeQuery();
			if(result.next()) {
				res = 1;
			}
		}
			catch(SQLException e){
				
			}
			return res;
		}
	}


