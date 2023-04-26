package com.callor.classes.arrays;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.service.ScoreServiceA;

public class HomeWork {
	public static void main(String[] args) {
		ScoreDto[] scores = new ScoreDto[10];
		
		for (int index = 0; index<scores.length;index++) {
			scores[index] = new ScoreDto();
		}
		ScoreServiceA scoreServiceA = new ScoreServiceA();
		
		scoreServiceA.scoreSet(scores[0], "홍길동", "0001");
		scoreServiceA.scoreSet(scores[1], "이몽룡", "0002");
		scoreServiceA.scoreSet(scores[2], "성춘향", "0003");
		scoreServiceA.scoreSet(scores[3], "장보고", "0004");
		scoreServiceA.scoreSet(scores[4], "임꺽정", "0005");
		scoreServiceA.scoreSet(scores[5], "김철수", "0006");
		scoreServiceA.scoreSet(scores[6], "김희경", "0007");
		scoreServiceA.scoreSet(scores[7], "이기동", "0008");
		scoreServiceA.scoreSet(scores[8], "박철수", "0009");
		scoreServiceA.scoreSet(scores[9], "한동후", "0010");
		
		System.out.println("=".repeat(60));
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-".repeat(60));
		for (int i = 0;i<scores.length;i++) {
			scoreServiceA.scorePrint(scores[i]);
		}
		System.out.println("-".repeat(60));
		int korTotal = 0;
		int engTotal = 0;
		int mathTotal = 0;
		for(int i = 0; i< scores.length;i++) {
			korTotal += scores[i].scKor;
			engTotal += scores[i].scEng;
			mathTotal += scores[i].scMath;
		}
		scoreServiceA.scoreTotalPrint(korTotal, engTotal, mathTotal);
		
	}
}
