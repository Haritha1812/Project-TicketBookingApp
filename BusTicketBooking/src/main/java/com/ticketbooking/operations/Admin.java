package com.ticketbooking.operations;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;

import org.apache.log4j.Logger;

import com.ticketbooking.exceptions.BusNumberException;
import com.app.StartApp;
import com.ticketbooking.dao.BusOperationImplementation;
import com.ticketbooking.dao.BusOperations;
import com.ticketbooking.entity.Bus;

public class Admin   {
	static Scanner sc = new Scanner(System.in);

	public void adminOperations() {
	
		 BusOperations busdetails = new BusOperationImplementation();
		 // creating logger for logging the levels info,warn and error.
		 Logger logger = Logger.getLogger("Admin");
         logger.info("WELCOME TO THE ADMIN PORTAL");
         Integer result;
         Integer check;
         try {
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
			
			switch (choice) {
			case 1:
				
			    	    logger.info("Enter Bus number");
						String busNumber= sc.next();
						logger.info("Enter bus name");
						String busName = sc.next();
						sc.nextLine();
						logger.info("Enter the number of seats");
						int number = sc.nextInt();
						Bus bus1 = new Bus(busNumber, busName, number,new Date(),new Date());

					    try {
						check = busdetails.isBusExists(busNumber);
			    	    //check if the bus number already exists in the database if not then will add details in the database
			    	    if(check.equals(0)) {
				           result = busdetails.addBusDetails(bus1);
				     	if(result.equals(1)) {
						logger.info("Your bus details are added successfully");
					    }
				    	else {
						logger.warn("Your bus details are not added successfully");
					    }
			    	    }
			    	 
			    	    else  {
			    		  throw new BusNumberException();
			    	    }
			    	  
				         }
			                catch (BusNumberException e) {
			    	        logger.error("Bus number already exists");
				         }
				      break;
			case 2:
				System.out.println("Enter the bus number to remove");
				String busNo = sc.next();
			    
				check = busdetails.isBusExists(busNo);
			    if(check.equals(1)) {
			    	// calling delete bus details method
			    result =busdetails.deleteBusDetails(busNo);
			    
			    if(result.equals(1))
			    logger.info("Bus number :"+busNo+" deleted successfully");
			    else
			    	 logger.warn("Bus number :"+busNo+" not deleted successfully");
			    }
			    else {
			    	logger.warn("Busnumber doesn't exists");
			    }
			    break;
			    
			case 3:
				
				logger.info("Enter bus number to update");
				String a=sc.next();
				check = busdetails.isBusExists(a);
				// method to update bus details
				try {
					if(check.equals(1)) {
				result=	busdetails.updateBusDetails(a);
				if(result.equals(1)) {
					logger.info("Busdetails updated successfully");
				}
				else {
					logger.warn("Bus details not updated successfully");
				}}
					else {
						throw new BusNumberException();
				    }
				} catch (BusNumberException e) {
					
					logger.error("Bus number doesn't exist");
									}
				break;
			case 4:
				logger.info("Enter bus number to view");
				String no=sc.next();
				check = busdetails.isBusExists(no);
				 if(check.equals(1)) {
				logger.info("Bus details of Busnumber: "+no);
				bus = busdetails.viewBusDetails(no);
				 }
				else {
			    	logger.error("Busnumber doesn't exists");
			    }
				break;
				
			case 5:
				System.exit(0);
				
			}
		 }
         }
		 catch(InputMismatchException e) {
			 logger.error("Input doesn't match .Check the value correctly.");
			 
		 }
		}
		
	}
	
			
		
	
