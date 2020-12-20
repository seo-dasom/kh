package com.kh.practice.comp;

import java.util.Scanner;
import java.util.Random;

public class UpAndDown {
	public static Scanner sc = new Scanner(System.in);
	
	public static void upDown() {
		/*
		 * 1 부터 100 사이의 정수 중 임의의 난수가 정해지고
		 * 정해진 난수를 맞추는데 몇 번 만에 맞췄는지 출력
		 */
		Random rand = new Random();
		int a = 0;
		int count = 1;
		int num = rand.nextInt(101) + 1;
		System.out.println(num);
		
		for(;;) {
			System.out.print("1~100 사이의 임의의 난수를 맞춰보세요 : ");
			a = sc.nextInt();
			if (a <= 0 || a > 100) {
				System.out.println("1~100 사이의 숫자를 입력해주세요.");
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
					System.out.println("정답입니다 !!");
					System.out.printf("%d회만에 맞추셨습니다.", count);
					System.exit(0);
				} 
			}
		}
	
	public static void main(String[] args) {
		upDown();
		sc.close();
	}
}