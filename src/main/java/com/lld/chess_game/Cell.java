package com.lld.chess_game;

import com.lld.chess_game.pieces.Piece;

public class Cell {
    private final int row, col;
    private Piece piece;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean isOccupied() {
        return piece != null;
    }

    public Piece getPiece() { return piece; }
    public void setPiece(Piece piece) { this.piece = piece; }

    public int getRow() { return row; }
    public int getCol() { return col; }
}
