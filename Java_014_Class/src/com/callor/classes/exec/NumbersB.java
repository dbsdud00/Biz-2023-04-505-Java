package com.callor.classes.exec;

public class NumbersB {
	public static void main(String[] args) {
		
		String strNum1 = "30";
		String strNum2 = "40";
		
		System.out.println(strNum1 + strNum2);
		
		// 문자열형 숫자를 4칙연산이 가능한 정수형 숫자로 변환
		int intNum1 = Integer.parseInt(strNum1);
		Integer intNum2 = Integer.valueOf(strNum2);
		int intNum3 = Integer.valueOf(strNum1);
		
		/*
		 *  문자열형 숫자를 4칙연산이 되는 숫자 데에터로 변환시키는
		 * 	방법에는 2가지 mehtod가 있다.
		 *  
		 *  Integer.parseInt(), Float.parseFloat()
		 *  	문자열형 숫자를 primitive type의 숫자로 변환시킨다
		 *  Integer.valueOf(), Float.valueOf()
		 *  	문자열형 숫자를 참조형 숫자로 변환한다.
		 *  	만약 변수의 type이 primitive 인 경우 이 method는 데이터를 unboxing 하는 절차가 추가된다.
		 *  	일부에서는 성능상 Issue가 있다고 하지만 지금은 크게 문제되지 않는다.
		 *  
		 *  문자열형 숫자를 실제 숫자로 바꿀때는 Type.valueof() method를 
		 *  사용해도 큰 문제가 없다.
		 */
		float floatNum1 = Float.parseFloat("30.0");
		Float floatNum2 = Float.valueOf("30.0");
		
		System.out.println(intNum1 + intNum2);
		
	}
}
