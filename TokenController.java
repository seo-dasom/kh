package com.kh.practice.token.controller;

import java.util.*;

public class TokenController {
	public TokenController() {}
	
	public String afterToken(String str) {
		/**
		 *  매개변수로 받아온 문자열을 StringTokenizer를 이용하여
		 *  띄어쓰기를 없앤 문자열로 반환
		 */
		StringTokenizer st = new StringTokenizer(str);
		String res = "";
		while(st.hasMoreTokens()) {
			res = res.concat(st.nextToken());
		}
		
		return res;
	}
	
	public String firstCap(String input) {
		/**
		 *  매개변수로 받아온 문자열의 첫 번째 글자만
		 *  대문자로 바꾼 문자열을 반환
		 *  firstCap("hello") -> "Hello"
		 */
		
/*		char[] cArr = input.toCharArray();
		cArr[0] = ("" + cArr[0]).toUpperCase().charAt(0);
		return String.join("", cArr);
*/		
		String res = ("" + input.charAt(0)).toUpperCase();
		for(int i = 1; i < input.length(); i++) {
			res = res.concat("" + input.charAt(i));
		}
		return res;
	}
	
	public int findChar(String input, char one) {
		/**
		 * 	매개변수의 문자가 문자열 안에 몇 개가 있는지 반환
		 */
		int count = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == one) {
				count += 1;
			}
		}
		return count;
	}
}
