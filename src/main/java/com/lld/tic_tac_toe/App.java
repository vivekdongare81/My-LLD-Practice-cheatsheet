package com.lld.tic_tac_toe;

public class App {
	public static void main(String[] args) {
        Player player1 = new Player("Player 1", Symbol.X);
        Player player2 = new Player("Player 2", Symbol.O);

        TicTacToe game = new TicTacToe(player1, player2, 3 ,3);
        game.playMove(0, 0);
        game.printBoard();
        System.out.println( game.getCurrState());
        game.playMove(0, 1);
        game.printBoard();
        System.out.println( game.getCurrState());

        game.playMove(2, 2);
        game.printBoard();
        System.out.println( game.getCurrState());

        game.playMove(0, 2);
        game.printBoard();
        System.out.println( game.getCurrState());

        game.playMove(1, 1);
        game.printBoard();
        System.out.println( game.getCurrState());

	}
}
