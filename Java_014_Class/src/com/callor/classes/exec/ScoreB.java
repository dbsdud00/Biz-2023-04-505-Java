package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.ScoreDto;
import com.callor.classes.service.ScoreServiceV1;

/*
 *  일반적인 변수(primitive) 는 method의 매개 변수로 전달할 때 
 *  변수 자체가 전달되는 것이 아니고 변수의 "값(데이터)" 만 전달된다
 *  
 *  매개변수로 전달받은 method 에서 아무리 변수의 값을 변경해도
 *  실제 값은 변경되지 않는다.
 */

public class ScoreB {
	public static void main(String[] args) {
		// ScoreDto type의 데이터 요소를 저장할 scoreList 리스트 객체 생성
		List<ScoreDto> scList = new ArrayList<>();
		
		ScoreServiceV1 scService = new ScoreServiceV1();
		
		scService.makeScore(scList);
//		System.out.println(scoreList.toString());
		scService.sortScore(scList);
		scService.printScore(scList);
		
		
		int num1 = 100;
		int num2 = 200;
		// scService의 add() 에게 변수값 전달하기
		// num1, num2 에 저장된 값이 전달된다. 변수가 전달되는 것이 아니다.
		scService.add(num1, num2);
		System.out.println(num1);
		System.out.println(num2);
		
		/*
		 *  고기 'K바베큐' '로티세리'
		 *  햄 '클럽' '치킨 데리야끼'
		 *  
		 *  소스 바베큐 렌치
		 *  
		 */
		
	}
	
	
	
	
	
} 
