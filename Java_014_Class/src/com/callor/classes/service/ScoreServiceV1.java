package com.callor.classes.service;

import java.util.List;

import com.callor.classes.models.ScoreDto;

public class ScoreServiceV1 {
	
	// 학생 수를 10 으로 설정하기 위한 변수 선언
	private int classSize = 10;
	
	
	/*
	 *  매개변수로 일반 변수가 아닌 참조형 객체 변수를 사용했다
	 *  참조형 객체 변수는 실제 저장된 값이 전달되는 것이 아니고
	 *  기억장소의 주소가 전달된다.
	 *  
	 *  main() method 에서 보낼 때 scoreList의 주소가 전달되고
	 *  makeScore() 에서 값을 변경시키면 main() method 의 scoreList 가 
	 *  같이 변경되는 성질을 갖게 된다.
	 */
	public void makeScore(List<ScoreDto> scoreList) {
		for (int i = 0; i< classSize; i++) {
			// 001, 002 형식으로 학번 문자열 만들기
			String stNum = String.format("%03d", i+1);
			
			int scKor = (int)(Math.random()*50)+51;
			int scMath = (int)(Math.random()*50)+51;
			int scMusic = (int)(Math.random()*50)+51;
			int scArt= (int)(Math.random()*50)+51;

			/*
			 *  배열에서는
			 *   1. 배열선언
			 *   2. 배열초기화
			 *   3. 각 요소에 데이터 저장
			 *  
			 *  List type 의 데이터
			 *   1. 먼저 비어있는(blank) List type 을 생성
			 *   2. Dto 객체 변수를 생성하고
			 *   3. Dto 각 변수에 값을 setting(setter)
			 *   4. List 에 Dto를 add
			 */
			ScoreDto scoreDto = new ScoreDto();
			scoreDto.setStNum(stNum);
			scoreDto.setScArt(scArt);
			scoreDto.setScKor(scKor);
			scoreDto.setScMath(scMath);
			scoreDto.setScMusic(scMusic);
			
			scoreList.add(scoreDto);
			
		}
	} // makeScore() end
	
	
	public void printScore(List<ScoreDto> scList) {
		
		System.out.println("=".repeat(50));
		System.out.println("학번\t국어\t수학\t음악\t미술\t총점");
		System.out.println("-".repeat(50));
		for (int i = 0; i< scList.size();i++) {
			ScoreDto scoreDto = scList.get(i);
//			scoreDto = scList.get(i);
			System.out.printf("%s\t",scoreDto.getStNum());
			System.out.printf("%3d\t",scoreDto.getScKor());
			System.out.printf("%3d\t",scoreDto.getScMath());
			System.out.printf("%3d\t",scoreDto.getScMusic());
			System.out.printf("%3d\t",scoreDto.getScArt());
			System.out.printf("%3d\n",scoreDto.getTotal());
			
		}
		System.out.println("-".repeat(50));
	}
	
	// scList 데이터를 총점을 기준으로 오름치순 정렬하기
	public void sortScore(List<ScoreDto> scList) {
		
		for (int i = 0 ; i< scList.size() ; i++) {
			for (int j = i; j < scList.size(); j++) {
				if ( scList.get(i).getTotal() > scList.get(j).getTotal()) {
					ScoreDto stTmp = scList.get(i);
					scList.set(i, scList.get(j));
					scList.set(j, stTmp);
				}
			}
		}
	}
	
	public void add(int num1, int num2) {
		num1 = 1000;
		num2 = 2000;
	}
	
} 
