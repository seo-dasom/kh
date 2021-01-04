package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Rectangle;

public class RectangleController {
	private Rectangle r = new Rectangle();
	
	public String clacArea(int x, int y, int height, int width) {
		// 면적 : 너비 * 높이
		int area;
		r = new Rectangle(x, y, height, width);
		area = r.areaInt();
		return r.toString() + " / " + Integer.toString(area);
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		// 둘레 : 2 * (너비 + 높이)
		int perimeter;
		r = new Rectangle(x, y, height, width);
		perimeter = r.roundInt();
		return r.toString() + " / " + Integer.toString(perimeter);
	}
}
