package com.kh.exam;

import java.util.Scanner;
public class Sample1 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void func1() {
		/*
		 * 사용자 입력으로 정수 값을 입력 받은 후 양수/음수 구분하여 출력
		 */
		
		int num;
		String res;
		
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		
		if(num > 0) {
			res = "양수다";
		} else {
			res = "양수가 아니다";
		}
		
		System.out.println(res);
	}
	
	public static void func2() {
		int num;
		String res;
		
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		
//		if(num > 0) {
//			res = "양수다";
//		} else if (num == 0) {
//			res = "0 이다";
//		} else {
//			res = "음수다";
//		}
		
		if(num > 0) {
			res = "양수다";
		} else {
			// 0 을 포함한 음수값
			if(num == 0) {
				res = "0이다";
			} else {
				res = "음수다";
			}
		}
		
		System.out.println(res);
	}
	
	public static void func3() {
		String name, gender_name;
		int lvl, cls, num;
		char gender;
		double grade;
		
		System.out.print("이름 : ");
		name = sc.next();
		
		System.out.print("학년 : ");
		lvl = sc.nextInt();
		
		System.out.print("반 : ");
		cls = sc.nextInt();
		
		System.out.print("번호 : ");
		num = sc.nextInt();
		
		System.out.print("성별(M/F) : ");
		gender = sc.next().charAt(0);
		
		System.out.print("성적 : ");
		grade = sc.nextDouble();
		
//		if(gender == 'M') {
//			gender_name = "남학생";
//		} else if(gender == 'F') {
//			gender_name = "여학생";
//		} else {
//			gender_name = "잘못된 성별 코드";
//		}
		
		switch(gender) {
		    case'M' :
		    	gender_name = "남학생"; break;
		    case'F'	:
		    	gender_name = "여학생"; break;
		    default:
		    	gender_name = "잘못된 성별 코드";
		}
		
		System.out.printf("%d 학년 %d 반 %d 번 %s %s 성적은 %.2f이다.\n", 
				lvl, cls, num, name, gender_name, grade);
	}
	
	public static void func4() {
		int age;
		String res;
		
		System.out.print("나이 (1 ~ 120) : ");
		age = sc.nextInt();
		
		if(age > 0 && age <= 120) {
			if(age <= 13) {
				res = "어린이";
			} else if(age > 13 && age <= 19) {
				res ="청소년";
			} else {
				res = "성인";
			}
		} else {
			res = "1 ~ 120 사이의 갑을 입력하세요";
		}
		
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		func1();
	}

}
