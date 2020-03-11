package com.bridgelabz.deckofcards.model;

public class DeckOfCardsModel {
	static final int SIZE = 52;
	public CardModel[] deckOfCards = new CardModel[SIZE];
	
	public DeckOfCardsModel() {
		int count = 0;
		
		String[] suits = {"Diamonds","Clubs","Hearts","Spades"};
		String[] ranks = {"King","Queen","Jack","10","9", "8","7","6","5","4","3","2","Ace"};
		
		for(String s : suits) {
			for(String r : ranks) {
				CardModel card = new CardModel(s,r);
				this.deckOfCards[count] = card;
				count++;
			}
		}
	}
}
