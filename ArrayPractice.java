package com.kh.practice.array;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

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
		/*
		 * 3 이상인 홀수 자연수를 입력받기
		 * 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값 넣고,
		 * 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값 넣어 출력.
		 * 단, 입력한 정수가 홀수가 아니거나 3 미만일 경우
		 * "다시 입력하세요"를 출력하고 다시 정수 받기
		 * 
		 */
		int num1;	// 사용자 입력을 받아 저장하기 위한 변수
		int[] arr;	// 정수형 배열 변수, 사용자가 입력한 크기의 배열로 생성할 것.
		
		while(true) {
			System.out.print("정수 : ");
			num1 = sc.nextInt();
			if(num1 >= 3 && num1 % 2 == 1) {
				// 3 이상의 홀수값.
				break;
			}
			System.out.println("3 이상의 홀수 값으로 다시 입력하세요.");
		}
		
		arr = new int[num1];
		/* 정수 : 5				중간 위치 : 5 / 2 -> 2
		 * 1, 2, 3, 2, 1
		 * 
		 * 정수 : 7				중간 위치 : 7 / 2 -> 3
		 * 1, 2, 3, 4, 3, 2, 1
		 * 						중간 위치 : n / 2 -> 배열의 중간에 해당하는 인덱스
		 */
		int value = 1;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = value;
			if(i < arr.length / 2) {
				// 배열에 저장할 값 증가.
				value++;
			} else {
				// 배열에 저장할 값 감소.
				value--;
			}
		}
		// 결과 출력
		for(int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print(arr[arr.length - 1]);
		
//		int num, temp = 1;
//		int[] arrVar; // 배열 참조값
		

//		while(true) {
//			System.out.print("정수 : ");
//			num = sc.nextInt();
		
//			if(num >= 3 && num % 2 == 1) {
//				break;
//			}
//			System.out.println("3이상 홀수 값으로 다시 입력하세요.");
//		}
//		arrVar = new int[num];
			
//		// 배열의 크기 5 -> 1, 2, 3, 2, 1
//		for(int i = 0; i < arrVar.length; i++) {
//			arrVar[i] = temp;
//			if(i < arrVar.length / 2) {
//				temp++;
//			} else {
//				temp--;
//			}
//		}
//		for(int i = 0; i < arrVar.length - 1; i++) {
//			System.out.printf("%d, ", arrVar[i]);
//		}
//		System.out.printf("%d\n", arrVar[arrVar.length-1]);
	}
	
	public static void practice8_1() {
		/*
		 * 3 이상인 홀수 자연수를 입력받기
		 * 배열의 중간까지는 1부터 1씩 감소시키고,
		 * 중간 이후부터 끝까지는 1씩 증가한 값을 배열에 넣어 출력.
		 * 
		 * 정수 : 5				시작 값 : 5 / 2 + 1
		 * 3, 2, 1, 2, 3
		 * 
		 * 정수 : 7				시작 값 : 7 / 2 + 1
		 * 4, 3, 2, 1, 2, 3, 4
		 * 
		 * 정수 : 15				시작 값 : 15 / 2 + 1
		 * 8, 7, 6, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8
		 */
		int num;
		int[] arr;
		
		while(true) {
			System.out.print("정수 : ");
			num = sc.nextInt();
			
			if(num >= 3  && num % 2 == 1) {
				break;
			}
			System.out.println("3 이상의 홀수 값으로 다시 입력하세요.");
		}
		
		arr = new int[num];
		
		int value = arr.length / 2 + 1;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = value;
			if(i < arr.length / 2) {
				value--;
			} else {
				value++;
			}
		}
		
		for(int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print(arr[arr.length - 1]);
	}
	
	public static void practice9() {
		/*
		 * 사용자 입력
		 * 입력한 값이 배열에 있는지 검색
		 * 있으면 "oo치킨 배달 가능", 없으면 "oo치킨은 없는 메뉴입니다" 출력
		 * 메뉴 배열은 내가 정하기.
		 */
		String[] menu = {"후라이드", "양념", "갈비천왕", "레드콤보", "핫페퍼"};
		String name;
		boolean find = false;
		int index = 0;
		
		System.out.print("치킨 이름을 입력하세요 : ");
		name = sc.next();
		
		for(int i = 0; i < menu.length; i++) {
			if(name.equals(menu[i])) {
				find = true;
				index = i;
			}
		}
		if(find) {
			System.out.println(menu[index] + "치킨 배달 가능");
		} else {
			System.out.println(name + "치킨은 없는 메뉴입니다.");
		}
	}
	
	public static void practice9_1() {
		
		String[] chickens = {"후라이드", "양념", "간장", "갈릭", "크리스피", "파"};
		String search;
		boolean find = false; // 메뉴를 찾은 경우 true로 설정
		int index = 0;
		
		System.out.print("치킨 이름을 입력하세요 : ");
		search = sc.next();
		
		for(int i = 0; i < chickens.length; i++) {
			if(chickens[i].equals(search)) {
				find = true;
				index = i;
				break;
			}
		}
		
		if(find) {
			System.out.println(chickens[index] + "치킨 배달 가능");
		} else {
			System.out.println(search + "치킨은 없는 메뉴입니다.");
		}
	}
	
		public static void practice9_2() {
		/*
		 * 치킨 메뉴와 배열과 동일한 크기의 치킨 메뉴의 가격을 저장하는 배열을 생성하고
		 * 사용자가 입력한 문자열이 치킨 메뉴 배열에 존재하는지 검색 후
		 * 존재하면 " xxx 치킨 가격은 XXXXX원 입니다." 없으면
		 * "xxx 치킨은 없는 메뉴입니다." 출력
		 */
		String[] chickens = {"후라이드", "양념", "간장", "갈릭", "크리스피", "파"};
		int[] chickensAmount = {10000, 11000, 12000, 12000, 9000, 11000};
		String search;
		boolean find = false; // 메뉴를 찾은 경우 true로 설정
		int index = 0;
		
		System.out.print("치킨 이름을 입력하세요 : ");
		search = sc.next();
		
		for(int i = 0; i < chickens.length; i++) {
			if(chickens[i].equals(search)) {
				find = true;
				index = i;
				break;
			}
		}
		
		if(find) {
			System.out.println(chickens[index] + "치킨 가격은 " + chickensAmount[index] + "원 입니다.");
		} else {
			System.out.println(search + "치킨은 없는 메뉴입니다.");
		}
	}
	
	public static void practice10() {
		/*
		 * 주민등록번호(-포함) 입력
		 * 성별자리 이후부터 *로 가리고 출력
		 * 단, 원본은 유지하면서 복사본에만 *로 가려서 저장 후 출력
		 */
		String id = "";
		char[] idArr, copArr;
		
		while(true) {
			System.out.print("주민등록번호(-포함) : ");
			id = sc.next();
			
			if(id.length() == 14 && id.charAt(6) == '-') {
				break;
			}
		}
		// 배열 사이즈 정하기
		idArr = new char[id.length()];
		copArr = new char[id.length()];
		
		// 입력된 주민번호 배열로 만들기
		for(int i = 0; i < id.length(); i++) {
			idArr[i] = id.charAt(i);
		}
		
		// 원본에서 카피본으로 -> 다른 배열에 복사
		// 123456-1234567
		System.arraycopy(idArr, 0, copArr, 0, 8);
		for(int i = 8; i < idArr.length; i++) {
			copArr[i] = '*';
		}
		// 복사된 배열 출력
		for(int i = 0; i < copArr.length; i++) {
			System.out.print(copArr[i]);
		}
	}
	
	public static void practice10_1() {
		/*
		 * 주민등록번호(-포함) 입력
		 * 성별자리 이후부터 *로 가리고 출력
		 * 단, 원본은 유지하면서 복사본에만 *로 가려서 저장 후 출력
		 * 
		 * 사용자 선택에 따라서 성별 이후의 주민등록번호가 *로 복사본에 저장하는 것과
		 * 생년월일의 생년월 이후의 주민등록 번호가 *로 복사본에 저장하는 것으로 구분
		 * 
		 * 123456-1234567 -> 성별 이후의 번호	-> 123456-1******
		 * 123456-1234567 -> 생년월 이후의 번호	-> 1234**-*******
		 */
		String jumin;
		String temp;
		
		// 반드시 - 포함이 되어 있는지 체크.
		// 주민등록번호 길이가 - 포함하여 14 자 인지 체크.
		// 123456-1234567
		while(true) {
			System.out.print("주민등록번호(- 포함) : ");
			jumin = sc.next();
			if(jumin.length() != 14) {
				System.out.println("주민등록번호는 - 포함하여 14자 입니다.");
				continue;
			}
			if(jumin.charAt(6) != '-') {
				System.out.println("올바르지 않은 주민등록번호 형식 입니다.");
				continue;
			}
			break;
		}
		while(true) {
			System.out.print("주민번호 숨김처리(성별, 생년월 이후) : ");
			temp = sc.next();
			
			if(temp.equals("성별") || temp.equals("생년월")) {
				break;
			}
			System.out.println("성별 또는 생년월로 입력하세요.");
		}
		
		char[] orgJumin = new char[14];
		char[] copJumin = new char[14];
		char[] tmpJumin;
		
		// 문자열을 문자배열에 저장(원본저장)
		for(int i = 0; i < jumin.length(); i++) {
			orgJumin[i] = jumin.charAt(i);
		}
		
		// 원본 문자배열의 데이터를 복사본 문자배열로 복사
		// 성별정보 이후의 값은 *로 저장
		// 123456-1234567
		if(temp.equals("성별")) {
			for(int i = 0; i < orgJumin.length; i++) {
				if(i <= 7) {
					copJumin[i] = orgJumin[i];
				} else {
					copJumin[i] = '*';
				}
			}
			
		} else {
			for(int i = 0; i < orgJumin.length; i++) {
				if(i <= 3) {
					copJumin[i] = orgJumin[i];
				} else {
					copJumin[i] = '*';
					if(i == 6) {
						copJumin[i] = '-';
					}
				}
			}
		}
		System.out.print("원본 주민번호 : ");
		for(int i = 0; i < orgJumin.length; i++) {
			System.out.print(orgJumin[i]);
		}
		System.out.print("\n");
		
		System.out.print("복사본 주민번호 : ");
		for(int i = 0; i < copJumin.length; i++) {
			System.out.print(copJumin[i]);
		}
	}
	
	public static void practice12() {
		/*
		 *  10개의 값을 저장할 수 있는 배열 선언 후 1 ~ 10 사이의 난수를 생성하여
		 *  초기화 후 배열 전체의 값 출력 후 최대값, 최소값도 출력
		 */
		Random rand = new Random();
		int[] randArr = new int[10];
		
		for(int i = 0; i < randArr.length; i++) {
			randArr[i] = rand.nextInt(10) + 1;
		}
		
		for(int i = 0; i < randArr.length; i++) {
			System.out.print(randArr[i] + " ");
		}
		
		// 최대값, 최소값
		int max = randArr[0], min = randArr[0];
		for(int i = 1; i < randArr.length; i++) {
			if(randArr[i] > max) {
				max = randArr[i];
			}
			if(randArr[i] < min) {
				min = randArr[i];
			}
		}
		System.out.println("\n최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
	
	public static void practice13() {
		/*
		 *  10개의 값을 저장할 수 있는 배열 선언 후 1 ~ 10 사이의 난수를 생성하여 초기화
		 *  단, 중복된 값이 들어가면 안된다.
		 */
		Random rand = new Random();
		int[] randArr = new int[10];
		int temp;
		boolean dup = false;		// 중복된 정수값이 있음을 구분하기 위한 변수
		
		randArr[0] = rand.nextInt(10) + 1;
		for(int i = 1; i < randArr.length;) {
			dup = false;
			temp = rand.nextInt(10) + 1;
			for(int j = 0; j < i; j++) {
				if(randArr[j] == temp) {
					dup = true;
					break;
				}
			}
			if(!dup) {	// 중복이 아니면, 추가
				randArr[i] = temp;
				i++;
			}
		}
		
		for(int i = 0; i < randArr.length; i++) {
			System.out.print(randArr[i] + " ");
		}
	}
	
	public static void practice14() {
		
	}
	
	public static void practice15() {
		
	}
	
	public static void practice16() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//practice16();
		//practice15();
		//practice14();
		practice13();
		//practice12();
		//practice10_1();
		//practice10();
		//practice9_2();
		//practice9_1();
		//practice9();
		//practice8_1();
		//practice8();
		//practice7();
		//practice6();
		//practice5();
		//practice4();
		//practice3();
		//practice2();
		//practice1();
	}

}
