package com.kh.exam01.practice1.func;

import java.util.Scanner;

public class VariablePractice2 {

	public static void main(String[] args) {
		int num1,num2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 : ");
		num1 = sc.nextInt();
		
		System.out.print("두 번째 정수 : ");
		num2 = sc.nextInt();

		System.out.println("더하기 결과 : " + ( num1 + num2 ));
		System.out.println("빼기 결과 : " + ( num1 - num2 ));
		System.out.println("곱하기 결과 : " + ( num1 * num2 ));
		System.out.println("나누기 결과 : " + ( num1 / num2 ));
		
		sc.close();
	}

}
