package com.kh.practice.comp;

import java.util.Scanner;

public class CompExample {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void func1() {
		int num = 0;
		int i = 1;
		
		System.out.print("���� : ");
		num = sc.nextInt();
		
		if(num <= 0) {
			System.out.println("����� �ƴմϴ�.");
		}
		while(num >= i) {
			if(i % 2 == 1) {
			System.out.print("��");
			} else {
				System.out.print("��");
			}
			i++;
		}
	}
	
	public static void func2() {
		int num = 0;
		int i = 1;
		
		do {
			System.out.print("���� : ");
			num = sc.nextInt();
			
			if(num <= 0) {
				System.out.println("����� �ƴմϴ�.");
			}
		}	while(!(num >= 1));
		
		while(num >= i) {
			if(i % 2 == 1) {
			System.out.print("��");
			} else {
				System.out.print("��");
			}
			i++;
		}
	}
	
	public static void func3() {
		/*
		 * ���ڿ� �Է¹ޱ�
		 * ���ڿ����� �˻��� ���ڸ� �Է� �ޱ�
		 * �ش� ���ڿ��� �� ���ڰ� �� �� �ִ��� ���� ���
		 */
		String s = "";
		char c;
		int sum = 0 , i = 0;
		
		System.out.print("���ڿ� : ");
		s = sc.next();
		System.out.print("���� : ");
		c = sc.next().charAt(0);
		
		while(i<s.length()) {
			if(c == s.charAt(i)) {
				sum++;
			}
			i++;
		}
		
		System.out.printf("%s �ȿ� ���Ե� %c ���� : %d\n", s, c, sum);
	}
	
	public static void func4() {
		/*
		 * 3���� �����ϰ�, "�� �Ͻðڽ��ϱ�?" �߰� �Է�
		 * N�̳� n�� ������ ���α׷��� ������, Y�� y�� ��� �����ϵ��� �ϰ�
		 * �ٸ����ڸ� �Է�������� "�߸��� ����Դϴ�. �ٽ� �Է����ּ���." ��� -> ���ϰڳĴ� ���� �ݺ�
		 */
		String s = "";
		char c;
		int sum, i;
		while(true) {
			sum = 0;
			i =0;
			System.out.print("���ڿ� : ");
			s = sc.next();
			System.out.print("���� : ");
			c = sc.next().charAt(0);
			
			while(i<s.length()) {
				if(c == s.charAt(i)) {
					sum++;
				}
				i++;
			}
			System.out.printf("���Ե� ���� : %d\n", sum);
			while(true) {
				System.out.print("�� �Ͻðڽ��ϱ�? (y/n) : ");
				c = sc.next().charAt(0);
			
				if(c == 'Y' || c == 'y') {
					break;
				} else if( c == 'N' || c =='n') {
					System.exit(0);
				} else {
					System.out.println("�߸��� ����Դϴ�. �ٽ� �Է����ּ���.");
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