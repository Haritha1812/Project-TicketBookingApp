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
				
			      try {
				int	 res =busdetails.addBusDetails(bus1);
				if(res == 1) {
					logger.info("Your bus details are added successfully");
				}
				else {
					logger.warn("Your bus details are not added successfully");
				}
				}
			      catch (BusNumberException e) {
					
					
			    	  logger.error(e.getMessage());
				}
			      
				break;
			case 2:
				System.out.println("Enter the bus number to remove");
			    int busNo = sc.nextInt();
			    busdetails.deleteBusDetails(busNo);
			    logger.info("Bus number :"+busNo+" deleted successfully");
			    break;
			case 3:
				
				logger.info("Enter bus number to update");
				int a=sc.nextInt();
				try {
					busdetails.updateBusDetails(a);
					logger.info("Busdetails updated successfully");
				} catch (BusNumberException e) {
					
					logger.info(e.getMessage());
					logger.warn("Bus details not updated..");
				}
				break;
			case 4:
				logger.info("Bus ddetails are");
				busdetails.viewBusDetails(bus );
				break;
				
			case 5:
				System.exit(0);
				
			}
		}
		
	}
	public static void main(String[] args) {
		
	}
			}
		
	
