/**
 * 
 */
package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Taylor
 *
 */
public class VendingMachineItemTest {

	/**
	 * @throws java.lang.Exception
	 */
	private VendingMachineItem item;
	final String NAME = "Test";
	final double PRICE = 5.56;
	
	@Before
	public void setUp() throws Exception {
		item = new VendingMachineItem(NAME, PRICE);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		item = null;
	}

	/**
	 * Test method for VendingMachineItem Constructor.
	 */
	@Test
	public void testVendingMachineItem() {
		item = new VendingMachineItem(NAME, PRICE);
	}
	
	/**
	 * Test method for VendingMachineItem Constructor (with negative price input).
	 */
	@Test(expected = VendingMachineException.class)
	public void testVendingMachineItemNegitivePrice() {
		item = new VendingMachineItem("Negative Price Test", -4.54);
	}

	/**
	 * Test method for VendingMachineItem.getName().
	 */
	@Test
	public void testGetName() {
		assertEquals(NAME, item.getName());
	}

	/**
	 * Test method for VendingMachineItem.getPrice().
	 */
	@Test
	public void testGetPrice() {
		assertEquals(PRICE, item.getPrice(), .001);
	}

}
