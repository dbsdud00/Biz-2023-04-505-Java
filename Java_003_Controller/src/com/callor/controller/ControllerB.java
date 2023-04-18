package com.callor.controller;

public class ControllerB {
	public static void main(String[] args) {
		
		/*
		 * int index = 0
		 * for() 반복문에서 사용할 변수 선언.
		 * for() 반복문이 시작될때 최초에 한번 실행.
		 * 실행횟수에 관계 없이 1번만 실행.
		 */
		int sum = 0;
		for (int i = 0; i < 10 ; i++) {
			
			System.out.print(i+1+"\t"); // \t는 tap키와 같음
			// 누적 연산
			// 한 변수에 다른 변수의 변화되는 값을 계속 덧셈하여 쌓는 연산
			sum += i+1;
		}
		System.out.println();
		System.out.println(sum);
		
	}
}
