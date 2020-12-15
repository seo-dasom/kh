package com.kh.exam01;

public class Sample2 {

	public static void main(String[] args) {
		int x = 0;
		long y = 0;
		double z = 12.34;
		y = 12345678;
		x = (int)y;
		
		// System.out.print(x, "\n")  에러! print는 반드시 하나의 값만 출력
		System.out.print(x + "\n");
		System.out.print(y + "\n");
		
		System.out.printf("int 값 : %d, long 값 : %d\n", x, y);
		System.out.printf("소수점 1자리까지 출력 : %.1f\n", z);
		System.out.printf("소수점 1자리까지 출력 : %10.1f\n", z); // 10 -> 자릿수 지정
		System.out.printf("소수점 1자리까지 출력 : %10.1f\n", 123.4);
	}

}
