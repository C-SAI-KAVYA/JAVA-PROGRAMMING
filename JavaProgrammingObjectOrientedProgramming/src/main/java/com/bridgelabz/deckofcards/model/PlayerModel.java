package com.bridgelabz.deckofcards.model;

public class PlayerModel {
	
	private String name;
	public CardModel[] playCards = new CardModel[13];
	
	public PlayerModel(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
