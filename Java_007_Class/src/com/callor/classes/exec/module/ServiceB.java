package com.callor.classes.exec.module;

public class ServiceB {
	public void scorePrint(String name, int num1, int num2, int num3) {
		int sum = 0;
		float avr = 0;

		sum = num1 + num2 + num3;
		avr = (float) sum / 3f;

		System.out.println("======================================");
		System.out.println("이름\t국어 영어 수학  총점  평균");
		System.out.println("--------------------------------------");
		System.out.printf("%s\t %d   %d   %d   %d   %.1f\n", name, num1, num2, num3, sum, avr);
		System.out.println("======================================");
	}
}
