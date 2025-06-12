package com.lld.tic_tac_toe;

import com.lld.tic_tac_toe.state.GameContext;
import com.lld.tic_tac_toe.state.GameState;

public class TicTacToe {
	private final Board board;
	private final Player[] players;
	private int currentPlayerIndex;
	// private GameStatus status;
	private GameContext gameContext;

	public TicTacToe(Player player1, Player player2, int rows, int cols) {
		this.board = new Board(rows, cols);
		this.players = new Player[] { player1, player2 };
		// this.status = GameStatus.IN_PROGRESS;
		this.gameContext = new GameContext();
	}

	public synchronized boolean playMove(int row, int col) {

		if (gameContext.isGameOver()) {
			throw new IllegalStateException("Game already finished.");
		}

//		if (status != GameStatus.IN_PROGRESS) {
//			throw new IllegalStateException("Game already finished.");
//		}

		if (!board.isValidMove(row, col)) {
			throw new IllegalArgumentException("Invalid move.");
		}

		Player player = players[currentPlayerIndex];
		board.placeMove(row, col, player.getSymbol());

		if (board.checkWin(player.getSymbol())) {
			// status = GameStatus.WIN;
			gameContext.next(player, true);
			System.out.println(player.getName() + " wins!");
		} else if (board.isFull()) {
			// status = GameStatus.DRAW;
			gameContext.next(player, true);
			System.out.println("Game ended in a draw.");
		} else {
			gameContext.next(player, false); // switch state
			currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
		}
		return true;
	}

	public synchronized void reset() {
		board.reset();
		currentPlayerIndex = 0;
		this.gameContext = new GameContext();
		// status = GameStatus.IN_PROGRESS;
	}

//	public GameStatus getStatus() {
//		return status;
//	}
//

	public GameState getCurrState() {
		return gameContext.getCurrState();
	}

	public void printBoard() {
		board.print();
	}
}
