package com.callor.controller.var;

public class VarF {
	public static void main(String[] args) {
		String str = "Republic of Korea";
		char cVar = str.charAt(3); // 3번째 문자 u 추출 (0123)
		System.out.println(cVar);
		System.out.println(str.length()); // length() : int - String -> String의 길이를 int type으로 표현한다.
		for (int i = 0; i<str.length(); i++) {
			System.out.print(str.charAt(i)+ "\t");
		}
		
	}
}
