package com.callor.classes.service;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.ScoreDto;

public class ScoreServiceV2 {
	
	// scList 변수를 ScoreServiceV2 클래스의 
	// 다른 method 에서 사용하기 위하여
	// 클래스 영역으로 scope를 이동한다.
	// 클래스 영역으로 scope 가 이동된 객체변수는
	// 선언만 수행한다.
	// 선언만 수행된 객체변수는 사용하려고 하면 NullpointerException이
	// 발생할 수 있다.
	// makeScore() method가 시작되는 곳에서 scoreList 를 
	// 초기화 (생성) 해 주어야 한다.
	private List<ScoreDto> scList;
	
//	public void makeScore(List<ScoreDto> scList) {
//		this.scList = new ArrayList<>();
//		ScoreDto stDto;
//		for (int i = 0; i < 10; i++) {
//			stDto = new ScoreDto();
//			String stNum = String.format("%04d", i+1);
//			stDto.setStNum(stNum);
//			stDto.setScKor((int)(Math.random()*50)+51);
//			stDto.setScEng((int)(Math.random()*50)+51);
//			stDto.setScMath((int)(Math.random()*50)+51);
//
//			scList.add(stDto);
//		}
//		
//		System.out.println(scList);
//		
//		scList = this.scList;
//	}
	
	public void makeScore(List<ScoreDto> scList) {
		
		scList = new ArrayList<>();
		ScoreDto stDto;
		for (int i = 0; i < 10; i++) {
			String stNum = String.format("%04d", i+1);
			int scKor = (int)(Math.random()*50)+51;
			int scEng = (int)(Math.random()*50)+51;
			int scMath =(int)(Math.random()*50)+51;
	
			stDto = new ScoreDto(stNum, scKor, scEng, scMath);
			scList.add(stDto);
		}
		
		System.out.println(scList);

	}
	

	public void makeScore() {
		
		// scoreList 변수의 scope 가 makeScore() { } 블럭이다.
		// 만약 다른 method (예, printScore() ) 에서
		// scoreList 변수값을 사용하려면
		// scope 영역을 변경해 주어야 한다.
		scList = new ArrayList<>();	// 객체변수 초기화
		this.makeScore(scList);
		
		/*
		ScoreDto stDto;
		for (int i = 0; i < 10; i++) {
			String stNum = String.format("%04d", i+1);
			int scKor = (int)(Math.random()*50)+51;
			int scEng = (int)(Math.random()*50)+51;
			int scMath =(int)(Math.random()*50)+51;
	
			stDto = new ScoreDto(stNum, scKor, scEng, scMath);
			scList.add(stDto);
		}
		
		System.out.println(scList);
	*/
	}
	
}
