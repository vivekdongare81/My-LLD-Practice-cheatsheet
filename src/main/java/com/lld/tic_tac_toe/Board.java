package com.lld.tic_tac_toe;

public class Board {
	private final Cell[][] grid;
	private final int movesCount;
	private final int rows;
	private final int cols;

	public Board(int n, int m) {
		this.rows = n;
		this.cols = m;
		movesCount = 0;
		grid = new Cell[n][m];
		initializeBoard();
	}

	private void initializeBoard() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				grid[i][j] = new Cell();
			}
		}
	}

	public boolean isValidMove(int row, int col) {
		return row >= 0 && col >= 0 && row < rows && col < cols && grid[row][col].isEmpty();
	}

	public void placeMove(int i, int j, Symbol symbol) {
		grid[i][j].setSymbol(symbol);
	}

	public boolean checkWin(Symbol symbol) {
		// Check rows
		for (int i = 0; i < rows; i++) {
			boolean rowWin = true;
			for (int j = 0; j < cols; j++) {
				if (grid[i][j].getSymbol() != symbol) {
					rowWin = false;
					break;
				}
			}
			if (rowWin)
				return true;
		}

		// Check columns
		for (int j = 0; j < cols; j++) {
			boolean colWin = true;
			for (int i = 0; i < rows; i++) {
				if (grid[i][j].getSymbol() != symbol) {
					colWin = false;
					break;
				}
			}
			if (colWin)
				return true;
		}

		// Check diagonal (only if square)
		if (rows == cols) {
			boolean diag1 = true, diag2 = true;
			for (int i = 0; i < rows; i++) {
				if (grid[i][i].getSymbol() != symbol)
					diag1 = false;
				if (grid[i][cols - i - 1].getSymbol() != symbol)
					diag2 = false;
			}
			if (diag1 || diag2)
				return true;
		}

		return false;
	}

	public boolean isFull() {
		return movesCount == rows * cols;
	}

	public void reset() {
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				grid[i][j].setSymbol(Symbol.EMPTY);
	}

	public void print() {
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				System.out.print(grid[row][col].getSymbol() + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
