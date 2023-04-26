package com.callor.classes.arrays;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.service.ScoreServiceA;

public class ArrayB {
	
	
	public static void main(String[] args) {
		// ScoreServiceA 클래스에 선언된 method 를 사용하기 위해
		// 객체변수 생성
		ScoreServiceA scoreService = new ScoreServiceA();
		
		// 3명 학생의 성적 정보를 저장할 객체변수 생성
		ScoreDto 홍길동 = new ScoreDto();
		ScoreDto 이몽룡 = new ScoreDto();
		ScoreDto 성춘향 = new ScoreDto();
		
		// 홍길동 학생의 학번, 이름, 과목점수 세팅

		scoreService.scoreSet(홍길동, "홍길동","0001");
		scoreService.scoreSet(이몽룡, "이몽룡","0002");
		scoreService.scoreSet(성춘향, "성춘향","0003");
		
		
		System.out.println("=".repeat(60));
		
		// 성적표 title 출력
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------------------");
		// 각 학생의 성적정보 출력
		scoreService.scorePrint(홍길동);
		scoreService.scorePrint(이몽룡);
		scoreService.scorePrint(성춘향);
		
		System.out.println("=".repeat(60));
		
		
		
	}
}
