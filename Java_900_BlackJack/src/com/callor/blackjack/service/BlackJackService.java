package com.callor.blackjack.service;

import java.util.ArrayList;
import java.util.List;

import com.callor.blackjack.service.impl.DeckServiceImplV1;
import com.callor.blackjack.service.impl.PlayerServiceImplV1;

public class BlackJackService {
	protected final List<PlayerService> playerList;
	protected final DeckService deckService;
	
	public BlackJackService() {
		playerList = new ArrayList<>();
		deckService = new DeckServiceImplV1();
	}
	
	public void gameStart() {
		playerList.add(new PlayerServiceImplV1());
		playerList.add(new PlayerServiceImplV1("타짜"));
		playerList.add(new PlayerServiceImplV1("영수"));
		
		for(int i = 0; i < 2; i ++) {
			for (PlayerService player : playerList) {
				player.hit(deckService.getDeck());
			}
		}
		
		if (playerList.get(0).getScore() < 17) {
			playerList.get(0).hit(deckService.getDeck());
		}
		
		for (PlayerService player : playerList) {
			player.showDeck();
		}
		
		
		// player 가 다수일 경우 승부를 어떻게 계산할 것인가?
		
		
//		PlayerService winner = null;
//		
//		List<PlayerService> winners = null;
//		
//		for (PlayerService player : playerList) {
//			if (player.getScore() < 22 ) { 
//				winners = new ArrayList<>();
//				winner = player;
//				break;
//			}
//		}
//		
//		for (PlayerService player : playerList) {
//			if (player.getScore() < 22 ) { 
//				if (winner.getScore() < player.getScore()) {
//					winners = new ArrayList<>();
//					winner = player;
//					winners.add(player);
//				}
//				else if (winner.getScore() == player.getScore()) {
//					winners.add(player);
//				}
//				
//			}
//		}
//		for (PlayerService player : winners) {
//			System.out.printf("승자는 %s !!\n", player.getPlayerName());
//		}
		
		int maxScore = 0;
		String maxScorePlayer = "";
		for (PlayerService player: playerList) {
			int score = player.getScore();
			String playerName = player.getPlayerName();
			if ( score > maxScore) {
				maxScore = score;
				maxScorePlayer = playerName;
			}
		}
		System.out.printf("%s 승리, 점수 : %d", maxScorePlayer, maxScore);
		
		// 딜러(0 번 player) 와 각 게이머 간의 점수를 비교하여 
		// 딜러 : 타짜  = 타짜 승, 딜러 : 영수 = 영수 승
		// 단 각 player 의 점수가 21 점 초과하면 무조건 패
		// 동점이면 무승부
		
		String dealerName = playerList.get(0).getPlayerName();
		int dealerScore = playerList.get(0).getScore();
		for (int i = 1; i< playerList.size(); i++) {
			String playerName = playerList.get(i).getPlayerName();
			int playerScore = playerList.get(i).getScore();
			if (dealerScore > 22) {
				System.out.printf("%s : %s = %s 승"
						, dealerName,playerName,playerName);
			} else if (dealerScore > playerScore) {
				System.out.printf("%s : %s = %s 승"
						, dealerName,playerName,dealerName);
			} else if (dealerScore < playerScore) {
				System.out.printf("%s : %s = %s 승"
						, dealerName,playerName,playerName);
			} else if (dealerScore < playerScore) {
				System.out.printf("%s : %s = %s 승"
						, dealerName,playerName,playerName);
			}
			
			
		}
		
		
		
	}
	
	
}
