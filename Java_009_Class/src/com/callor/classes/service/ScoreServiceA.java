package com.callor.classes.service;

import com.callor.classes.model.ScoreDto;

public class ScoreServiceA {
	// ScoreDto type의 매개변수를 통하여 성적정보 데이터를 받아서 출력하기
	public void scorePrint(ScoreDto score) {
//		System.out.printf("%s\t%s\t%3d\t%3d\t%3d\t%3d\t%5.1f\n",score.stNum,score.stName,score.scKor,score.scEng,score.scMath,score.getTotal(),score.getAvg());
		
		System.out.printf("%s\t" , score.stNum);
		System.out.printf("%s\t" , score.stName);
		System.out.printf("%3d\t" , score.scKor);
		System.out.printf("%3d\t" , score.scEng);
		System.out.printf("%3d\t" , score.scMath);
		System.out.printf("%3d\t" , score.getTotal());
		System.out.printf("%5.1f\n" , score.getAvg());
	}
	//
	public int getScore() {
		int score = (int)(Math.random() * 50) + 51;
		return score;
	}
	public void scoreSet(ScoreDto score, String name, String num) {
		score.stName = name;
		score.stNum = num;
		score.scKor = getScore();
		score.scEng = getScore();
		score.scMath = getScore();
	}
	public void scoreTotalPrint(int kor, int eng, int math) {
//		System.out.printf("%s\t%s\t%3d\t%3d\t%3d\t%3d\t%5.1f\n",score.stNum,score.stName,score.scKor,score.scEng,score.scMath,score.getTotal(),score.getAvg());
		
		System.out.printf("\t" );
		System.out.printf("\t" );
		System.out.printf("%3d\t" , kor);
		System.out.printf("%3d\t" , eng);
		System.out.printf("%3d\t" , math);
		System.out.printf("%3d\n" , kor + eng + math);
	}
	
}
