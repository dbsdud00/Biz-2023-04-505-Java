package com.callor.model;

import java.util.ArrayList;
import java.util.List;

public class CardSet {
	
	private List<String[]> wholeCard = new ArrayList<>();
	
	private String heartCard[] = new String[13];
	private String diaCard[] = new String[13];
	private String cloverCard[] = new String[13];
	private String spadeCard[] = new String[13];
	

	
	public void drawCard() {
		
		int rndType = (int)(Math.random()*4);
		int rndNum = (int)(Math.random()*wholeCard.get(rndType).length);
		
		String selectCard = wholeCard.get(rndType)[rndNum];
		
		for (int i = 0; i< wholeCard.get(rndType).length;i++) {
			if ()
		}
		
		
	}
	
	
}
