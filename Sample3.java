package com.kh.exam01;

import java.util.Scanner;

public class Sample3 {

	public static void main(String[] args) {
		int age = 0;
		double weight = 0.0;
		String name;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이를 입력하세요 : ");
		age = sc.nextInt();
		
		System.out.print("체중을 입력하세요 : ");
		weight = sc.nextDouble();
		
		System.out.print("이름을 입력하세요 : ");
		name = sc.next();
		
		System.out.println("당신의 나이는 " + age + "세 입니다.");
		System.out.println("당신의 체중은 " + weight + "kg 입니다.");
		System.out.println("당신의 이름은 " + name + " 입니다.");
		
		sc.close();
	}

}
