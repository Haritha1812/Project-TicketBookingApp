package com.ticketbooking.dao;

import java.util.List;

import com.ticketbooking.exceptions.BusNumberException;
import com.ticketbooking.entity.Bus;


public interface BusOperations {
//declaring the methods 
	public int addBusDetails(Bus bus ) throws BusNumberException;
    public int updateBusDetails(int busNumber) throws BusNumberException;
	public int deleteBusDetails(int busNumber);
	public int viewBusDetails(Bus bus_list);
}
