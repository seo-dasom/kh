package com.kh.class4.run;

import com.kh.class4.Shape;

public class Run {

	public static void main(String[] args) {
		Shape s = new Shape();
		s.setWidth(10);		// 자동 형변환 되어 결과 출력
		s.setHeight(20);
		
		System.out.println("높이 : " + s.getHeight());
		System.out.println("넓이 : " + s.getWidth());
	}

}
