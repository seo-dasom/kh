package com.kh.practice.array;

import java.util.Scanner;

public class ArrayPractice {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void practice1() {
		/*
		 * 길이가 10인 배열을 선언하고 1부터 10까지의 값을
		 * 반복문 이용하여 순서대호 배열 인덱스에 넣은 후 출력
		 */
		int[] arr = new int[10];
		int num = 1;
		
		// 1 ~ 10 까지의 값을 저장하기 위한 별도의 변수를 사용
		for(int i = 0; i < arr.length; i++) {
			arr[i] = num;
			num += 1;
		}
		
		// 1 ~ 10 까지의 값을 저장하기 위해 i 변수 활용
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void practice2() {
		/*
		 * 길이가 10인 배열을 선언하고 1 ~ 10까지의 값을 반복문을
		 * 이용하여 역순으로 배열 인덱스에 저장 후 그 값을 출력
		 * 10 9 8 7 6 5 4 3 2 1
		 */
		int[] arr = new int[10];
		int num = 10;
		
		// 10 ~ 1 까지의 값을 저장할 별도의 변수 사용
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = num;
//			num--;
//		}
		
		// 배열에 저장할 10 ~ 1 까지의 값을 별도의 변수를 생성하여 사용
		for(int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - i;
		}
		
		// 배열에 저장할 10 ~ 1 까지의 값을 i 변수에 활용
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void practice3() {
		/*
		 * 사용자에게 입력받은 양의 정수만큼 배열 크기를 할당
		 * 1 부터 입력 받은 값까지 배열에 초기화 후 출력
		 */
		int arrSize;
		
		while(true) {
			System.out.print("양의 정수 : ");
			arrSize = sc.nextInt();
			if(arrSize > 0) {
				break;
			}
		}
		
		int[] arrVar = new int[arrSize];
		
		// 배열에 1 ~ 사용자 입력 값까지 초기화
		for(int i = 0; i < arrVar.length; i++) {
			arrVar[i] = i + 1;
		}
		
		//출력
		for(int i = 0; i < arrVar.length; i++) {
			System.out.print(arrVar[i] + " ");
		}
	}
	
	public static void practice4() {
		/*
		 * 길이가 5인 String 배열을 선언
		 * "사과", "귤", "포도", "복숭아", "참외" 로
		 * 초기화 후 배열 인덱스를 활용하여 귤을 출력
		 */
		String[] arrVar = {"사과", "포도", "귤", "복숭아", "참외"};
		
		for(int i = 0; i < arrVar.length; i++) {
			if("귤".equals(arrVar[i])) {
				System.out.println("위치 값 -> " + i + "\t문자열 -> " + arrVar[i]);
			}
		}
	}
	
	public static void practice5() {
		/*
		 * 문자열을 입력 받아 하나하나 배열에 넣고
		 * 문자가 문자열에 몇 개 들어가 있는지 개수와 몇 번째 있는지 출력
		 */
		String word;
		char ch;
		char[] chArr;
		int count = 0;
		
		System.out.print("문자열 : ");
		word = sc.next();
		
		System.out.print("문자 : ");
		ch = sc.next().charAt(0);
		
		// 문자열의 길이 만큼 문자배열 생성
		chArr = new char[word.length()];
		
		// 문자열의 인덱스와 문자배열의 인덱스를 활용하여
		// 문자열의 문자를 문자배열에 복사
		for(int i = 0; i < chArr.length; i++) {
			chArr[i] = word.charAt(i);
		}
		
		System.out.print(word + "에 " + ch + "가 존재하는 위치(인덱스) : ");
		for(int i = 0; i < chArr.length; i++) {
			if(ch == chArr[i]) {
				count++;
				System.out.print(i + " ");
			}
		}
		System.out.println("\n" + ch + " 개수 : " + count);
		
//		for(int i = 0; i < chArr.length; i++) {
//			System.out.print(chArr[i]);
//		}
	}
	
	public static void practice6() {
		/*
		 *  "월" ~ "일" 까지 초기화된 문자열 배열 만들기
		 *  0부터 6까지 숫자를 입력 받아,
		 *  입력한 숫자와 같은 인덱스에 있는 요일을 출력
		 *  범위에 없는 숫자 입력 시 "잘못 입력하셨습니다" 출력
		 *  (활용 -> 1 ~ 31 까지의 일자값을 입력받아 그에 대응하는 요일 출력)
		 */
		String[] week = {"월", "화", "수", "목", "금", "토", "일"};
		int day;
		
		while(true) {
			System.out.print("1 ~ 31 사이 숫자 입력 : ");
			day = sc.nextInt();
			if(day >= 1 && day <= 31) {
				break;
			}
			System.out.println("잘못 입력하셨습니다.");
		}
		System.out.println(week[day % 7]);
	}
	
	public static void practice7() {
		/*
		 * 사용자가 배열의 길이를 입력
		 * 그 값만큼 정수형 배열을 선언 및 할당
		 * 배열의 크기만큼 사용자가 직접 값을 입력 -> 각각의 인덱스에 값을 초기화
		 * 배열 전체 값을 나열하고 인덱스에 저장된 값들의 합을 출력
		 */
		int[] arrVar;
		int num, total;
		
		System.out.print("정수 : ");
		num = sc.nextInt();
		
		arrVar = new int[num];
		
		for(int i = 0; i < num; i++) {
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
			arrVar[i] = sc.nextInt();
		}
		
		total = 0;
		for(int i = 0; i < arrVar.length; i++) {
			System.out.print(arrVar[i] + " ");
			total = total + arrVar[i];
		}
		
		System.out.println("\n총 합 : " + total);
	}
	
	public static void practice8() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//practice16();
		//practice15();
		//practice14();
		//practice13();
		//practice12();
		//practice11();
		//practice10();
		//practice9();
		practice8();
		//practice7();
		//practice6();
		//practice5();
		//practice4();
		//practice3();
		//practice2();
		//practice1();
	}

}
