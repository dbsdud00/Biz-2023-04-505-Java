package com.callor.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.config.Line;
import com.callor.classes.datas.DataIndex;
import com.callor.classes.datas.DataSource;
import com.callor.classes.models.ScoreDto;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.ScoreService;
import com.callor.classes.service.StudentService;

/*
 *  interface (class) 를 implements 한 클래스는 
 *  interface 에 선언된 모든 method를 의무적으로 구현해야 한다.
 *  interface 에 선언된 method를 한 개라도 생략하면 
 *  	클래스 코드는 문법오류가 발생하고 실행 불가 상태가 된다.
 */
public class ScoreServiceImplV1 implements ScoreService {
	
	// private List<ScoreDto> scList = new ArrayList<>();
	
	protected List<ScoreDto> scList;

	// 변수의 초기화 , 객체의 초기화, 변수의 생성, 변수의 초기화
	// 변수, 객체를 사용가능한 상태로 만드는 것
	public ScoreServiceImplV1() {
		scList = new ArrayList<>();
	}
	// 성적 정보 문자열 1개를 컴마(,)로 분해하고
	// ScoreDto 객체로 변환하여  return 하는 method
	protected ScoreDto str2Dto(String str) {
		String[] score = str.split(",");
		// ScoreDto 클래스는 field 생성자가 있다.
		// field 생성자를 통하여 데이터가 포함된 scDto 객체를 생성
		ScoreDto scDto = new ScoreDto(
				score[DataIndex.SCORE.ST_NUM], 
				Integer.valueOf(score[DataIndex.SCORE.ST_KOR]),
				Integer.valueOf(score[DataIndex.SCORE.ST_ENG]), 
				Integer.valueOf(score[DataIndex.SCORE.ST_MATH]),
				Integer.valueOf(score[DataIndex.SCORE.ST_MUSIC]), 
				Integer.valueOf(score[DataIndex.SCORE.ST_ART]),
				Integer.valueOf(score[DataIndex.SCORE.ST_SOFTWARE]), 
				Integer.valueOf(score[DataIndex.SCORE.ST_DATABASE])
		);
		return scDto;
	}

	// scData.SCORE 배열을 loading 하여 scList 데이터로 변환하기
	@Override
	public void loadScore() {
		// TODO Auto-generated method stub
		// DataSource.SCORE 문자열 배열의 값을 
		// List<ScoreDto> type 의 리스트 데이터로 변환하기
		for (String str : DataSource.SCORE) {
//			String[] score = str.split(",");
//			// ScoreDto 클래스는 field 생성자가 있다.
//			// field 생성자를 통하여 데이터가 포함된 scDto 객체를 생성
//			scDto = new ScoreDto(
//					score[DataIndex.SCORE.ST_NUM], 
//					Integer.valueOf(score[DataIndex.SCORE.ST_KOR]),
//					Integer.valueOf(score[DataIndex.SCORE.ST_ENG]), 
//					Integer.valueOf(score[DataIndex.SCORE.ST_MATH]),
//					Integer.valueOf(score[DataIndex.SCORE.ST_MUSIC]), 
//					Integer.valueOf(score[DataIndex.SCORE.ST_ART]),
//					Integer.valueOf(score[DataIndex.SCORE.ST_SOFTWARE]), 
//					Integer.valueOf(score[DataIndex.SCORE.ST_DATABASE])
//			);
			scList.add(str2Dto(str));
		}
	}


	@Override
	public void printScore() {
		// TODO Auto-generated method stub
		StudentService stV1 = new StudentServiceImplV1();
//		stV1.loadStudent();
		
		System.out.println(Line.dLine(70));
		System.out.println("학번\t이름\t학과\t\t국어\t영어\t수학\t음악\t미술");
		System.out.println(Line.sLine(70));
		for(ScoreDto dto : scList) {
			
			// 학번을 StudentServiceImplV1.getStudent() method 에게 전달하고
			// 학번에 해당하는 학생 데이터를 return 받아서
			// StudentDto type의 객체에 저장하기
			StudentDto stDto = stV1.getStudent(dto.getStNum());
			
			System.out.printf("%s\t",dto.getStNum());
			
			if (stDto != null) {
				System.out.printf("%3s\t", stDto.stName);
				System.out.printf("%s\t", stDto.stDept);
				
			} else {
				System.out.printf(" -\t");
				System.out.printf(" -\t\t");				
			}
			
			System.out.printf("%3d\t",dto.getScKor());
			System.out.printf("%3d\t",dto.getScEng());
			System.out.printf("%3d\t",dto.getScMath());
			System.out.printf("%3d\t",dto.getScMusic());
			System.out.printf("%3d\t",dto.getScArt());
			System.out.println();
		}
		System.out.println(Line.dLine(70));
	}
}
