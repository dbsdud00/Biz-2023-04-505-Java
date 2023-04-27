package com.callor.classes.arrays;

import com.callor.classes.model.ScoreDto;
import com.callor.classes.service.ScoreServiceA;

public class HomeWorkA {
	public static void main(String[] args) {
		// 한 학생의 점수를 관리하기 위한 객체 변수 생성
		// 생성 = 선언 + 초기화 = 사용할 준비가 된 상태
		// ScoreDto 클래스를 사용하여 score 객체(변수)를 선언
		// ScoreDto() 생성자 method를사용하여
		// 객체를 초기화(new)한다.
//		ScoreDto score = new ScoreDto();
		
		
		// ScoreDto type의 scores 배열을 선언하고
		// 요소를 10개 선언한다.
		ScoreDto[] scores = new ScoreDto[10];
		
		// class type으로 선언된 배열은 반드시 개별요소를 초기화 시키는 절차가 필요하다.
		
		// scores 배열 (요소) 개수만큼 for() 반복문을 이용하여
		// scores 배열의 개별 요소들을 모두 초기화 한다.
		// scores 배열의 모든 요소들이 초기화 되어
		// 사용할 준비가 완료된다.
		for (int index = 0; index<scores.length;index++) {
			scores[index] = new ScoreDto();
		}
		
		// 학번, 이름, 과목점수를 각 배열의 요소에 세팅
		// ScoreServiceA 클래스에 정의된
		// 점수 생성 method, 개별 성적 출력 method를 활용하기 위하여 
		// 객체(변수)로 생성하기
		ScoreServiceA scServiceA = new ScoreServiceA();
		
		scores[0].stNum = "0001";
		scores[0].stName = "홍길동";
		for(int index = 0; index < scores.length; index ++ ) {
			scores[index].scKor = scServiceA.getScore();
			scores[index].scEng = scServiceA.getScore();
			scores[index].scMath = scServiceA.getScore();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
