package com.stx.s1.p215;

/**
 * 异常的处理策略
 * 
 * @author getan
 * 
 */
public class P231 {

	public static void main(String[] args) {
		// try catch即"自行处理"异常策略
		try {
			hello("hehe"); // 参数可尝试修改为null
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用throws方式的"回避异常"策略<BR>
	 * 
	 * @param name
	 * @throws ClassCastException
	 * @throws ClassNotFoundException
	 */
	public static void hello(String name) throws ClassCastException,ClassNotFoundException { 
														  // throws 后声明的异常类们是指该在方法可能会抛出的多个异常
		// 以下代码无现实意义,纯粹演示语法,抛出两个不同的预期异常(checked exception)
		if (name == null) {
			throw new ClassCastException("类型装换异常");
		} else {
			throw new ClassNotFoundException("类未被发现异常");
		}
	}

}
