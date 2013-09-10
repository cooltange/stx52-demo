package com.stx.s1.p203;

/**
 * 使用非多态的方式实现打印各类账单 演示类
 * 
 * @author getan
 * 
 */
public class Runner1 {
	public static void main(String[] args) {
		Bill phoneBill = new PhoneBill();
		Bill gasBill = new GasBill();
		print(phoneBill);
		System.out.println("--------------------");
		print(gasBill);
	}

	public static void print(Bill bill) {
		System.out.println(bill.getName());
		System.out.println(bill.getAmount()  + "元");

		if (bill instanceof PhoneBill) {
			PhoneBill pb = (PhoneBill) bill;
			System.out.println(pb.getCallRecords());
		}
		if (bill instanceof GasBill) {
			GasBill gb = (GasBill) bill;
			System.out.println(gb.getGasNum());
		}
	}
}
