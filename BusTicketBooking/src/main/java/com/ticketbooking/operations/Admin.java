package com.ticketbooking.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

import org.apache.log4j.Logger;

import com.ticketbooking.exceptions.BusNumberException;
import com.app.StartApp;
import com.ticketbooking.dao.BusOperationImplementation;
import com.ticketbooking.dao.BusOperations;
import com.ticketbooking.entity.Bus;

public class Admin {
	static Scanner sc = new Scanner(System.in);
	public void adminOperations() {
		 BusOperations busdetails = new BusOperationImplementation();
		 // creating logger for logging the levels info,warn and error.
		 Logger logger = Logger.getLogger("Admin");
         List<Bus> buses = new ArrayList<Bus>();
         logger.debug("WELCOME TO THE ADMIN PORTAL");
	
		while (true) {
			
			logger.info("#######M E N U#######");
			logger.info("1.Create BusDetails ");
			logger.info("2.Delete BusDetails ");
			logger.info("3.Update BusDetails ");
			logger.info("4.View BusDetails ");
			logger.info("5.Exit ");
			logger.info("Enter your choice : ");
			int choice = sc.nextInt();
			Bus bus = new Bus();
			boolean result;
			switch (choice) {
			case 1:
				logger.info("Enter Bus number");
				int busnumber= sc.nextInt();
				logger.info("Enter bus name");
				String busname = sc.next();
				sc.nextLine();
				logger.info("Enter the number of seats");
				int number = sc.nextInt();
				Bus bus1 = new Bus(busnumber, busname, number);
				boolean exists = busdetails.isBusExists(busnumber);
			      try {
			    	  //check if the busnumber already exists in the database if not then will add details in the fatabase
			    	  if(exists == false) {
				       result    =busdetails.addBusDetails(bus1);
				   	if(result) {
						logger.info("Your bus details are added successfully");
					}
				   	else {
						logger.warn("Your bus details are not added successfully");
					}
			    	  }
			    	 
				
				}
			      catch (BusNumberException e) {
					
					
			    	  logger.error(e.getMessage());
				}
			      
				break;
			case 2:
				System.out.println("Enter the bus number to remove");
			    int busNo = sc.nextInt();
			    // calling deletebusdetails method
			    result =busdetails.deleteBusDetails(busNo);
			    
			    if(result)
			    logger.info("Bus number :"+busNo+" deleted successfully");
			    else
			    	 logger.warn("Bus number :"+busNo+" not deleted successfully");
			    break;
			case 3:
				
				logger.info("Enter bus number to update");
				int a=sc.nextInt();
				// method to update bus details
				try {
				result=	busdetails.updateBusDetails(a);
				if(result) {
					logger.info("Busdetails updated successfully");
				}
				else {
					logger.warn("Bus details not updated successfully");
				}
				} catch (BusNumberException e) {
					
					logger.info(e.getMessage());
					logger.warn("Bus details not updated..");
				}
				break;
			case 4:
				logger.info("Enter bus number to view");
				int no=sc.nextInt();
				logger.info("Bus details of Busnumber: "+no);
				bus = busdetails.viewBusDetails(no);
				if(bus == null) {
					logger.error("Bus number doesn't exist");
				}
				break;
				
			case 5:
				System.exit(0);
				
			}
		}
		
	}
	public static void main(String[] args) {
		
	}
			}
		
	
