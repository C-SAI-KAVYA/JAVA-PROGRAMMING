package com.bridgelabz.deckofcards.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridgelabz.addressbook.utils.LogsUtility;
import com.bridgelabz.deckofcards.model.CardModel;
import com.bridgelabz.deckofcards.model.DeckOfCardsModel;
import com.bridgelabz.deckofcards.model.PlayerModel;
import com.bridgelabz.deckofcards.serviceprovider.DeckOfCardsServiceProviderImpl;

public class DeckOfCardsController {
	public static void main(String[] args) {
		LogsUtility.setLog("DeckOfCardsController");
		Logger logger = LogsUtility.getLog();
		System.setProperty("fname", LogsUtility.FILEPATH+"DeckOfCardsController.log");
		PropertyConfigurator.configure(LogsUtility.CONFIGPATH);
		
		logger.info("-------------------------------Deck Of Cards-----------------------------------------");
		
		DeckOfCardsServiceProviderImpl impl = new DeckOfCardsServiceProviderImpl();
		DeckOfCardsModel deck = new DeckOfCardsModel();
		PlayerModel player1 = new PlayerModel("Cherry");
		PlayerModel player2 = new PlayerModel("Pravika");
		PlayerModel player3 = new PlayerModel("Teddy");
		PlayerModel player4 = new PlayerModel("Dcruz");
		
		impl.showCards(deck.deckOfCards);
		
		CardModel[] shuffledCards1 = impl.shuffleDeckOfCards(deck.deckOfCards);
		player1.playCards = impl.distributeCards(shuffledCards1);
		
		CardModel[] shuffledCards2 = impl.shuffleDeckOfCards(deck.deckOfCards);
		player2.playCards = impl.distributeCards(shuffledCards2);
		
		CardModel[] shuffledCards3 = impl.shuffleDeckOfCards(deck.deckOfCards);
		player3.playCards = impl.distributeCards(shuffledCards3);
		
		CardModel[] shuffledCards4 = impl.shuffleDeckOfCards(deck.deckOfCards);
		player4.playCards = impl.distributeCards(shuffledCards4);
		
		logger.info("------------------------------------player1 cards-----------------------------------------");
		impl.showPlayerCards(player1.playCards);
		
		logger.info("------------------------------------player2 cards-----------------------------------------");
		impl.showPlayerCards(player2.playCards);
		
		logger.info("------------------------------------player3 cards-----------------------------------------");
		impl.showPlayerCards(player3.playCards);
		
		logger.info("------------------------------------player4 cards-----------------------------------------");
		impl.showPlayerCards(player4.playCards);
		
		logger.info("--------------------------------------Hope you enjoyed-----------------------------------------");
	}
	
}
