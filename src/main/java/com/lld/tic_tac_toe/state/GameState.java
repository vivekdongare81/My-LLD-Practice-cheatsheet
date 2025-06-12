package com.lld.tic_tac_toe.state;

import com.lld.tic_tac_toe.Player;

public interface GameState {
	void next(GameContext context, Player player, boolean hasWon);
	boolean isGameOver();
}
