package com.callor.controller;

public class ControllerD {
	public static void main(String[] args) {
		/*
		 * 51 ~ 100 까지 범위의 랜덤 수 100 개 생성
		 * 생성된 랜덤 수 중에 짝수가 몇개인가 판별
		 */
		int count = 0; // 짝수의 개수
		int nSum = 0; // 짝수의 합계
		int nAvg = 0; // 짝수의 평균
		for (int i = 0; i<100; i++) {
			int intRnd = (int)(Math.random()*50)+51;
			if (intRnd %2 == 0) {
				count ++;
				nSum += intRnd; // 짝수를 누적 (숫자값을 계속 쌓아서 덧셈)
				System.out.println(count + ".\t" + intRnd);
			}
		}
		nAvg = nSum/count;
		System.out.printf("\n짝수의 개수 : %d개", count);
		System.out.printf("\n짝수의 합계 : %d", nSum);
		System.out.printf("\n짝수의 평균 : %d", nAvg);
		
	}
}
