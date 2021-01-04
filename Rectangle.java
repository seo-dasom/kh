package com.kh.practice.point.model.vo;

public class Rectangle extends Point {
	private int width;
	private int height;
	
	public Rectangle() {}
	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	// 필수
	@Override
	public int areaInt() {
		return width * height;
	}
	
	@Override
	public int roundInt() {
		return (width + height) * 2;
	}
	
	@Override
	public double areaDouble() {
		return (double)width * height;
	}
	
	@Override
	public double roundDouble() {
		return (width + height) * 2.0;
	}
	
	@Override
	public String toString() {
		return super.toString() + " , " + this.width + " , " + this.height;
	}
}
