package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {
	private Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		// 면적 : PI * 반지름 * 반지름
		double area;
		c = new Circle(x, y, radius);
		area = c.areaDouble();
		return c.toString() + " / " + area;
	}
	
	public String calCircum(int x, int y, int radius) {
		// 둘레 : PI * 반지름 * 2
		double circum;
		c = new Circle(x, y, radius);
		circum = c.roundDouble();
		return c.toString() + " / " + circum;
	}
}
