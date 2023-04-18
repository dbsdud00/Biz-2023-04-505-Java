package com.callor.controller;

public class ControllerA {
	public static void main(String[] args) {
		int index = 0;
		/*
		 * 1. index < 10 비교문이 실행결과가 true 이면
		 * 2. {} 코드 실행
		 * 3. index ++하여 index 변수값을 1 증가
		 * 4. 1~3 을 계속 반복
		 * 
		 * 1. index < 10 비교문 결과가 false 가 되면 
		 * 2. 반복문 종료
		 */
		for( ; index <10 ; index++) {
			// 현재 이 코드는 index 가 0~9 까지 변화되는 동안 실행
			// 총 10회 실행된다.
		}
		
	}
}
