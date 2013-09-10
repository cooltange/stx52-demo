package com.stx.s1.p203;

/**
 * 使用多态的方式实现打印各类账单 演示类
 * 
 * @author getan
 * 
 */
public class Runner2 {
	public static void main(String[] args) {
		Bill phoneBill = new PhoneBill();
		Bill gasBill = new GasBill();

		// 打印话费账单明细
		phoneBill.print();
		
		System.out.println("--------------------");
		
		// 打印燃气费账单明细
		gasBill.print();
	}

}
