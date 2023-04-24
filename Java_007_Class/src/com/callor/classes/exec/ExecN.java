package com.callor.classes.exec;

import com.callor.classes.exec.module.ServiceE;

public class ExecN {
	public static void main(String[] args) {
		// 51~100사이의 랜덤한 점수를 각 과목변수에 저장
		int intKor = (int)(Math.random()*50)+51;
		int intEng = (int)(Math.random()*50)+51;
		int intMath = (int)(Math.random()*50)+51;
		
		// ServiceE클래스의 se객체를 생성 후 생성자로 초기화
		ServiceE se = new ServiceE();
		// se 객체를 통해 ServiceE 클래스의 score method 호출 후 51~100 사이의 점수가 들어있는 변수를 인자로 전달
		se.score(intKor, intEng, intMath);
		
	}
}
