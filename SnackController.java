package com.kh.practice.snack.controller;

import com.kh.practice.snack.model.vo.Snack;

public class SnackController {
//	private Snack s = new Snack();
	private Snack s;
	
	public SnackController() {}
	
	public String saveData(String kind, String name, String flavor,
						   int numOf, int price) {
		s = new Snack(kind, name, flavor, numOf, price);
//		s.setKind(kind); 		s.setName(name);
//		s.setFlavor(flavor);
//		s.setNumOf(numOf);		s.setPrice(price);
		return "저장 완료되었습니다.";
	}
	
	public String confirmData() {
		// 저장된 데이터를 반환하는 메서드
		return s.information();
	}
}
