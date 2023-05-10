package com.callor.Rule;

import java.util.ArrayList;
import java.util.List;

import com.callor.model.CardDto;

public class GameSet {
	
	private List<List<String>> wholeCard = new ArrayList<>();
		
	CardDto heartCard = new CardDto();
	CardDto diaCard = new CardDto();
	CardDto cloverCard = new CardDto();
	CardDto spadeCard = new CardDto();

	public void gameSet() {
		wholeCard.add(heartCard.newCard("Heart"));
		wholeCard.add(diaCard.newCard("DiaCard"));
		wholeCard.add(cloverCard.newCard("Clover"));
		wholeCard.add(spadeCard.newCard("Spade"));		
	}
	
	public String drawCard() {
		
		int rndType = (int)(Math.random()*4);
		int rndNum = (int)(Math.random()*wholeCard.get(rndType).size());
		
		String selectCard = wholeCard.get(rndType).get(rndNum);
		
		wholeCard.get(rndType).remove(rndNum);
		
		return selectCard;
		
	}
	
	
}
