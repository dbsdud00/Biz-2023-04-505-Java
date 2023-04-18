package com.callor.controller;

public class ControllerE {
	public static void main(String[] args) {
		
		for (int i = 0;i<100;i++) {
			int intScore = (int) (Math.random() * 50) + 51;
//			if (intScore < 51 || intScore > 100) {
			if (intScore >= 51 && intScore <= 100) {
				System.out.println(intScore);
			} else {
				System.err.println(intScore);
				break;
			}
		}
		System.out.println("Test End");
		int num1 = 100;
		int num2 = 100;
		
		if(++num1 > 100  || ++num2 >100) { // or연산은 첫번째연산이 true이면 뒤쪽 연산은 보지 않고 true로 실행된다. 따라서 ++num2는 실행되지 않아서 값은 변경되지 않습니다.
			System.out.println("OK");
		}
		System.out.println(num2);
		
		
		if(--num1 > 100  && --num2  > 100) { // and 연산은 첫번째 연산이 false이면 뒤쪽 연산은 보지 않고 false로 실행된다. 따라서 --num2는 실행되지 않아 num2의 값은 변하지 않는다.
			System.out.println("Hello");
		}
		System.out.println(num2);
			
	}
}
