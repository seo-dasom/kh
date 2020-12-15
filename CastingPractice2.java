package com.kh.exam01.practice2.func;

import java.util.Scanner;

public class CastingPractice2 {

	public static void main(String[] args) {
		float x, y, z;
		int tot,avg;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("±¹¾î : ");
		x = sc.nextFloat();
		
		System.out.print("¿µ¾î : ");
		y = sc.nextFloat();
		
		System.out.print("¼öÇÐ : ");
		z = sc.nextFloat();
		
		tot = (int)( x + y + z );
		avg = tot / 3;
		
		System.out.printf("ÃÑÁ¡ : %d \nÆò±Õ : %d \n" , tot, avg);
		
		sc.close();
	}

}
