package com.lld.chess_game;

public class App {
  public static void main(String[] args) {
    ChessGame chessGame = new ChessGame();
    chessGame.setPlayers("Alice", "Bob");
    chessGame.start();
  }
}
