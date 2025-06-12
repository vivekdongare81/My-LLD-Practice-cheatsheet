package com.lld.tic_tac_toe.state;

import com.lld.tic_tac_toe.Player;

public class FinishState implements GameState {
	private boolean isGameOver = true;

	@Override
	public void next(GameContext context, Player player, boolean hasWon) {
		// TODO Auto-generated method stub

	}
	
	public boolean isGameOver() {
		return isGameOver;
	}

}