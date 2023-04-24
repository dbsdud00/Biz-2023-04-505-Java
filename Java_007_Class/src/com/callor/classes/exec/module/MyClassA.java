package com.callor.classes.exec.module;

public class MyClassA {
	/*
	 *  MyClassA 클래스의 '생성자' method
	 *   public 키워드만을 가진 method
	 *   클래스와 이름이 같은 method
	 */
	public MyClassA() {
		
	}
	
	// 두개의 정수형 변수를 매개변수로 전달받아서 그 두 값을 덧셈하여 return 하는 add() method
	// static 키워드가 없는 method()
	public int add(int num1, int num2) {
		return(num1 + num2);
	}
}
