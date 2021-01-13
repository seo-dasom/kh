package com.kh.practice.game;

import com.kh.CRP.view.CRPMenu;

/*
 *  1. 메뉴 출력과 메뉴 선택 후 게임을 진행시키기 위한 클래스
 *  2. 게임 로직이 구현되어 있는 클래스
 *  3. 데이터 저장 및 불러오기를 위한 클래스
 */

public class RockPaperScissors {
	
	public static void main(String[] args) {
		/*
		 *  ./, ../ : 상대경로, 현재 프로그램이 실행되는 위치에서 부터의 상대적 경로를 표기할 때 사용
		 *  		  ./ -> 현재 실행 위치,  ../ -> 현재 실행 위치의 상위 위치
		 *  C:/, D:/, /: 절대 경로, 최상위 경로부터 시작하는 전체 경로를 표기할 때 사용
		 */
		CRPMenu crp = new CRPMenu();
		crp.start();
	}
}
