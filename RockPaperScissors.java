package com.kh.practice.comp;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
	public static Scanner sc = new Scanner(System.in);
	public static void rps() {
		/*
		 * 사용자 이름 입력
		 * 컴퓨터와 가위바위보
		 * 컴퓨터 (가위,바위,보)는 랜덤으로 결정
		 * 사용자에게는 직접 가위바위보 출력
		 * 사용자가 "exit"를 입력하기 전까지 계속 진행
		 * "exit" 입력 시 반복 멈추고
		 * 몇번의 승부에서 몇번 이기고,몇번 비기고,몇번 졌는지 출력.
		 */
		Random rand = new Random();
		
		String user, com, input = "";
		int win = 0, lose = 0, draw = 0;
		int random = 0;
		
		System.out.print("당신의 이름을 입력해주세요 : ");
		user = sc.next();
		
		while(true) {
			random = rand.nextInt(3);
			if(random == 0) {
				com = "가위";
			} else if(random == 1) {
				com = "바위";
			} else {
				com = "보";
			}
			System.out.print("가위바위보 : ");
			input = sc.next();
			
			if(input.equals("exit")) {
				System.out.println((win+draw+lose)+"전 "+win+"승 "+draw+"무 "+lose+"패");
				break;
			}
			
			System.out.printf("컴퓨터 : %s\n", com);
			System.out.println(user + " : " + input);
			
			switch(input) {
				case "가위" :
					if(com.equals("가위")) {
						System.out.println("비겼습니다.");
						draw++;
					} else if(com.equals("바위")) {
						System.out.println("졌습니다 ㅠㅠ");
						lose++;
					} else {
						System.out.println("이겼습니다 !");
						win++;
					}
					break;
				case "바위" :
					if(com.equals("바위")) {
						System.out.println("비겼습니다.");
						draw++;
					} else if(com.equals("가위")) {
						System.out.println("졌습니다 ㅠㅠ");
						lose++;
					} else {
						System.out.println("이겼습니다 !");
						win++;
					}
					break;
				case "보" :
					if(com.equals("보")) {
						System.out.println("비겼습니다.");
						draw++;
					} else if(com.equals("가위")) {
						System.out.println("졌습니다 ㅠㅠ");
						lose++;
					} else {
						System.out.println("이겼습니다 !");
						win++;
					}
					break;
					
					default :
						System.out.println("잘못 입력하셨습니다.\n");
				}
			}
		}
	
	public static void main(String[] args) {
		rps();
		sc.close();
	}
}