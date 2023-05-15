package com.callor.exam;

public class ExamA {
	public static void main(String[] args) {
		// 랜덤수를 생성하고, 생성한 랜덤수가 범위에 맞는지 100번 테스트 수행
		int index = 0;
		for (index = 0; index< 100; index++) {
			int rndNum = (int)(Math.random() * 180) +1;
			if (rndNum < 1 || rndNum > 100) {
				break;
			}	
//			System.out.println(rndNum +" 값은 범위에 포함된다");
		}
		// 테스트를 수행한 결과가 어떤지 표현
		if(index >= 100) {
			System.out.println("100번 테스트를 수행하고 모두 통화함");
		} else {
			System.out.println("데스트 횟수 : " + (index+1));
			System.out.println("100번 수행혈과 "+ (index+1)+"번째 에서 실패");
		}
	}
}
