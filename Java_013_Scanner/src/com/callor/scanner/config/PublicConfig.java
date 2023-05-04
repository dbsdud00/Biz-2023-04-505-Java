package com.callor.scanner.config;

public class PublicConfig {
	
	/*
	 *  변수 선언 문에 static 추가된 경우
	 *    "클래스 변수"
	 *  프로젝트가 시작될 때 자동으로 생성(선언, 초기화) 되는 변수
	 *  이 변수는 클래스를 객체로 생성하지 않아도 사용할 수 있는 변수
	 *  
	 *  일반적인 클래스에 선언된 변수 사용하기 위해서는 반드시 객체 선언이 먼저 되어야 한다.
	 *  	DataClass obj = new Class();
	 *  	obj.변수 = 30;
	 *  
	 *  클래스 변수는 객체로 선언하지 않고 직접 호출할 수 있다.
	 *  	Config.변수 = 30;
	 *  	System.out.println(Config.변수);
	 *  
	 */
	
	public static String dLine = "=".repeat(60);
	public static String sLine = "-".repeat(60);
	
	/*
	 *  클래스 mehtod
	 *  프로젝트가 시작될 때 자동으로 메모리에 loading 되어
	 *  사용할 준비가 완료되는 method
	 *  PublicConfig.dLine(100);
	 */
	
	public static String dLine(int length) {
		return "=".repeat(length);
	}
	public static String sLine(int length) {
		return "-".repeat(length);
	}
	
	
	
	/*
	 *  클래스에 포함된 변수, method 에는 static 키워드를 추가할 수 있다.
	 *  원래는 이러한 변수, method를 정적 변수, 정적 메소드 라고 한다.
	 *  
	 *  프로젝트가 시작될 때 언제든지 사용할 수 있도록 미리 준비되는 도구들
	 *  사용할때는 "클래스명.변수", "클래스명.메서드()" 와 같이 직접
	 *  클래스 이름을 통하여 접근한다.
	 */
	
	/*
	 * 교재 
	 * 
	 * 292p
	 * static 제어자
	 * 
	 * 290p
	 * 접근 지정자
	 * 
	 * 302p
	 * main
	 * 
	 * JVM
	 * 
	 * Hello.class - > java -> 실행
	 * 
	 * OS(Operating System)
	 * 
	 * PC (MAC, Windows, Linux (OS)로 사용)
	 * 
	 * JVM - 가상머신
	 * One Make Many Work
	 * 
	 * main을 static으로 만듦
	 * 
	 * 프로젝트를 run함과 동시에 main이 올라감
	 * 
	 * 
	 */
	
	
}
