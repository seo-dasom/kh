package com.kh.practice.comp;

import java.util.Scanner;
import java.util.Random;

public class UpAndDown {
	public static Scanner sc = new Scanner(System.in);
	
	public static void upDown() {
		/*
		 * 1 ���� 100 ������ ���� �� ������ ������ ��������
		 * ������ ������ ���ߴµ� �� �� ���� ������� ���
		 */
		Random rand = new Random();
		int a = 0;
		int count = 1;
		int num = rand.nextInt(101) + 1;
		System.out.println(num);
		
		for(;;) {
			System.out.print("1~100 ������ ������ ������ ���纸���� : ");
			a = sc.nextInt();
			if (a <= 0 || a > 100) {
				System.out.println("1~100 ������ ���ڸ� �Է����ּ���.");
				continue; 
				}
				if(a < num) {
					System.out.print("UP !\n");
					count = count + 1;
				} else if(a > num) {
					System.out.print("DOWN !\n");
					count = count + 1;
				}
				if (a == num) {
					System.out.println("�����Դϴ� !!");
					System.out.printf("%dȸ���� ���߼̽��ϴ�.", count);
					System.exit(0);
				} 
			}
		}
	
	public static void main(String[] args) {
		upDown();
		sc.close();
	}
}