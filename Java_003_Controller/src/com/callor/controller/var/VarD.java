package com.callor.controller.var;

public class VarD {
	public static void main(String[] args) {
		/*
		 * String은 일반적인 변수를 생성하는 키워드가 아니다.
		 * String은 특이하게 class이다.
		 * class를 사용하여 만든 변수를 인스턴스, object(객체) 라고 한다.
		 */
		String str1 = "Republic";
		String str2 = "Of";
		String str3 = "Korea";
		
		int num1 = 30;
//		num1. // int형 변수에서는 .을 찍어도 아무런 반응이 없다.
//		str1. // String에서는 여러 메쏘드와 함께 사용할 수 있다.
		System.out.printf("%s %s %s\n",str1, str2, str3);
		System.out.println(str1.toUpperCase()); // 문자열을 모두 대문자로 변경
		System.out.println(str1.toLowerCase()); // 문자열을 모두 소문자로 변경
		
		
		
	}
}
