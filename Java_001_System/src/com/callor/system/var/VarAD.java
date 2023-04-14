package com.callor.system.var;

public class VarAD {
	public static void main(String[] args) {
		/*
		 * 정수형 (int type) 변수 num1, num2, num3 를 선언하고 
		 * 각각 0으로 초기화 하였다.
		 */
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		
		/*
		 * 선언된 변수 num1, num2, num3 에 
		 * 각각 정수 30, 20, 15를 대입하였다.
		 */
		num1 = 30;
		System.out.println(num2); // 0 이 출력
		num2 = 20;
		num3 = 15;
		
		/*
		 * num3 변수에 저장된 값을 "읽어서"
		 * Console에 연속 3번 출력하기
		 * 읽기는 수없이 실행해도 변수에 저장된 값은 
		 * 변함이 없다.
		 * 변수에 한번 대입(저장)된 값은 
		 * 코드가 작동 되는 동안(main method가 끝날 때 까지)
		 * 값이 계속 유지된다.
		 */
		
		System.out.println("num3 : " + num3);
		System.out.println("num3 : " + num3);
		System.out.println("num3 : " + num3);
		
		// num1, num2, num3 각각의 변수를 
		// 서로 복제하는 코드 순서가 애매하다
		// 이 코드가 실행 된 후 num1, num2, num3 값은 
		// 모두 같아진다.
		num1 = num3;
		num2 = num1;
		
		System.out.println("\nnum1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
		
		// 세개의 변수 중에 num3의 값을 
		// 200 으로 변경했다.
		// 변수 num3에만 정수 200을 대입했다.
		// 이 코드가 실행되었을 때
		// num1, num2 변수의 값은 변함이 없다.
		num3 = 200;
		System.out.println("\nnum1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
		
		
		
				
		
		
		
		
	}
}
