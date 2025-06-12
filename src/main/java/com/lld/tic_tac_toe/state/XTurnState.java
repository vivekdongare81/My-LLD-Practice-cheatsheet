package com.lld.tic_tac_toe.state;

import com.lld.tic_tac_toe.Player;

public class XTurnState implements GameState {
	private boolean isGameOver = false;


	@Override
	public void next(GameContext context, Player player , boolean hasWon) {
		if(hasWon) {
			context.setCurrState(new FinishState());
		}else {
			context.setCurrState(new OTurnState());
		}
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	
}
