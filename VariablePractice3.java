package com.kh.exam01.practice1.func;

import java.util.Scanner;

public class VariablePractice3 {

	public static void main(String[] args) {
		float x, y;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로 : ");
		x = sc.nextFloat();
		
		System.out.print("세로 : ");
		y = sc.nextFloat();
		
		System.out.println("면적 : " + (x * y));
		System.out.println("둘레 : " + (x + y) * 2);
		
		sc.close();
	}

}
