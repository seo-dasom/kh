package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {
	
	//Scanner를 close 할 때 System.in이 close가 되어 반복 사용이 안되는 문제로 인해
	//정적 변수로 대체 사용.
	public static Scanner sc = new Scanner(System.in);
	
	public static void practice1() {
		/*
		 *  키보드로 입력 받은 정수가 양수면 "양수다"를 출력 아니면 "양수가 아니다"를 출력
		 *  1. 사용자 입력 받기
		 *  2. 입력 받은 값에 대해 양수인지 비교
		 *     A.양수면 "양수다" 출력
		 *     B.양수가 아니면 "양수가 아니다" 출력
		 */
		int num;
		String res;
		
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		
		res = num < 0 ? "양수가 아니다." : "양수다.";
		
		System.out.println(res);
	}
	
	public static void practice2() {
		/*
		 *  키보드로 입력 받은 정수가 양수면 "양수다"를 출력 아니면 "양수가 아니다"를 출력
		 *  정수 값이 0인 경우 "0 이다"를 출력
		 *  1. 사용자 입력 받기
		 *  2. 입력 받은 값에 대해 양수인지 비교
		 *     A.양수면 "양수다" 출력
		 *     B.양수가 아니면 "양수가 아니다" 출력
		 *     C.0 이면 "0 이다" 출력
		 */
		int num;
		String res;
		
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		
		res = num < 0 ? "양수가 아니다." : num == 0 ? "0이다." : "양수다.";
		
		System.out.println(res);
	}
	
	public static void practice3() {
		int num;
		String res;

		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		
		res = num % 2 == 0 ? "짝수다." : "홀수다.";
		
		System.out.println(res);
	}
	
	public static void practice4() {
		int x, y;

		System.out.print("인원 수 : ");
		x = sc.nextInt();
		
		System.out.println("사탕 개수 : ");
		y = sc.nextInt();
		
		System.out.println("1인당 사탕 개수 : " + y / x);
		System.out.println("남는 사탕 개수 : " + y % x);
	}
	
	public static void practice5() {
		String name;
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
		
		System.out.printf("%d 학년 %d 반 %d 번 %s %s %.2f이다.", lvl, cls, num,
				name, gender == 'M' ? "남학생" : "여학생", grade);
	}
	
	public static void practice6() {
		int age;
		String s;
		
		System.out.print("나이 : ");
		age = sc.nextInt();
		
		s = age <= 13 ? "어린이" : age > 13 && age <= 19 ? "청소년" : "성인";
		System.out.println(s);
	}
	
	public static void practice7() {
		int x, y, z, tot;
		double avg;
		String s;
		
		System.out.print("국어 : ");
		x = sc.nextInt();
		
		System.out.print("영어 : ");
		y = sc.nextInt();
		
		System.out.print("수학 : ");
		z = sc.nextInt();
		
		tot = x + y + z;
		avg = tot / 3.0;
		
		System.out.println("합계 : " + tot);
		System.out.printf("평균 : %.1f", avg);
		
		s = x >= 40 && y >= 40 && z >= 40 && avg >=60 ? "합격" : "불합격";
		
		System.out.println(s);
		
	}
	
	public static void practice8() {
		String s;
		
		System.out.print("주민번호 입력(- 포함 입력) : ");
		s = sc.next().charAt(7) == '1' ? "남자" : "여자";
		System.out.println(s);
	}
	
	public static void practice9() {
		int num1, num2, a;
		boolean b;
		
		System.out.print("정수1 : ");
		num1 = sc.nextInt();
		
		System.out.print("정수2 : ");
		num2 = sc.nextInt();
		
		System.out.print("입력 : ");
		a = sc.nextInt();
		
		b = a <= num1 || a > num2 ? true : false;
		
		System.out.println(b);
	}
	
	public static void practice10() {
		int num1, num2, num3;
		boolean b;
		
		System.out.print("정수1 : ");
		num1 = sc.nextInt();
		
		System.out.print("정수2 : ");
		num2 = sc.nextInt();
		
		System.out.print("정수3 : ");
		num3 = sc.nextInt();
		
		b = num1 == num2  && num2 == num3;
		
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		//practice1();   // 메서드 호출
		//practice2();
		//practice3();
		//practice4();
		//practice5();
		//practice6();
		//practice7();
		//practice8();
		//practice9();
		practice10();
		sc.close();
	}

}
