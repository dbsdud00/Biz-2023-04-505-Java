package com.callor.classes.exec.module;

public class ServiceE {
	public void score(int intKor, int intEng, int intMath) {
		System.out.println("국어 점수\t: " + intKor);
		System.out.println("영어 점수\t: " + intEng);
		System.out.println("수학 점수\t: " + intMath);
		System.out.println("총점\t\t: " + (intKor+ intEng+ intMath));
		System.out.printf("평균\t\t: %2.1f",(float)(intKor+ intEng+ intMath)/3);
	}
}
