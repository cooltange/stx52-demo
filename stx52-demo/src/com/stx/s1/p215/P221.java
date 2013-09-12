package com.stx.s1.p215;

/**
 * try/catch 综合实例
 * 
 * @author getan
 * 
 */
public class P221 {

	public static void main(String args[]) {
		try {
			String number = args[0];// 尝试修改args[0]为其他字符串常量 如 "5","abc"...
			int numValue = Integer.parseInt(number);
			if (numValue < 0) {
				throw new Exception("太小");
			}
			System.out.println("平方结果 :" + numValue * numValue);
		} catch (ArrayIndexOutOfBoundsException ne) {
			System.out.println("没有参数！");
		} catch (NumberFormatException nb) {
			System.out.println("不是数字格式！");
		} catch (Exception e) {
			System.out.println("有错误发生！");
		}
	}
}
