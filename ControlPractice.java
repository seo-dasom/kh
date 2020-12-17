package com.kh.practice.chap01;

import java.util.Scanner;

public class ControlPractice {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void practice1() {
		// 조건문_1번 문제
		int num;
		
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		System.out.println("메뉴 번호를 입력하세요 : ");
		
		num = sc.nextInt();
		
//		if (num == 1) {
//			System.out.println("입력 메뉴입니다.");
//		} else if(num == 2) {
//			System.out.println("수정 메뉴입니다.");
//		} else if (num == 3) {
//			System.out.println("조회 메뉴입니다.");
//		} else if (num == 4) {
//			System.out.println("삭제 메뉴입니다.");
//		} else if (num == 7) {
//			System.out.println("프로그램이 종료됩니다.");
//		} else {
//			System.out.println("잘못된 메뉴 번호 입니다.");
//		}
		
		switch(num) {
		case 1:
			System.out.println("입력 메뉴입니다."); break;
		case 2:
			System.out.println("수정 메뉴입니다."); break;
		case 3:
			System.out.println("조회 메뉴입니다."); break;
		case 4:
			System.out.println("삭제 메뉴입니다."); break;
		case 7:
			System.out.println("프로그램이 종료됩니다."); break;
		default:
			System.out.println("잘못된 메뉴 번호 입니다.");
		}
	}
	
	public static void practice2() {
		// 2번 문제
		int num;
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		num = sc.nextInt();
		
//		if(num > 0) {
//			if(num % 2 == 0) {
//				System.out.println("짝수다.");
//			} else {
//				System.out.println("홀수다.");
//			} 
//		} else {
//			System.out.println("양수만 입력해주세요.");
//		}
		
		if(num > 0) {
			switch(num % 2) {
			case 0:
				System.out.println("짝수다."); break;
			case 1:
				System.out.println("홀수다."); break;
			}
		} else {
			System.out.println("양수만 입력해주세요.");
		}
	}
	
