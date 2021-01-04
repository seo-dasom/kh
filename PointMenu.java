package com.kh.practice.point.view;

import java.util.Scanner;
import com.kh.practice.point.controller.*;

public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		int select;
		while(true) {
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			select = sc.nextInt();
			
			if(select != 1 && select != 2 && select != 9) {
				System.out.println("보기에 있는 메뉴 번호를 골라주세요.");
				continue;
			} else if(select == 1) {
				circleMenu();
				break;
			} else if(select == 2) {
				rectangleMenu();
				break;
			} else {
				System.out.println("종료합니다.");
				System.exit(0);
			}
		}
	}
	
	public void circleMenu() {
		int select;
		
		while(true) {
			System.out.println("===== 원 메뉴 =====");
			System.out.println("1. 원 둘레");
			System.out.println("2. 원 넓이");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			select = sc.nextInt();
			
			if(select != 1 && select != 2 && select != 9) {
				System.out.println("잘못 입력하셨습니다. 메인 메뉴로 돌아갑니다.");
				mainMenu();
				continue;
			} else if(select == 1) {
				calcCircum();
				break;
			} else if(select == 2) {
				calcCircleArea();
				break;
			} else {
				mainMenu();
				break;
			}
		}
	}
	
	public void rectangleMenu() {
		int select;
		
		while(true) {
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 넓이");
			System.out.println("3. 메인으로");
			System.out.print("메뉴 번호 : ");
			select = sc.nextInt();
			
			if(select != 1 && select != 2 && select != 3) {
				System.out.println("잘못 입력하셨습니다. 메인 메뉴로 돌아갑니다.");
				mainMenu();
				continue;
			} else if(select == 1) {
				calcPerimeter();
				break;
			} else if(select == 2) {
				calcRectArea();
				break;
			} else {
				mainMenu();
				break;
			}
		}
	}
	
	public void calcCircum() {
		System.out.print("x 좌표 : ");
		int locationX = sc.nextInt();
		System.out.print("y 좌표 : ");
		int locationY = sc.nextInt();
		System.out.print("반지름 : ");
		int R = sc.nextInt();
		
		System.out.println(cc.calCircum(locationX, locationY, R));
		mainMenu();
	}
	
	public void calcCircleArea() {
		System.out.print("x 좌표 : ");
		int locationX = sc.nextInt();
		System.out.print("y 좌표 : ");
		int locationY = sc.nextInt();
		System.out.print("반지름 : ");
		int R = sc.nextInt();
		
		System.out.println(cc.calcArea(locationX, locationY, R));
		mainMenu();
	}
	
	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int locationX = sc.nextInt();
		System.out.print("y 좌표 : ");
		int locationY = sc.nextInt();
		System.out.print("높이 : ");
		int H = sc.nextInt();
		System.out.print("너비 : ");
		int W = sc.nextInt();
		
		System.out.println(rc.calcPerimeter(locationX, locationY, H, W));
		mainMenu();
	}
	
	public void calcRectArea() {
		System.out.print("x 좌표 : ");
		int locationX = sc.nextInt();
		System.out.print("y 좌표 : ");
		int locationY = sc.nextInt();
		System.out.print("높이 : ");
		int H = sc.nextInt();
		System.out.print("너비 : ");
		int W = sc.nextInt();
		
		System.out.println(rc.clacArea(locationX, locationY, H, W));
		mainMenu();
	}
}
