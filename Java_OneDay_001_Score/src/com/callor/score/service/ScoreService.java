package com.callor.score.service;

import com.callor.score.model.ScoreDto;

public class ScoreService {
	
	public void scoreSet(ScoreDto std, String num) { // 학생 정보 세팅
		std.stnum = num;
		std.scKor = (int)(Math.random()*50) + 51;
		std.scEng = (int)(Math.random()*50) + 51;
		std.scMath = (int)(Math.random()*50) + 51;
		std.scMusic = (int)(Math.random()*50) + 51;
		std.scArt = (int)(Math.random()*50) + 51;
	}
	
	public void scorePrint(ScoreDto std) { // 학생 정보 출력
		System.out.printf("%s\t\t",std.stnum);
		System.out.printf("%5d\t",std.scKor);
		System.out.printf("%5d\t",std.scEng);
		System.out.printf("%5d\t",std.scMath);
		System.out.printf("%5d\t",std.scMusic);
		System.out.printf("%5d\t",std.scArt);
		System.out.printf("%5d\t",std.getTotal());
		System.out.printf("%5.2f\t",std.getAvg());
	}
	

	
	public void totalAvgPrint(ScoreDto[] stds) { // 전체 점수와 전체 평균을 출력
		int num = stds.length;
		int totalKor = 0;
		int totalEng = 0;
		int totalMath = 0;
		int totalMusic = 0;
		int totalArt = 0;
		int totalScore = 0;
		for (int i = 0; i < num ; i++) {
			totalKor += stds[i].scKor;
			totalEng += stds[i].scEng;
			totalMath += stds[i].scMath;
			totalMusic += stds[i].scMusic;
			totalArt += stds[i].scArt;
		}
		totalScore = totalKor + totalEng + totalMath + totalMusic + totalArt;
		System.out.printf("총점\t\t");
		System.out.printf("%5d\t",totalKor);
		System.out.printf("%5d\t",totalEng);
		System.out.printf("%5d\t",totalMath);
		System.out.printf("%5d\t",totalMusic);
		System.out.printf("%5d\t",totalArt);
		System.out.printf("%5d\n",totalScore);
		
		System.out.printf("평균\t\t");
		System.out.printf("%5.2f\t",(float)totalKor/num);
		System.out.printf("%5.2f\t",(float)totalEng/num);
		System.out.printf("%5.2f\t",(float)totalMath/num);
		System.out.printf("%5.2f\t",(float)totalMusic/num);
		System.out.printf("%5.2f\t\t",(float)totalArt/num); // 학생 10명의 5과목의 점수를 모두 더한 전체 점수
		System.out.printf("%5.2f\n",(float)totalScore/(num*5));  // 전체점수를 50으로 나눔
	}
	
}
