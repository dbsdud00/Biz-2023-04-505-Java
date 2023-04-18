package com.callor.controller.var;

public class VarC {
	public static void main(String[] args) {
		String str = "ABC"; // 첫글자가 대문자 == 클래스
		// str에는 첫글자인 (char) A가 저장된 '주소'를 저장한다.
		
		System.out.println(str);
		str = "Korea"; // 사용하지 않는 기억장소를 비워주는 GC(Garbage collection)이 있어서 str이 Korea를 가리키면 ABC를 저장한 주소는 GC가 처리한다.
		str = "대한민국";
		str = "우리나라";
		System.out.println(str);
		
		str = "Republic" + " of " + "Korea";
		System.out.println(str);
	}
}
