package com.callor.system;

// class 이름은 반드시 첫글자 대문자
// 두단어 이상을 조합하는 것을 권장
// Camel Case 로 작성한다
public class SystemA {
	public static void main(String[] args) {
		System.out.println("Hello");
//		System.err.println("반갑습니다"); // 에러 출력
		
		System.out.println(); // ln = newline
//		System.out.print(); 
		// 괄호안에 아무것도 없음(argument가 없음) -> 사용방법이 틀렸다 -> 에러
		// print는 괄호안에 뭔가 있어야함
		
		System.out.print(30);
		System.out.print("+");
		System.out.print(40);
		System.out.print("=");
		System.out.print(30 + 40);
		System.out.println("안녕하세요");
		
		
	}
}
