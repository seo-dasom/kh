package com.kh.test.shape.model.vo;

public class Circle {
	public static final double PI = Math.PI;		// public static final로 사용하는 것이 좋음(상수이기 때문에)
	private int radius;
	
	public Circle() {}
	
	public Circle(int radius) {
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void draw() {
		System.out.println("반지름 " + radius + "cm인 원을 그립니다.");
	}
}
