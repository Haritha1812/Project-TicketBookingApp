package com.ticketbooking.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ticketbooking.dao.PassengerAccountOperationsImplementation;
import com.ticketbooking.exceptions.UserNameException;
import com.ticketbooking.entity.PassengerAccount;

public class Passenger {
	
	public void passengerOperations() {
		Scanner sc = new Scanner(System.in);
		 Logger logger = Logger.getLogger("Admin");
		PassengerAccount passengerAccount = new PassengerAccount();
				
					PassengerAccountOperationsImplementation userdetails = new PassengerAccountOperationsImplementation();
					List<PassengerAccount> passengerAccounts = new ArrayList<PassengerAccount>();
					
					logger.debug("Welcome to the PassengerAccount Portal");
					boolean exists ;
					while(true) {
							logger.info("#######M E N U#######");
							logger.info("1.Create Details ");
							logger.info("2.Delete Details ");
							logger.info("3.Update Details ");
							logger.info("4.View Details ");
							logger.info("Enter your choice : ");
							int choice = sc.nextInt();
							PassengerAccount bus = new PassengerAccount();
							switch (choice) {
							case 1:
								logger.info("Enter your phone number");
							  String PhoneNUmber= sc.next();
								logger.info("Enter your name");
								String Name = sc.next();
								sc.nextLine();
								logger.info("Enter the address");
								String address = sc.next();
								logger.info("Enter the mail Id");
								String emailId = sc.next();
								PassengerAccount passengerAccount2 = new PassengerAccount(PhoneNUmber, Name, address, emailId);
								exists = userdetails.ispassengerExists(emailId);
								try {
									if(exists == false) {
									boolean res = userdetails.addUserDetails(passengerAccount2);
									if(res) {
									logger.info("Your account has been successfully created.");
									}
									else {
										logger.warn("Your account is not created .");
									}
									}
									else {
										logger.warn("Emailid already exists");
									}
								} catch (UserNameException e) {
									
									
									logger.error(e.getMessage());
								}
								
								break;
							case 2:
								logger.info("Enter the passengerAccount emailid to remove");
							    String useremail = sc.next();
							   boolean exist = userdetails.ispassengerExists(useremail);
							   if(exist == true) {
							   userdetails.deleteUserDetails(useremail);
							    logger.info("Passenger account "+useremail+" deleted successfully");
							   }
							   else {
									logger.warn("Emailid doesn't exists");
								}
							   
							    break;
							case 3:
								
								logger.info("Enter the passengerAccount email to update");
								String a=sc.next();
								boolean result = userdetails.ispassengerExists(a);
								   
								
								try {
									if(result == true) {
									userdetails.updateUserDetails(a);
									logger.info("Passenger account updated successfully.");
									}
									 else {
											logger.warn("Emailid doesn't exists");
										}
									   
									} catch (UserNameException e) {
									logger.error(e.getMessage());
									logger.warn("Passenger account not updated successfully.");
								}
								
								break;
							case 4:
								
								logger.info("Enter the emailId to view the account");
								String e=sc.next();
								boolean value = userdetails.ispassengerExists(e);
								  if(value == true) {
								userdetails.viewUserDetails(e);
								  }
								  else {
										logger.warn("Emailid doesn't exists");
									}
								  
								break;
								
							}
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 

}
}
