package com.kh.practice.chap02;

import java.util.Scanner;

public class LoopPractice {

	public static Scanner sc = new Scanner(System.in);
	
	public static void practice1() {
		int num;
		
		System.out.print("1�̻��� ���ڸ� �Է��ϼ��� : ");
		num = sc.nextInt();
		
		for(int i = 1;;) {
			if(num < 1) {
				System.out.println("1�̻��� ���ڸ� �Է����ּ���.");
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
//			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
//		}
	}
	
	public static void practice2() {
		/*
		 *  1. ����� �Է� �޴´�.
		 *  2. �Է¹��� ���� ���� 1 �̻����� Ȯ��
		 *     2-1. 1 �̻��� ������ �ݺ� ����.
		 *     2-2. 1 �̻��� �ƴϸ� ��� �ݺ�
		 */
		int num = 0;
		for (;;) {
			System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
			num = sc.nextInt();
			if(num >= 1) {
				for(int i = 1; i <= num; i++) {
					System.out.print(i + " ");
				}
				break;
			}
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
		}
	}
	
	public static void practice3() {
		
		int num;
		
		System.out.println("1�̻��� ���ڸ� �Է��ϼ��� : ");
		num = sc.nextInt();
		
		for(; num > 0; num--) {
			System.out.print(num + " ");
		}
	}
	
	public static void practice4() {
		
        int num = 0;
        
		for(;num <= 0;) {
			System.out.println("1�̻��� ���ڸ� �Է��ϼ��� : ");
			num = sc.nextInt();
			
			if(num >= 1) {
				break;
			}
			
			System.out.print("�߸��� ���� �Է��Ͽ����ϴ�.");
		}
		
		for(; num > 0; num--) {
			System.out.print(num + " ");
		}
	}
	
	public static void practice5() {
		/*
		 *  1 ���� ����ڰ� �Է��� ���� �������� �������� ���ϰ� ���
		 *  ������ -> �ϳ��� ������ ����Ͽ� ���� ���� ���ο� ���� ��� ���ϴ� ��
		 *          �� ����� �ش� ������ �ٽ� ����.
		 */
		int x = 0;
		int num;
		
		System.out.print("���� �Է� : ");
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
		
		System.out.print("ù ��° ���� : ");
		num1 = sc.nextInt();
		System.out.print("�� ��° ���� : ");
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
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
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
