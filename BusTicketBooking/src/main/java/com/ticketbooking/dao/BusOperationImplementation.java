package com.ticketbooking.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ticketbooking.exceptions.BusNumberException;
import com.ticketbooling.util.DBConnection;
import com.ticketbooking.entity.Bus;

public class BusOperationImplementation implements BusOperations {
	
	Connection connection = DBConnection.getDBConnection();
	Scanner sc =new Scanner(System.in);
	// crerate prepared statement to store busdetails in database

private final String ADD_BUS_DETAILS_QUERY = "insert into hr.Bus values(?,?,?)";
private final String DELETE_BUS__DETAILS_QUERY = "delete from hr.Bus where numberplate=?";
private final String UPDATE_BUS__DETAILS_QUERY = "update hr.Bus set busname=?,numberofseats=? where numberplate=?";
private final String VIEW_BUS__DETAILS_QUERY = "select * from hr.Bus where numberplate=?";

	
	Bus bus = new Bus();
	 private static Logger logger = Logger.getLogger("StartApp");
	@Override
	public boolean addBusDetails(Bus bus) throws BusNumberException {
			
				int result = 0;
				try {
					PreparedStatement statement = connection.prepareStatement(ADD_BUS_DETAILS_QUERY);
					statement.setInt(1, bus.getNumber());
					statement.setString(2, bus.getName());
					statement.setInt(3,bus.getNumberOfSeats());
					result = statement.executeUpdate();
				}
				catch (SQLException e) {
					logger.info("Bus number already exists");
				}
				
				if(result == 0)
					return false;
				else 
					return true;
		    
	}
	//method to update bus details
	@Override
	public boolean updateBusDetails(int busNumber) throws BusNumberException {
		int res =0;
		logger.info("Enter Bus number");
		int busnumber= sc.nextInt();
		logger.info("Enter bus name");
		String busname = sc.next();
		sc.nextLine();
		logger.info("Enter the number of seats");
		int number = sc.nextInt();
		Bus bus1 = new Bus(busnumber, busname, number);
		
		try {
			PreparedStatement statement = connection.prepareStatement(UPDATE_BUS__DETAILS_QUERY);
			statement.setInt(2,bus1.getNumberOfSeats());
			statement.setString(1, bus1.getName());
			statement.setInt(3,bus1.getNumber());
			res = statement.executeUpdate();
			
			
		}
		catch (SQLException e) {
			
		}
		
		if(res== 0)
			return false;
		else 
			return true;
    

		
			
	}
     // method to delete the bus details
	@Override
	public boolean deleteBusDetails(int busNumber) {
	
		int res =0;
		PreparedStatement st;
		try {
			st = connection.prepareStatement(DELETE_BUS__DETAILS_QUERY);
			st.setInt(1, busNumber);
			res = st.executeUpdate();
		}catch (SQLException e) {
			
		}
		
		if(res == 0)
			return false;
		else 
			return true;
    
	}
     // method to view busdetails by busnumber
	@Override
	public Bus viewBusDetails(int BusNumber) {
		Bus bus = null;
		List<Bus> buses = new ArrayList<Bus>();
		
		try {
			PreparedStatement st = connection.prepareStatement(VIEW_BUS__DETAILS_QUERY);
			st.setInt(1, BusNumber);
			ResultSet resultset = st.executeQuery();
			bus = new Bus();
			while(resultset.next())
			{
				
				bus.setNumber(resultset.getInt(1));
				bus.setName(resultset.getString(2));
				bus.setNumberOfSeats(resultset.getInt(3));
				 buses.add(bus);
			}
		}
			catch (SQLException e) {
				logger.error("Bus number doesn't exist");
			}
		      
			logger.info(buses);
			return bus;
		
	

	}
	
	//check if already the busnumber exists
	public boolean isBusExists(int busumber) {
		boolean result = false;
		
		try {
			PreparedStatement st = connection.prepareStatement("Select * from hr.bus where numberplate = ?");
			st.setInt(1, busumber);
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


