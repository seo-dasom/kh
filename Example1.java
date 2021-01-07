package com.kh.exam1;

import java.util.Scanner;

/*
 *  사용자 입력을 받아서 프로그램을 계속 동작할 것인지
 *  아니면 중단 할 것인지를 yes 또는 no로 입력을 받아서 구분을 하시오.
 *  단, 사용자가 yes 또는 YES를 입력해도 동일한 문자열로 인식되도록 한다.(no 또는 NO도 마찬가지)
 */
public class Example1 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// 프로그램이 실행 중 입니다. 를 한 번 출력 후에
		// "계속 실행하시겠습니까? (yes/no)" 로 사용자 입력을 받는다.
		// yes 면 프로그램이 실행 중입니다. 출력
		// no 면 프로그램을 종료 합니다. 출력 후 종료
		String input;
		while(true) {
			System.out.println("프로그램이 실행중입니다.");
			System.out.print("계속 실행하시겠습니까? (yes/no) : ");
			input = sc.next().toLowerCase();
			if(input.equals("no")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				// break;
			} else if(input.equals("yes")) {
				continue;
			}
		}
	}

}
