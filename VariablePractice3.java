package com.kh.exam01.practice1.func;

import java.util.Scanner;

public class VariablePractice3 {

	public static void main(String[] args) {
		float x, y;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		x = sc.nextFloat();
		
		System.out.print("���� : ");
		y = sc.nextFloat();
		
		System.out.println("���� : " + (x * y));
		System.out.println("�ѷ� : " + (x + y) * 2);
		
		sc.close();
	}

}
