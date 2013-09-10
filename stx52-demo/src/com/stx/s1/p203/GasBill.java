package com.stx.s1.p203;

/**
 * 燃气账单类(子类)
 * 
 * @author getan
 * 
 */
public class GasBill extends Bill {

	GasBill() {
		name = "燃气费用详细账单";
		amount = 100;

	}

	public String getGasNum() {
		return "这是燃气数 60方";
	}

	// 重写父类的print()方法
	public void print() {
		System.out.println(name);
		System.out.println(amount + "元");
		System.out.println(getGasNum());
	}

}
