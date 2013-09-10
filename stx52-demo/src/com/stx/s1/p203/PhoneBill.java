package com.stx.s1.p203;

/**
 * 话费账单类(子类)
 * 
 * @author getan
 * 
 */
public class PhoneBill extends Bill {
	PhoneBill() {
		name = "PhoneBill";
		amount = 200;
	}

	public String getCallRecords() {
		return "这是通话记录列表......";
	}

	// 重写父类的print()方法
	public void print() {
		System.out.println(name);
		System.out.println(amount + "元");
		System.out.println(getCallRecords());
	}
}
