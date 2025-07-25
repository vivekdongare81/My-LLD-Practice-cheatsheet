package com.lld.chess_game.pieces;

import com.lld.chess_game.Board;
import com.lld.chess_game.Cell;
import com.lld.chess_game.Color;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        return (from.getRow() == to.getRow() || from.getCol() == to.getCol());
    }
}
