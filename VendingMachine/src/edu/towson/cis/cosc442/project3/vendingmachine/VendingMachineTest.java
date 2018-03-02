package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	VendingMachine vm;
	VendingMachineItem item;
	VendingMachineItem expensiveItem;
	final double MONEY = 78.23;

	@Before
	public void setUp() throws Exception {
		vm = new VendingMachine();
		item = new VendingMachineItem("Test", 5.78);
		expensiveItem = new VendingMachineItem("Expensive Item", 100000.48);
		vm.addItem(item, "A");
		vm.addItem(expensiveItem, "D");
		vm.insertMoney(MONEY);
	}

	@After
	public void tearDown() throws Exception {
		vm = null;
		item = null;
		expensiveItem = null;
	}
	
	// ADD ITEM TESTS
	
	// Tests if addItem will properly add item
	@Test
	public void testAddItem() {
		vm.addItem(item, "B");
		assertEquals(item, vm.getItem("B"));
	}
	
	// Tests addItem() when slot already has item
	@Test(expected = VendingMachineException.class)
	public void testAddItemFilledSlot() {
		vm.addItem(item, "C");
		vm.addItem(item, "C");
	}
	
	// Tests addItem() to a slot that doesn't exist
	@Test(expected = VendingMachineException.class)
	public void testAddItemInvalidSlot() {
		vm.addItem(item, "E");
	}
	
	// REMOVE ITEM TESTS

	// Tests if removeItem() will properly remove an item
	@Test
	public void testRemoveItem() {
		assertEquals(item, vm.removeItem("A"));
	}
	
	// Tests removeItem() when slot has no item
	@Test(expected = VendingMachineException.class)
	public void testRemoveItemFilledSlot() {
		vm.removeItem("C");
	}
	
	// Tests removeItem() to a slot that doesn't exist
	@Test(expected = VendingMachineException.class)
	public void testRemoveItemInvalidSlot() {
		vm.removeItem("E");
	}
	
	// INSERT MONEY TESTS

	// Tests if insertMoney() will properly insert money
	@Test
	public void testInsertMoney() {
		vm.insertMoney(45.78);
		assertEquals(45.78 + MONEY, vm.balance, .001);
	}
	
	// Tests insertMoney() to make sure that negative money cannot be inserted
	@Test(expected = VendingMachineException.class)
	public void testInsertNegativeMoney() {
		vm.insertMoney(-1.45);
	}

	// GET BALANCE TESTS
	
	// Tests if getBalance() will return the Vending Machine balance
	@Test
	public void testGetBalance() {
		assertEquals(vm.balance, vm.getBalance(), .001);
	}
	
	// MAKE PURCHASE TESTS

	// Tests if makePurchase() will properly purchase an item
	@Test
	public void testMakePurchase() {
		assertTrue(vm.makePurchase("A"));
	}
	
	// Tests if makePurchase() won't purchase an item out of budget
	@Test
	public void testMakePurchaseCantAfford() {
		assertFalse(vm.makePurchase("D"));
	}
	
	// Tests makePurchase() when slot has no item
	@Test
	public void testMakePurchaseEmptySlot() {
		assertFalse(vm.makePurchase("C"));
	}
	
	// Tests makePurchase() to a slot that doesn't exist
	@Test(expected = VendingMachineException.class)
	public void testMakePurchaseInvalidSlot() {
		vm.makePurchase("E");
	}

	// RETURN CHANGE TESTS
	
	// Tests if returnChange() will properly return the change amount
	@Test
	public void testReturnChange() {
		assertEquals(MONEY, vm.returnChange(), .001);
	}

}
