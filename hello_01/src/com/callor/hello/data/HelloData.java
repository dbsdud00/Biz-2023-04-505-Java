package com.callor.hello.data;

public class HelloData {
	public static void main(String[] args) {
		System.out.println("Hello Korea"); // 
		System.out.println("Hello" + "Korea");
		System.out.println("Hello           Korea");
		System.out.println("Hello"    +    "Korea");
		
		
		System.out.println(30 + 40); // 산술 연산
		System.out.println("30" + "40"); // 문자열 연산
		System.out.println("30 + 40"); // 문자열
		
		// 30 + 40 = 70
		System.out.println("30 + 40 = 70");
		System.out.println("30 + 40 = " + 30 + 40);
		/*
		 * 덧셈 우선순위에 의해 "30 + 40 = " + 30을 연산하려고 시도한다.
		 * 이 연산은 문자열 + 숫자의 연산인데 
		 * 이렬경우 숫자 데이터인 30은 문자열 30으로 변환된다.
		 */
		System.out.println("30 + 40 = " + "30" + 40); // 이렇게 변환되어
		System.out.println("30 + 40 = " + "30" + "40"); // 결국 이렇게 변환된다.
		/*
		 * 괄호를 통해 연산순서를 바꾸어 원하는 결과를 얻을 수 있다.
		 */
		System.out.println("30 + 40 = " + (30 + 40));
		
//		// 아래의 경우는 연산 순서에 의해 숫자끼리 먼저 더함
//		System.out.println(30+40+"=30+40");
		
		// 곱셈이 덧셈보다 연산 우선순위가 높아서 원하는 결과가 나온다.
		System.out.println("30 X 40 = " + 30 * 40);
		
		// 덧셈이 먼저 계산이 되고 문자열이 된다. 문자열과 숫자는 -연산을 할 수 없기에 오류 발생.
		// 문자열은 덧셈연산(연결 연산자)만 가능하다. 덧셈 외에는 오류 발생
		//System.out.println("30 - 40 = " + 30 - 40);

	}
}
