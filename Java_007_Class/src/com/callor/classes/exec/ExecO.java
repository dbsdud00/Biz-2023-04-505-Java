package com.callor.classes.exec;

import com.callor.classes.exec.module.ServiceF;

public class ExecO {
	public static void main(String[] args) {
		// 51~100사이의 랜덤한 점수를 각 과목변수에 저장
		int intKor = (int)(Math.random()*50)+51;
		int intEng = (int)(Math.random()*50)+51;
		int intMath = (int)(Math.random()*50)+51;
		int intHis = (int)(Math.random()*50)+51;
		int intMusic = (int)(Math.random()*50)+51;
		int intart = (int)(Math.random()*50)+51;
		int intphy = (int)(Math.random()*50)+51;
		
		// ServiceE클래스의 sf객체를 생성 후 생성자로 초기화
		ServiceF sf = new ServiceF();
		// sf 객체를 통해 ServiceE 클래스의 score method 호출 후 51~100 사이의 점수가 들어있는 변수를 인자로 전달
		sf.score(intKor, intEng, intMath,intHis,intMusic,intart,intphy);
	}
}
