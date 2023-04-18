package com.callor.controller.var;

public class VarE {
	public static void main(String[] args) {
		String str = "Republic of Korea";
		String nation = ""; // 비어있음은 blank or empty 라고 표현
		nation = str.substring(12); // str이라는 문자열에 12번째 칸부터 끝까지 문자열을 잘라서 nation이라는 변수에 담음 -> 문자열을 자르는 도구
		// UpperCase, LowerCase, substring 등은 자기자신은 변경되지 않는다
		System.out.println(nation); // 
		
		System.out.println(str.substring(9,11)); // 9번째 부터 11번째까지 자르기
		
		/*
		 * nation = str.substring(12);
		 * str 에 저장된 문자열을 12번째 에서 잘라서
		 * 오른쪽의 문자열을 nation 변수에 저장
		 * 
		 * str.substring(9,11)
		 * str에 저장된 문자열을 9번째에서 한번 자르고
		 * 11번째에서 또한번 잘라서 그 사이의 문자열을 출력
		 */
		
	}
}
