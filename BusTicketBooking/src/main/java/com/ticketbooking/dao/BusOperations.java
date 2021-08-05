package com.ticketbooking.dao;

import java.util.List;

import com.ticketbooking.exceptions.BusNumberException;
import com.ticketbooking.entity.Bus;


public interface BusOperations {
//declaring the methods 
	public boolean addBusDetails(Bus bus ) throws BusNumberException;
    public boolean updateBusDetails(int busNumber) throws BusNumberException;
	public boolean deleteBusDetails(int busNumber);
	public Bus viewBusDetails(int BusNumber);
	public boolean isBusExists(int busumber);
}
