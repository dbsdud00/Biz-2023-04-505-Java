package com.callor.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.ScData;
import com.callor.classes.models.ScoreDto;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.ScoreService;

/*
 *  interface (class) 를 implements 한 클래스는 
 *  interface 에 선언된 모든 method를 의무적으로 구현해야 한다.
 *  interface 에 선언된 method를 한 개라도 생략하면 
 *  	클래스 코드는 문법오류가 발생하고 실행 불가 상태가 된다.
 */
public class ScoreServiceImplV3 implements ScoreService {
	List<ScoreDto> scList;

	public ScoreServiceImplV3() {
		scList = new ArrayList<>();
	}

	// scData.SCORE 배열을 loading 하여 scList 데이터로 변환하기
	@Override
	public void makeScore() {
		// TODO Auto-generated method stub
		ScoreDto scDto;
		for (String str : ScData.SCORE) {
			String[] score = str.split(",");
			scDto = new ScoreDto(
					score[ScData.ST_NUM], 
					Integer.valueOf(score[ScData.ST_KOR]),
					Integer.valueOf(score[ScData.ST_ENG]), 
					Integer.valueOf(score[ScData.ST_MATH]),
					Integer.valueOf(score[ScData.ST_MUSIC]), 
					Integer.valueOf(score[ScData.ST_ART]),
					Integer.valueOf(score[ScData.ST_SOFTWARE]), 
					Integer.valueOf(score[ScData.ST_DATABASE])
			);
			scList.add(scDto);
		}

	}

	@Override
	public void makeScore(List<ScoreDto> scList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void printScore() {
		// TODO Auto-generated method stub
		StudentServiceImplV1 stV1 = new StudentServiceImplV1();
		stV1.loadStudent();
		System.out.println("=".repeat(70));
		System.out.println("학번\t이름\t학과\t\t국어\t영어\t수학\t음악\t미술");
		System.out.println("-".repeat(70));
		for(ScoreDto dto : scList) {
			
			StudentDto namedto = stV1.getStudent(dto.getStNum());
			
			
			System.out.printf("%s\t",dto.getStNum());
			System.out.printf("%s\t", namedto.stName);
			System.out.printf("%s\t", namedto.stDept);
			System.out.printf("%3d\t",dto.getScKor());
			System.out.printf("%3d\t",dto.getScEng());
			System.out.printf("%3d\t",dto.getScMath());
			System.out.printf("%3d\t",dto.getScMusic());
			System.out.printf("%3d\t",dto.getScArt());
			System.out.println();
			
		}
		System.out.println("=".repeat(70));
	}

	@Override
	public void printScore(List<ScoreDto> scList) {
		// TODO Auto-generated method stub

	}

}
