package com.stx.s1.p203;

/**
 * 账单类(父类)
 * 
 * @author getan
 *
 */
public class Bill {

	Bill() {
		name = "Bill";
		amount = 0;
	}

	protected String name;
	protected int amount = 0;

	public String getName() {
		return "This is " + name;
	}

	public int getAmount() {
		return amount;
	}

	public void print() {

	}

}
