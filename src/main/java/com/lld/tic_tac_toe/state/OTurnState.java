package com.lld.tic_tac_toe.state;

import com.lld.tic_tac_toe.Player;

public class OTurnState implements GameState {
	private boolean isGameOver = false;

	@Override
	public void next(GameContext context, Player player , boolean hasWon) {
		if(hasWon) {
			context.setCurrState(new FinishState());
		}else {
			context.setCurrState(new XTurnState());
		}
	}

	public boolean isGameOver() {
		return isGameOver;
	}


}
