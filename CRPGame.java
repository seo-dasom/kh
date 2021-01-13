package com.kh.CRP.controller;

import java.util.Random;

public class CRPGame {
	private int w = 0, l = 0, d = 0;
	
	void scoreInfo() {
		System.out.printf("현재 까지 스코어 %d승 %d패 %d무 입니다.\n", w, l, d);
	}
	
	public int[] getScore() {
		return new int[] { w, l, d };
	}
	
	public void setScore(int[] score) {
		w = score[0];	l = score[1];	d = score[2];
	}
	
	public void play(int player) {
		int computer = new Random().nextInt(3) + 1;
		
		if(computer == player) {
			System.out.println("비겼습니다.");
			d++;
		} else {
			if(computer == 1) {
				if(player == 2) {
					System.out.println("이겼습니다.");
					w++;
				} else if(player == 3) {
					System.out.println("졌습니다.");
					l++;
				}
			} else if(computer == 2) {
				if(player == 1) {
					System.out.println("졌습니다.");
					l++;
				} else if(player == 3) {
					System.out.println("이겼습니다.");
					w++;
				}
			} else if(computer == 3) {
				if(player == 1) {
					System.out.println("이겼습니다.");
					w++;
				} else if(player == 2) {
					System.out.println("졌습니다.");
					l++;
				}
			}
		}
		scoreInfo();
	}
}
