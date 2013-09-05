package com.stx.s1.p175;

/**
 * 汽车类
 * 
 * @author getan
 *
 */
public class Car {

	private int speed;
	
	private String color;

	public void brake() {
		speed -= 10;
	}

	public void boost() {
		speed += 10;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * 启动汽车
	 */
	public void run(){
		// 实例方法中调用其他实例方法
		// boost();
	}
	
	/**
	 * 默认无参构造方法
	 */

	
	/**
	 * 构造方法(设置初始速度)
	 * 
	 * @param initSpeed
	 */

	
	/**
	 * 构造方法(设置初始速度和初始颜色)
	 * @param initSpeed
	 * @param initColor
	 */
	public Car(int initSpeed, String initColor) {
		// TODO

		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
