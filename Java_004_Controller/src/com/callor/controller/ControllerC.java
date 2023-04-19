package com.callor.controller;

public class ControllerC {
	public static void main(String[] args) {
		/*
		 * 100개의 랜덤 수를 생성하기
		 * 생성된 랜덤수가 3의 배수인가 판별
		 * 아니면 2의 배수인가 판별
		 */
		for (int i = 0; i < 100; i++) {
			int intRnd = (int) (Math.random() * 50) + 51;
			if (intRnd % 3 == 0) {
				System.out.println(intRnd + "는 3의 배수이다.");
			} else if (intRnd % 2 == 0) {
				System.err.println(intRnd + "는 2의 배수이다.");
			}

		}
	}
}
