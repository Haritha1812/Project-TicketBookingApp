package com.ticketbooking.dao;

import java.util.List;

import com.ticketbooking.exceptions.BusNumberException;
import com.ticketbooking.entity.Bus;


public interface BusOperations {
//declaring the methods 
	public Integer addBusDetails(Bus bus ) throws BusNumberException;
    public Integer updateBusDetails(String busNumber) throws BusNumberException;
	public Integer deleteBusDetails(String busNumber);
	public Bus     viewBusDetails(String BusNumber);
	public Integer isBusExists(String busumber);
}
