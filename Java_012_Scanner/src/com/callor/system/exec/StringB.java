package com.callor.system.exec;

public class StringB {
	/*
	 *  문자열 변수는 생성하는 방법이 크게 2가지가 있다.
	 *  일반적인 방법 	: String st1 = "Korea";
	 *  클래스 객체 타입으로 생성하는 방법 
	 *  				: String str3 = new String("Korea");
	 *  문자열 변수는 생성하는 방법에 따라 같은 값 비교(==)의 결과가 다르게 나타난다.
	 *  따라서 문자열 변수는 같은 값 비교를 할 때 '절대' EQ(==)을 사용하면 안된다.
	 */
	public static void main(String[] args) {
		String str1 = "Korea";
		String str2 = "Korea";
		String str3 = new String("Korea");
		String str4 = new String("Korea");
		
		String str5 = "KOREA";
		
		System.out.printf("%s, %s, %s, %s, %s\n ", str1, str2, str3, str4, str5);
		
		// 문자열 2개를 비교할 떄는 == 을 쓰면 안된다
		System.out.println(str1 == str2);	// true
		System.out.println(str2 == str3);	// false
		System.out.println(str3 == str4);	// false
		System.out.println(str1 == str4);	// false

		
	}
}
