package com.callor.score;

import com.callor.score.model.ScoreDto;
import com.callor.score.service.ScoreService;

public class ScoreList_rank {
	public static void main(String[] args) {
		ScoreDto[] stds = new ScoreDto[10]; // 학생 객체 배열 선언
		int[] rank = new int[stds.length];

		
		for (int i = 0; i < stds.length; i++) {
			stds[i] = new ScoreDto();		// 객체 초기화
		}
		ScoreService scoreService = new ScoreService(); // 점수계산 도와주는 ScoreService 클래스의 객체 생성
		for (int i = 0; i < stds.length; i++) {			
			String num = String.format("23%03d", (i + 1));	// stds[i] 학생의 학번
			scoreService.scoreSet(stds[i], num);		// stds 객체 배열의 학생 점수 세팅
		}
		for(int i = 0; i < rank.length;i++) {
			int rankCount = 0;
			for (int j = 0 ; j<rank.length;j++) {
				if(stds[i].getAvg() < stds[j].getAvg()) {
					rankCount++;
				}
			}
			rank[i] = rankCount+1;
		}

		
		
		System.out.println("=".repeat(80));
		System.out.println("* 한울 고교 성적 리스트 *");
		System.out.println("=".repeat(80));
		System.out.println("학번\t\t 국어\t 영어\t 수학\t 음악\t 미술\t 총점\t 평균\t 등수");
		System.out.println("-".repeat(80));
		for (int i = 0; i < stds.length; i++) {	// stds 배열의 학생 객체들의 정보 출력
			scoreService.scorePrint(stds[i]);
			System.out.printf("%4d\n", rank[i]);
		}
		System.out.println("-".repeat(80));
		
		scoreService.totalAvgPrint(stds);		// 전체점수와 전체 평균 출력
		System.out.println("=".repeat(80));
		
		

	}
}
