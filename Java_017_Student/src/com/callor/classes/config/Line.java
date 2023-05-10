package com.callor.classes.config;

/*
 *  코드에서 라인그리기 코드를 자주 사용해야 할 것으로 예상되어
 *  미리 static 변수와 static method로 생성해 두고
 *  필요할 때 호출하여 사용한다.
 */

public class Line {
	// 60개 짜리 고정길이로 Line 문자열 만들기
	public static final String dLine = "=".repeat(60);
	public static final String sLine = "-".repeat(60);
	
	public static final String dLine(int length) {
		return "=".repeat(length);
	}
	public static final String sLine(int length) {
		return "-".repeat(length);
	}
}
