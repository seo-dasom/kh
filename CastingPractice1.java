package com.kh.exam01.practice2.func;

import java.util.Scanner;

public class CastingPractice1 {

	public static void main(String[] args) {
		char c;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		c = sc.next().charAt(0);
		
		System.out.println(c + " Unicode " + (int)c);
		
		sc.close();
	}

}
