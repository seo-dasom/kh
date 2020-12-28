package com.kh.class4;

public class Shape {
	private double width;
	private double height;
	
	// 기본 생성자로 만들지 않아도 된다.
	// shape() {}
	
	public void setWidth(double w) {
		width = w;
	}
	
	public void setHeight(double h) {
		height = h;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
}
