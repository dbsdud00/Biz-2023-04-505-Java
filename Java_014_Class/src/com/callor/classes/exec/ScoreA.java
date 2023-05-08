package com.callor.classes.exec;

import com.callor.classes.models.ScoreDto;

public class ScoreA {
	public static void main(String[] args) {
		ScoreDto scoreDto = new ScoreDto();
		scoreDto.setStNum("0001");
		scoreDto.setScKor(80);
		scoreDto.setScArt(88);
		scoreDto.setScMath(89);
		scoreDto.setScMusic(90);
		
		System.out.println(scoreDto.toString());
		
	}
}
