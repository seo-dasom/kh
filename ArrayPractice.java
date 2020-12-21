package com.kh.practice.array;

import java.util.Scanner;

public class ArrayPractice {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void practice1() {
		/*
		 * ���̰� 10�� �迭�� �����ϰ� 1���� 10������ ����
		 * �ݺ��� �̿��Ͽ� ������ȣ �迭 �ε����� ���� �� ���
		 */
		int[] arr = new int[10];
		int num = 1;
		
		// 1 ~ 10 ������ ���� �����ϱ� ���� ������ ������ ���
		for(int i = 0; i < arr.length; i++) {
			arr[i] = num;
			num += 1;
		}
		
		// 1 ~ 10 ������ ���� �����ϱ� ���� i ���� Ȱ��
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void practice2() {
		/*
		 * ���̰� 10�� �迭�� �����ϰ� 1 ~ 10������ ���� �ݺ�����
		 * �̿��Ͽ� �������� �迭 �ε����� ���� �� �� ���� ���
		 * 10 9 8 7 6 5 4 3 2 1
		 */
		int[] arr = new int[10];
		int num = 10;
		
		// 10 ~ 1 ������ ���� ������ ������ ���� ���
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = num;
//			num--;
//		}
		
		// �迭�� ������ 10 ~ 1 ������ ���� ������ ������ �����Ͽ� ���
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - i;
		}
		
		// �迭�� ������ 10 ~ 1 ������ ���� i ������ Ȱ��
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void practice3() {
		/*
		 * ����ڿ��� �Է¹��� ���� ������ŭ �迭 ũ�⸦ �Ҵ�
		 * 1 ���� �Է� ���� ������ �迭�� �ʱ�ȭ �� ���
		 */
		int arrSize;
		
		while(true) {
			System.out.print("���� ���� : ");
			arrSize = sc.nextInt();
			if(arrSize > 0) {
				break;
			}
		}
		
		int[] arrVar = new int[arrSize];
		
		// �迭�� 1 ~ ����� �Է� ������ �ʱ�ȭ
		for(int i = 0; i < arrVar.length; i++) {
			arrVar[i] = i + 1;
		}
		
		//���
		for(int i = 0; i < arrVar.length; i++) {
			System.out.print(arrVar[i] + " ");
		}
	}
	
	public static void practice4() {
		/*
		 * ���̰� 5�� String �迭�� ����
		 * "���", "��", "����", "������", "����" ��
		 * �ʱ�ȭ �� �迭 �ε����� Ȱ���Ͽ� ���� ���
		 */
		String[] arrVar = {"���", "����", "��", "������", "����"};
		
		for(int i = 0; i < arrVar.length; i++) {
			if("��".equals(arrVar[i])) {
				System.out.println("��ġ �� -> " + i + "\t���ڿ� -> " + arrVar[i]);
			}
		}
	}
	
	public static void practice5() {
		/*
		 * ���ڿ��� �Է� �޾� �ϳ��ϳ� �迭�� �ְ�
		 * ���ڰ� ���ڿ��� �� �� �� �ִ��� ������ �� ��° �ִ��� ���
		 */
		String word;
		char ch;
		char[] chArr;
		int count = 0;
		
		System.out.print("���ڿ� : ");
		word = sc.next();
		
		System.out.print("���� : ");
		ch = sc.next().charAt(0);
		
		// ���ڿ��� ���� ��ŭ ���ڹ迭 ����
		chArr = new char[word.length()];
		
		// ���ڿ��� �ε����� ���ڹ迭�� �ε����� Ȱ���Ͽ�
		// ���ڿ��� ���ڸ� ���ڹ迭�� ����
		for(int i = 0; i < chArr.length; i++) {
			chArr[i] = word.charAt(i);
		}
		
		System.out.print(word + "�� " + ch + "�� �����ϴ� ��ġ(�ε���) : ");
		for(int i = 0; i < chArr.length; i++) {
			if(ch == chArr[i]) {
				count++;
				System.out.print(i + " ");
			}
		}
		System.out.println("\n" + ch + " ���� : " + count);
		
//		for(int i = 0; i < chArr.length; i++) {
//			System.out.print(chArr[i]);
//		}
	}
	
	public static void practice6() {
		/*
		 *  "��" ~ "��" ���� �ʱ�ȭ�� ���ڿ� �迭 �����
		 *  0���� 6���� ���ڸ� �Է� �޾�,
		 *  �Է��� ���ڿ� ���� �ε����� �ִ� ������ ���
		 *  ������ ���� ���� �Է� �� "�߸� �Է��ϼ̽��ϴ�" ���
		 *  (Ȱ�� -> 1 ~ 31 ������ ���ڰ��� �Է¹޾� �׿� �����ϴ� ���� ���)
		 */
		String[] week = {"��", "ȭ", "��", "��", "��", "��", "��"};
		int day;
		
		while(true) {
			System.out.print("1 ~ 31 ���� ���� �Է� : ");
			day = sc.nextInt();
			if(day >= 1 && day <= 31) {
				break;
			}
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		System.out.println(week[day % 7]);
	}
	
	public static void practice7() {
		/*
		 * ����ڰ� �迭�� ���̸� �Է�
		 * �� ����ŭ ������ �迭�� ���� �� �Ҵ�
		 * �迭�� ũ�⸸ŭ ����ڰ� ���� ���� �Է� -> ������ �ε����� ���� �ʱ�ȭ
		 * �迭 ��ü ���� �����ϰ� �ε����� ����� ������ ���� ���
		 */
		int[] arrVar;
		int num, total;
		
		System.out.print("���� : ");
		num = sc.nextInt();
		
		arrVar = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print("�迭 " + i + "��° �ε����� ���� �� : ");
			arrVar[i] = sc.nextInt();
		}
		
		total = 0;
		for(int i = 0; i < arrVar.length; i++) {
			System.out.print(arrVar[i] + " ");
			total = total + arrVar[i];
		}
		
		System.out.println("\n�� �� : " + total);
	}
	
	public static void practice8() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//practice16();
		//practice15();
		//practice14();
		//practice13();
		//practice12();
		//practice11();
		//practice10();
		//practice9();
		practice8();
		//practice7();
		//practice6();
		//practice5();
		//practice4();
		//practice3();
		//practice2();
		//practice1();
	}

}
