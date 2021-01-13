package com.kh.CRP.controller;

import com.kh.CRP.model.dao.CRPDAO;

public class CRPController {
	private CRPDAO data = new CRPDAO();
	private CRPGame game = new CRPGame();
	
	public void newGame(int player) {
		game.play(player);
		data.save(game.getScore());
	}
	
	public void loadGame(int player) {
		game.setScore(data.load());
		game.play(player);
		data.save(game.getScore());
	}
	
	public void printScore() {
		game.setScore(data.load());
		game.scoreInfo();
	}
}
