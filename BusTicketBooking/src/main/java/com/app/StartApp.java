package com.app;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ticketbooking.operations.Admin;
import com.ticketbooking.operations.Passenger;

public class StartApp {
	static Scanner sc = new Scanner(System.in);
   static Admin admin = new Admin();
   static Passenger passenger = new Passenger();
   private static Logger logger = Logger.getLogger("StartApp");
	public static void main(String[] args) {
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
}
