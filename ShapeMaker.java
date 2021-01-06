package com.kh.test.shape.controller;

import com.kh.test.shape.model.vo.*;

public class ShapeMaker {

	public static void main(String[] args) {
		Circle[] c = new Circle[3];
		c[0] = new Circle(20);
		c[1] = new Circle(40);
		c[2] = new Circle(50);
		
		for(int i = 0; i < c.length; i++) {
			c[i].draw();
		}
		
		RectAngle[] r = new RectAngle[2];
		r[0] = new RectAngle(20, 20);
		r[1] = new RectAngle(50, 60);
		
		for(int i = 0; i < r.length; i++) {
			r[i].draw();
		}
	}

}
