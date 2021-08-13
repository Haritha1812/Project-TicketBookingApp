package com.app;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.ticketbooking.operations.Admin;
import com.ticketbooking.operations.Passenger;

public class StartApp {
	 private Logger logger = Logger.getLogger("StartApp");
	 Scanner sc = new Scanner(System.in);
     Admin admin = new Admin();
     Passenger passenger = new Passenger();
     public void startApp() {
    	 try {
    		 
		 while(true) {
			logger.info("1.AdminView");
			logger.info("2.PassengerView");
			logger.info("Enter the option 1/2.");
			
			int option = sc.nextInt();
			
			
			switch (option){
			
			case 1:
			admin.adminOperations();
			break;
			
			case 2:
			passenger.passengerOperations();
			break;
			}
			}
			
		}
    	 catch(InputMismatchException e)
			{
				logger.error("Input doesn't match .Check the value correctly.");
				System.exit(0);
			}
   }   
}
