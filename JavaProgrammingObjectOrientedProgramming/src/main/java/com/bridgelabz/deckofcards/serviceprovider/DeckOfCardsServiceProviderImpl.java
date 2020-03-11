package com.bridgelabz.deckofcards.serviceprovider;

import java.util.Arrays;
import java.util.Random;

import org.apache.log4j.Logger;

import com.bridgelabz.deckofcards.model.CardModel;
import com.bridgelabz.deckofcards.model.DeckOfCardsModel;
import com.bridgelabz.deckofcards.utils.OutputUtility;

public class DeckOfCardsServiceProviderImpl implements DeckOfCardServiceProvider{
	Logger logger = Logger.getLogger(DeckOfCardsServiceProviderImpl.class);
	DeckOfCardsModel deck = new DeckOfCardsModel();
	
	@Override
	public CardModel[] shuffleDeckOfCards(CardModel[] deckOfCards) {
		Random random = new Random();
		int flip1; 
		int flip2;
		CardModel temp;
		for(int i=0;i<52;i++) {
			flip1 = random.nextInt(51);
			flip2 = random.nextInt(51);
			if(flip1 != flip2) {
				temp = deckOfCards[flip1];
				deckOfCards[flip1] = deckOfCards[flip2];
				deckOfCards[flip2] = temp;
			}
		}
		return deckOfCards;
	}

	@Override
	public void showCards(CardModel[] deckOfCards) {
		logger.info("---------------Showing Cards--------------------");
		int count = 0;
		for(CardModel card : deckOfCards ) {
			OutputUtility.print(card.rank + "  of  " + card.suit + "  ");
			count++;
			if(count%4 == 0)
				OutputUtility.println("");
		}
	}

	@Override
	public CardModel[] distributeCards(CardModel[] shuffledDeckOfCards) {
		CardModel[] playerCards = new CardModel[9];
			playerCards = Arrays.copyOf(shuffledDeckOfCards, 9);
		return playerCards;
	}

	@Override
	public void showPlayerCards(CardModel[] playerCards) {
		for(CardModel card : playerCards) {
			if(card != null)
				logger.info(card.rank + "  of  " + card.suit);
		}
		OutputUtility.println();
	}
}
