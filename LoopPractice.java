package com.kh.practice.chap02;

import java.util.Scanner;

public class LoopPractice {

	public static Scanner sc = new Scanner(System.in);
	
	public static void practice1() {
		int num;
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		num = sc.nextInt();
		
		for(int i = 1;;) {
			if(num < 1) {
				System.out.println("1이상의 숫자를 입력해주세요.");
				break;
			}
			System.out.print(i++ + " ");
			
			if(i >= num) {
				System.out.print(i);
				break;
			}
		}
		
//		if (num >= 1) {
//			for (int i = 1; i <= num; i++) {
//				System.out.print(i + " ");
//			}
//		} else {
//			System.out.println("1 이상의 숫자를 입력해주세요.");
//		}
	}
	
	public static void practice2() {
		/*
		 *  1. 사용자 입력 받는다.
		 *  2. 입력받은 정수 값이 1 이상인지 확인
		 *     2-1. 1 이상이 맞으면 반복 종료.
		 *     2-2. 1 이상이 아니면 계속 반복
		 */
		int num = 0;
		for (;;) {
			System.out.print("1 이상의 숫자를 입력하세요 : ");
			num = sc.nextInt();
			if(num >= 1) {
				for(int i = 1; i <= num; i++) {
					System.out.print(i + " ");
				}
				break;
			}
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
	}
	
	public static void practice3() {
		
		int num;
		
		System.out.println("1이상의 숫자를 입력하세요 : ");
		num = sc.nextInt();
		
		for(; num > 0; num--) {
			System.out.print(num + " ");
		}
	}
	
	public static void practice4() {
		
        int num = 0;
        
		for(;num <= 0;) {
			System.out.println("1이상의 숫자를 입력하세요 : ");
			num = sc.nextInt();
			
			if(num >= 1) {
				break;
			}
			
			System.out.print("잘못된 값을 입력하였습니다.");
		}
		
		for(; num > 0; num--) {
			System.out.print(num + " ");
		}
	}
	
	public static void practice5() {
		/*
		 *  1 부터 사용자가 입력한 정수 값까지의 누적합을 구하고 출력
		 *  누적합 -> 하나의 변수를 사용하여 기존 값에 새로운 값을 계속 더하는 것
		 *          그 결과를 해당 변수에 다시 저장.
		 */
		int x = 0;
		int num;
		
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		
		for(int i = 1; i <= num - 1; i++) {
			System.out.print(i + " + ");
			x = x + i;
		}
		x = x + num;
		System.out.println(num + " = " + x);
		
	}
	
	public static void practice6() {

		int num1 = 0;
		int num2 = 0;
		
		System.out.print("첫 번째 숫자 : ");
		num1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		num2 = sc.nextInt();
		
		if(num1 >= 1 && num2 >= 1) {
			if(num1 <= num2) {
				for(; num1 <= num2; num1++) {
					System.out.printf("%d ", num1);
				}
			} else {
				for(; num2 <= num1; num2++) {
					System.out.printf("%d ", num2);
				}
			}
		} else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
		
	}

	public static void practice7() {
		
		
		
	}
	
	public static void practice8() {
		
		
		
	}
	
	public static void practice9() {
		
		
		
	}
	
	public static void practice10() {
		
		
		
	}
	
	public static void practice11() {
		
		
		
	}
	
	public static void practice12() {
		
		
		
	}
	
	public static void practice13() {
		
		
		
	}
	
	public static void practice14() {
		
		
		
	}
	public static void main(String[] args) {
		//practice1();
		//practice2();
		//practice3();
		//practice4();
		//practice5();
		practice6();
		//practice7();
		//practice8();
		//practice9();
		//practice10();
		//practice11();
		//practice12();
		//practice13();
		//practice14();
		sc.close();
	}

}
