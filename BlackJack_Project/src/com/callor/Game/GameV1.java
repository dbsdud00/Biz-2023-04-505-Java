package com.callor.Game;

import com.callor.Rule.GameSet;

public class GameV1 {
	public static void main(String[] args) {
		GameSet test = new GameSet();
		test.gameSet();
		System.out.println(test.drawCard());
	}
}
