package com.lld.chess_game.pieces;

import com.lld.chess_game.Board;
import com.lld.chess_game.Cell;
import com.lld.chess_game.Color;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getCol() - from.getCol());
        return (rowDiff == colDiff) || (from.getRow() == to.getRow() || from.getCol() == to.getCol());
    }
}