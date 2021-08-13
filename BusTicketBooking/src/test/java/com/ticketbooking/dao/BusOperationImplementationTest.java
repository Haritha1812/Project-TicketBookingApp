package com.ticketbooking.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ticketbooking.entity.Bus;
import com.ticketbooking.exceptions.BusNumberException;

public class BusOperationImplementationTest {

	 BusOperations busdetails;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
      busdetails = new BusOperationImplementation();
	}

	@After
	public void tearDown() throws Exception {
		busdetails = null;
	}

	@Test
	public void testAddBusDetails() throws BusNumberException {
		String busnumber = "-1";
		Bus bus = new Bus(busnumber,"demo", 0, null, null);
		busdetails.addBusDetails(bus);
		Integer value =1;
		Integer result = busdetails.isBusExists(busnumber);
		assertEquals(value, result);
		
	}

	@Test
	public void testUpdateBusDetails() {
		
	}

	@Test
	public void testDeleteBusDetails() {
		String busnumber = "-1";
		busdetails.deleteBusDetails(busnumber);
		Integer value =1;
		Integer result = busdetails.isBusExists(busnumber);
		assertEquals(value, result);
	}

	@Test
	public void testViewBusDetails() {
		
	}

	@Test
	public void testIsBusExists() {
		
	}

}
