package com.ticketbooking.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.ticketbooking.exceptions.UserNameException;
import com.ticketbooking.entity.Bus;
import com.ticketbooking.entity.PassengerAccount;

public class PassengerAccountOperationsImplementation implements PassengerAccountOperations {
PassengerAccount passengerAccount = new PassengerAccount();
Scanner sc = new Scanner(System.in);
private static Logger logger = Logger.getLogger("StartApp");
List<PassengerAccount> passengerAccounts = new ArrayList<>();
	@Override
	public int addUserDetails(PassengerAccount passengerAccount) throws UserNameException  {
		
		int result = 1;
		for(PassengerAccount userlist:passengerAccounts) {
			if(passengerAccount.getName().equals(userlist.getName())) {
				result =0;		
				logger.warn("User name already exists");
            
			
			throw new UserNameException("UserName already exists");
                  
			}
		}
		if(result == 1) {
		passengerAccounts.add(passengerAccount);
		               }
		
	
		return result;
		
	}

	
	
	@Override
	public int updateUserDetails(String UserName) throws UserNameException{
		// using stramAPI to find the index of the username to update
		try {
					PassengerAccount a= passengerAccounts.stream()
							.filter(u-> UserName.equals(u.getName()))
							.findAny()
							.orElse(null);
					
					
					if(a==null){
						throw new UserNameException("Username doesn't exist");
					}
					//if the passengerAccount name exists update the fields in the list
				
					else{
						logger.info("Username exists");
						int index=passengerAccounts.indexOf(a);
						logger.info("Enter address");
						String address = sc.nextLine();
						sc.nextLine();
						logger.info("Enter the phonenumber");
						int number = sc.nextInt();
						logger.info("Enter emailID");
						String email = sc.nextLine();
						PassengerAccount passengerAccount = new PassengerAccount(number, UserName, address, email);
						passengerAccounts.set(index, passengerAccount);
						logger.info(passengerAccounts);
					}
		}
		 catch (UserNameException e) {
				
				logger.info(e.getMessage());
			}
			
					return 1;
	}

	@Override
	public int deleteUserDetails(String UserName) {
		PassengerAccount a= passengerAccounts.stream()
				.filter(u-> UserName.equals(u.getName()))
				.findAny()
				.orElse(null);
		
		
		if(a==null){
			logger.warn("Username doesn't exist");
			logger.error("Userdetails not deleted successfully");
		}
		else {
			int index=passengerAccounts.indexOf(a);
			passengerAccounts.remove(index);
			
			
		}
		
		return 0;
	
	}

	@Override
	public void viewUserDetails() {
		logger.info("Passenger Details");
		logger.info(passengerAccounts);
		
}




	

}
