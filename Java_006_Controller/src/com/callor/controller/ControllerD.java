package com.callor.controller;

public class ControllerD {
	public static int prime() {

		int rndNum = (int) (Math.random() * 50) + 51;
		for (int i = 2; i < rndNum; i++) {
			if (rndNum % i == 0) {
				return 0;
			}
		}
		return rndNum;
	}

	public static void main(String[] args) {
		int nCount = 0;
		int nSum = 0;
		for (int i = 0; i < 100; i++) {
			int rndNum = prime();

			if (rndNum > 0) {
				nCount++;
				nSum += rndNum;
				System.out.println(rndNum + "는 소수");
			}

		} // end for
		System.out.println("소수의 개수는 " + nCount + "이고, 소수의 합은 " + nSum + "이다.");
	}
}
