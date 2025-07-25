package com.lld.chess_game.pieces;

import com.lld.chess_game.Board;
import com.lld.chess_game.Cell;
import com.lld.chess_game.Color;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    
    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        int rowDiff = to.getRow() - from.getRow();
        int colDiff = Math.abs(to.getCol() - from.getCol());

        if (color == Color.WHITE) {
            return (rowDiff == 1 && colDiff == 0) ||
                    (from.getRow() == 1 && rowDiff == 2 && colDiff == 0) ||
                    (rowDiff == 1 && colDiff == 1 && board.getPiece(to.getRow(), to.getCol()) != null);
        } else {
            return (rowDiff == -1 && colDiff == 0) ||
                    (from.getRow() == 6 && rowDiff == -2 && colDiff == 0) ||
                    (rowDiff == -1 && colDiff == 1 && board.getPiece(to.getRow(), to.getCol()) != null);
        }
    }
}