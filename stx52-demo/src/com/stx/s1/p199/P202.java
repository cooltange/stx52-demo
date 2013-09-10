package com.stx.s1.p199;

/**
 * 类型变换
 * 
 * @author getan
 * 
 */
public class P202 {

	public static void main(String[] args) {
		// 向上变换(自动转换)
		Duck duck = new DonaDuck();

		// 检测duck对象是否为唐老鸭类的对象
		if (duck instanceof DonaDuck) {
			// 向下变换(强制转换)
			DonaDuck dona = (DonaDuck) duck;

			dona.greet();
		}

	}

}