	public static void practice3() {
		int x, y, z, tot;
		double avg;

		System.out.print("국어점수 : ");
		x = sc.nextInt();
		
		System.out.print("영어점수 : ");
		y = sc.nextInt();
		
		System.out.print("수학점수 : ");
		z = sc.nextInt();
		
		tot = x + y + z;
		avg = tot / 3.0;

		if (x >= 40 && y >= 40 && z >= 40 && avg >=60) {
			System.out.printf("국어 : %d 점\n", x);
			System.out.printf("영어 : %d 점\n", y);
			System.out.printf("수학 : %d 점\n", z);
			System.out.printf("합계 : %d 점\n", tot);
			System.out.printf("평균 : %.2f 점\n", avg);
			System.out.println("축하합니다. 합격입니다!");
		} else {
			System.out.println("불합격입니다.");
		}
	}
	public static void practice4() {
		
		int month = 0;
		String season;
		
		System.out.print("1~12 사이의 정수 입력 : ");
		month = sc.nextInt();
		
		switch(month) {
		
		case 1: case 2: case 12:
			season = "겨울"; break;
		case 3: case 4: case 5:
			season = "봄"; break;
		case 6 : case 7: case 8:
			season = "여름"; break;
		case 9: case 10: case 11:
			season = "가을"; break;
		default:
			season = "잘못 입력된 달입니다.";
		}
		
		System.out.printf("%d월은 %s입니다.", month, season);
	}
	public static void practice5() {
		// 5번 문제
		String id, pw;
		String id_input, pw_input;
		
		id = "myId";   pw = "myPassword12";
		
		System.out.print("아이디 입력 : ");
		id_input = sc.next();
		
		System.out.print("패스워드 입력 : ");
		pw_input = sc.next();
		
		if(id.equals(id_input) && pw.equals(pw_input)) {
			System.out.println("로그인 성공");
		} else {
			if(!id.equals(id_input) && !pw.equals(pw_input)) {
				System.out.println("아이디와 패스워드가 틀렸습니다.");
			} else if(!id.equals(id_input)){
				System.out.println("아이디가 틀렸습니다.");
			} else if(!pw.equals(pw_input)){
				System.out.println("패스워드가 틀렸습니다.");
			}
		}
	}
	public static void practice6() {
		// 6번 문제
		String perm;
		
		System.out.print("회원 등급(관리자, 회원, 비회원) : ");
		perm = sc.next();
		
//		if(perm.equals("관리자")) {
//			System.out.println("회원관리, 게시글 관리, 게시글 작성, 게시글 조회, 댓글 작성");
//		} else if(perm.equals("회원")) {
//			System.out.println("게시글 작성, 게시글 조회, 댓글 작성");
//		} else if(perm.equals("비회원")) {
//			System.out.println("게시글 조회");
//		} else {
//			System.out.println("잘못된 권한 등급입니다.");
//		}
		String res = "";
		
		switch(perm) {
		case "관리자":
			res += "회원관리, 게시글 관리, ";  //// res = res + "회원관리, 게시글 관리";
		case "회원":
			res += "게시글 작성, 댓글 작성, "; // res = res + "게시글 작성, 댓글 작성";
		case "비회원":
			res += "게시글 조회";           // res = res + "게시글 조회";
			break;
		default:
			res = "잘못된 권한 등급입니다.";
		}
		System.out.println(res);
	}
	public static void practice7() {
		// 7번 문제 BMI = 몸무게 / (키(m)*키(m))
		double tall, weight, bmi;
		String res;
		
		System.out.print("키(cm)를 입력해주세요 : ");
		tall = sc.nextDouble();
		tall /= 100;      // tall = tall / 100;
		
		System.out.print("몸무게(kg)를 입력해주세요 : ");
		weight = sc.nextDouble();
		
		bmi = weight / (tall * tall);
		
//		if(bmi < 18.5) {
//			res = "저체중";
//		} else if(bmi >= 18.5 && bmi < 23) {
//			res = "정상체중";
//		} else if(bmi >= 23 && bmi < 25) {
//			res = "과체중";
//		} else if(bmi >= 25 && bmi < 30) {
//			res = "비만";
//		} else if(bmi >= 30) {
//			res = "고도비만";
//		} else {
//			res = "잘못된 입력값이 있습니다.";
//		}

		if(bmi < 18.5) {
			res = "저체중";
		} else if(bmi< 23) {
			res = "정상체중";
		} else if(bmi< 25) {
			res = "과체중";
		} else if(bmi< 30) {
			res = "비만";
		} else {
			res = "고도비만";
		}
		
		System.out.printf("BMI 지수 : %.2f\n", bmi);
		System.out.println(res);
	}
	public static void practice8() {
		// 8번 문제
		int a, b;
		int iRes = 0;   double dRes = 0.0;
		char op, flag;  // 계산 결과가 저장된 자료형의 종류를 구분하기 위한 플래그, 'i', 'd'
		
		System.out.print("피연산자 1 : ");
		a = sc.nextInt();
		
		System.out.print("피연산자 2 : ");
		b = sc.nextInt();
		
		System.out.print("연산자(+,-,*,/,%) : ");
		op = sc.next().charAt(0);
		
		if( a > 0 && b > 0) {
		switch(op) {
		case '+' :
			iRes = a + b;  flag = 'i';
//			System.out.printf("%d + %d = %d", a, b, a + b);
			break;
		case '-' :
			iRes = a - b;  flag = 'i';
//			System.out.printf("%d - %d = %d", a, b, a - b);
			break;
		case '*' :
			iRes = a * b;  flag = 'i';
//			System.out.printf("%d * %d = %d", a, b, a * b);
			break;
		case '/' :
			dRes = (double)a / b;  flag = 'd';
//			System.out.printf("%d / %d = %d", a, b,(double)a / b);
			break;
		case '%' :
			iRes = a % b;  flag = 'i';
//			System.out.printf("%d %% %d = %d", a, b, a % b);
			break;
		default:
			flag = 'e';
			System.out.printf("잘못 입력하셨습니다. 프로그램을 종료합니다.");
//			System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
		   }
		if (flag == 'i') {
			System.out.printf("%d %c %d = %d", a, op, b, iRes);
		} else if (flag == 'd') {
			System.out.printf("%d %c %d = %f", a, op, b, dRes);
		}
		}
	}
	public static void practice9() {
		// 9번 문제
		double mid, fin, hw, att_jum, att_rate, tot;
		int att;
		
		System.out.print("중간고사 점수 : ");
		mid = sc.nextDouble();
		System.out.print("기말고사 점수 : ");
		fin = sc.nextDouble();
		System.out.print("과제 점수 : ");
		hw = sc.nextDouble();
		System.out.print("출석 회수 : ");
		att = sc.nextInt();
		
		fin = fin / 100 * 30;
		hw = hw / 100 * 30;
		mid = mid / 100 * 20;
		att_jum = att / 20.0 * 20;
		att_rate = att / 20.0 * 100;
		tot = mid + fin + hw + att;
		
		System.out.println("=================결과=================");
		System.out.println("중간고사(20) : " + mid);
		System.out.println("기말고사(30) : " + fin);
		System.out.println("과제점수(30) : " + hw);
		System.out.println("출석점수(20) : " + att_jum);
		System.out.println("총점 : " + tot);
		
		if(tot >= 70) {
			if(100 - att_rate >= 30) {
				System.out.println("Fail [출석 부족 " + att + "/20]");
			} else {
				System.out.println("PASS");
			}
		} else {
			System.out.println("Fail [점수 미달]");
		}
	}
	public static void practice10() {
		// 10번 문제
		
		int menu;
		
		System.out.println("실행할 기능을 선택하세요.");
		System.out.println("1. 메뉴 출력");
		System.out.println("2. 짝수/홀수");
		System.out.println("3. 합격/불합격");
		System.out.println("4. 계절");
		System.out.println("5. 로그인");
		System.out.println("6. 권한 확인");
		System.out.println("7. BMI");
		System.out.println("8. 계산기");
		System.out.println("9. P/F");
		
		System.out.print("선택 : ");
		menu = sc.nextInt();
		
		switch(menu) {
		case 1 :
		    practice1();
			break;
		case 2 :
			practice2();
			break;
		case 3 :
			practice3();
			break;
		case 4 :
			practice4();
			break;
		case 5 :
			practice5();
			break;
		case 6:
			practice6();
			break;
		case 7:
			practice7();
			break;
		case 8:
			practice8();
			break;
		case 9:
			practice9();
			break;
		default:
			System.out.println("올바른 메뉴를 입력하세요");	
		}
	}
	public static void main(String[] args) {
		practice10();
		sc.close();
	}

}
