package com.kh.practice.point.model.vo;

public abstract class Point {
	private int x;
	private int y;
	
	public Point() {}
	
	public Point(int x, int y) {
		this.x = x;		this.y = y;
	}
	
	// 일반 메서드
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	// 추상 메서드
	// 반드시 자식에서 오버라이드 해야 한다.
	// 구현된 코드가 없기 때문
	abstract public int areaInt();
	abstract public int roundInt();
	abstract public double areaDouble();
	abstract public double roundDouble();
	
	@Override
	public String toString() {
		return x + " , " + y;
	}
}
