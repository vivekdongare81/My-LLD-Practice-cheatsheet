package com.lld.tic_tac_toe;

public class Player {
	private final String name;
	private final Symbol symbol;

	public Player(String name, Symbol symbol) {
		super();
		this.name = name;
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public Symbol getSymbol() {
		return symbol;
	}

}
