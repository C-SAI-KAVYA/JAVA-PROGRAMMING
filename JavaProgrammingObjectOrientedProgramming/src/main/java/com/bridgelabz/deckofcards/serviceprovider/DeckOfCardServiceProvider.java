package com.bridgelabz.deckofcards.serviceprovider;

import com.bridgelabz.deckofcards.model.CardModel;

public interface DeckOfCardServiceProvider {
	
	public CardModel[] shuffleDeckOfCards(CardModel[] deckOfCards);
	public CardModel[] distributeCards(CardModel[] deckOfCards);
	public void showCards(CardModel[] deckOfCards);
	public void showPlayerCards(CardModel[] playerCards);
}
