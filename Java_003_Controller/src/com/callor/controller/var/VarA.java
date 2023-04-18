package com.callor.controller.var;

public class VarA {
	public static void main(String[] args) {
		int intKor = (int) (Math.random() * 51) + 50;
		int intEng = (int) (Math.random() * 51) + 50;
		int intMath = (int) (Math.random() * 51) + 50;
		int intTotal = intKor + intEng + intMath;
		// 소수점 이하 평균 오차를 찾기 위해
		// 정수를 실수(float)로 강제 형 변환하여 
		float floatAvg = ((float)intTotal / 3f);
		System.out.println("======================================");
		System.out.printf("국어 : %3d\n", intKor);
		System.out.printf("영어 : %3d\n", intEng);
		System.out.printf("수학 : %3d\n", intMath);
		System.out.println("--------------------------------------");
		System.out.printf("총점 : %3d,  평균 : %5.2f", intTotal, floatAvg);
	}
}
