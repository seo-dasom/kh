package com.kh.CRP.view;

import java.util.Scanner;

import com.kh.CRP.controller.CRPController;

public class CRPMenu {
	private CRPController game = new CRPController();
	private Scanner sc = new Scanner(System.in);
	
	private void printMainMenu() {
		String menu = "";
		menu += "┌--------------------------┐\n";
		menu += "|┌------------------------┐|\n";
		menu += "||		가위 바위 보 게임	   ||\n";
		menu += "|└------------------------┘|\n";
		menu += "├--------------------------┤\n";
		menu += "| 1. 새 게임					|\n";
		menu += "| 2. 게임 불러오기				|\n";
		menu += "| 3. 기록 확인하기				|\n";
		menu += "| 4. 게임 종료				|\n";
		menu += "└--------------------------┘\n";
		menu += " : ";
		System.out.print(menu);
	}
	
	private void printCRPMenu() {
		String strCPR = "";
		strCPR += "┌-----------------------------┐\n";
		strCPR += "| 1. 가위                     	 |\n";
		strCPR += "| 2. 바위                     	 |\n";
		strCPR += "| 3. 보						 |\n";
		strCPR += "| 4. 그만!               	     |\n";
		strCPR += "└-----------------------------┘\n";
		strCPR += " : ";
		System.out.print(strCPR);
	}
	
	public void start() {
		printMainMenu();
		int menuNumber = sc.nextInt();	sc.nextLine();
		
		if(menuNumber == 1) {
			// 새 게임
			printCRPMenu();	// 가위 바위 보 선택 출력
			int player = sc.nextInt();	sc.nextLine();
			if(player != 4) {
				game.newGame(player);
			}
		} else if(menuNumber == 2) {
			// 게임 불러오기
			printCRPMenu();	// 가위 바위 보 선택 출력
			int player = sc.nextInt();	sc.nextLine();
			if(player != 4) {
				game.loadGame(player);
			}
		} else if(menuNumber == 3) {
			// 기록 확인하기
			game.printScore();
		} else if(menuNumber == 4) {
			System.exit(0);
		}
	}
}
