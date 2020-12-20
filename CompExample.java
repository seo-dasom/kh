package com.kh.practice.comp;

import java.util.Scanner;

public class CompExample {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void func1() {
		int num = 0;
		int i = 1;
		
		System.out.print("정수 : ");
		num = sc.nextInt();
		
		if(num <= 0) {
			System.out.println("양수가 아닙니다.");
		}
		while(num >= i) {
			if(i % 2 == 1) {
			System.out.print("박");
			} else {
				System.out.print("수");
			}
			i++;
		}
	}
	
	public static void func2() {
		int num = 0;
		int i = 1;
		
		do {
			System.out.print("정수 : ");
			num = sc.nextInt();
			
			if(num <= 0) {
				System.out.println("양수가 아닙니다.");
			}
		}	while(!(num >= 1));
		
		while(num >= i) {
			if(i % 2 == 1) {
			System.out.print("박");
			} else {
				System.out.print("수");
			}
			i++;
		}
	}
	
	public static void func3() {
		/*
		 * 문자열 입력받기
		 * 문자열에서 검색될 문자를 입력 받기
		 * 해당 문자열에 그 문자가 몇 개 있는지 개수 출력
		 */
		String s = "";
		char c;
		int sum = 0 , i = 0;
		
		System.out.print("문자열 : ");
		s = sc.next();
		System.out.print("문자 : ");
		c = sc.next().charAt(0);
		
		while(i<s.length()) {
			if(c == s.charAt(i)) {
				sum++;
			}
			i++;
		}
		
		System.out.printf("%s 안에 포함된 %c 개수 : %d\n", s, c, sum);
	}
	
	public static void func4() {
		/*
		 * 3번과 동일하고, "더 하시겠습니까?" 추가 입력
		 * N이나 n이 나오면 프로그램을 끝내고, Y나 y면 계속 진행하도록 하고
		 * 다른문자를 입력했을경우 "잘못된 대답입니다. 다시 입력해주세요." 출력 -> 더하겠냐는 물음 반복
		 */
		String s = "";
		char c;
		int sum, i;
		while(true) {
			sum = 0;
			i =0;
			System.out.print("문자열 : ");
			s = sc.next();
			System.out.print("문자 : ");
			c = sc.next().charAt(0);
			
			while(i<s.length()) {
				if(c == s.charAt(i)) {
					sum++;
				}
				i++;
			}
			System.out.printf("포함된 개수 : %d\n", sum);
			while(true) {
				System.out.print("더 하시겠습니까? (y/n) : ");
				c = sc.next().charAt(0);
			
				if(c == 'Y' || c == 'y') {
					break;
				} else if( c == 'N' || c =='n') {
					System.exit(0);
				} else {
					System.out.println("잘못된 대답입니다. 다시 입력해주세요.");
				}
			}
		}
	}
	public static void main(String[] args) {
		func4();
		//func3();
		//func2();
		//func1();
		sc.close();
	}
}