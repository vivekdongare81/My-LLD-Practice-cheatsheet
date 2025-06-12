package com.lld.tic_tac_toe.state;

import com.lld.tic_tac_toe.Player;

public class GameContext {
	private GameState currState;

	public GameContext() {
		this.currState = new XTurnState(); // start with X
	}

	public void next(Player player, boolean hasWon) {
		currState.next(this, player, hasWon);
	}

	public boolean isGameOver() {
		return currState.isGameOver();
	}

	public GameState getCurrState() {
		return currState;
	}

	public void setCurrState(GameState currState) {
		this.currState = currState;
	}

}
