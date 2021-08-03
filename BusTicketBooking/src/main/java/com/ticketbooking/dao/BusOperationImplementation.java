package com.ticketbooking.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ticketbooking.exceptions.BusNumberException;
import com.ticketbooking.entity.Bus;

public class BusOperationImplementation implements BusOperations {
	Scanner sc =new Scanner(System.in);
	// crerate list to store busdetails
	List<Bus> buses = new ArrayList<Bus>();
	Bus bus = new Bus();
	 private static Logger logger = Logger.getLogger("StartApp");
	@Override
	public int addBusDetails(Bus bus) throws BusNumberException {
					
				//check if already the busnumber exists
				int result = 1;
				for(Bus buslist : buses ) {
					if(bus.getNumber() == buslist.getNumber()) {
						result = 0;
						logger.warn("Bus number already exists");
						throw new BusNumberException("Bus number already exists");
					}
	}
				if(result == 1) {
					buses.add(bus);
				}
						
		    return result;
	}
	
	@Override
	public int updateBusDetails(int busNumber) throws BusNumberException {
		

		// using stramAPI to find the index of the busnumber to update
			Bus a= buses.stream()
			.filter(u-> busNumber==(u.getNumber()))
			.findAny()
			.orElse(null);
			
			
			if(a==null){
				throw new BusNumberException("Bus number doesn't exist");
			}
			//if the bus number exists update the fields in the list
		
			else{
				logger.info("Bus number exists");
				logger.info("Enter new Busnumber");
				int busnumber = sc.nextInt();
				int index=buses.indexOf(a);
				logger.info("Enter bus name");
				String busname = sc.nextLine();
				sc.nextLine();
				logger.info("Enter the number of seats");
				int number = sc.nextInt();
				Bus bus = new Bus(busnumber, busname, number);
				buses.set(index, bus);
				logger.info(buses);
			}
			return 1;
			
	}

	@Override
	public int deleteBusDetails(int busNumber) {
		
		       // using stramAPI to find the index of the busnumber to delete
				Bus a= buses.stream()
						.filter(u-> busNumber==(u.getNumber()))
						.findAny()
						.orElse(null);
				
				
				if(a==null){
					logger.warn("Bus number doesn't exist");
					
				}
				else {
					int index=buses.indexOf(a);
					buses.remove(index);
				}
				
				return 0;
			

	}

	@Override
	public int viewBusDetails(Bus bus_list) {
		logger.info(buses);
		return 0;
	}

}
