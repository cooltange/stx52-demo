package com.stx.s1.p193;

/**
 * 苹果类
 * 
 * @author getan
 * 
 */
public class Apple extends Fruit {
	
	private String color ;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override //方法重写(覆盖)
	public void info() {
		System.out.println("我是一个苹果！重" + weight + "g！");
	}

}
