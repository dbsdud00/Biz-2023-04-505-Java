package com.callor.controller.var;

public class VarB {
	public static void main(String[] args) {
		
		// 문자형(character type) 변수
		// 영문자, 숫자(문자화된), 한글 '한글자'만 저장할 수 있는 변수
		char cVar = 'A';
		System.out.println(cVar);
		System.out.println(cVar + 0);
		
		for(char c = 'A'; c < 'Z' + 1 ; c++) {
			System.out.print(c);
			System.out.print("\t");
		}
	}
}
