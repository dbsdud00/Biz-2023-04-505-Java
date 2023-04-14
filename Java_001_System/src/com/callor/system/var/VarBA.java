package com.callor.system.var;

public class VarBA {
	public static void main(String[] args) {
		
		int intNum1 = 0; // 작은 정수
		long longNum1 = 0; // l 선택 // 큰 정수
		
		float floatNum1 = 0.0f; // 소수점 7번째 자리까지 표시 // f 필수 // 작은 실수 // 단정도 실수
		double douNum1 = 0.0; // 큰 실수 // 배정도 실수
		
		
		// 데이터의 형 변환(type cast, convert)
		
		
		
		longNum1 = intNum1; // int 형 데이터를 long형 변수에 저장하는 경우 error x 	// 자동으로 실수로 변경되어 저장됨
//		intNum1 = longNum1; // long형 데이터를 int 형 변수에 저장하는 경우 error		
		
//		floatNum1 = douNum1; // double 형 데이터를 float 형 변수에 저장하는 경우 error
		douNum1 = floatNum1; // float형 데이터를 double형 변수에 저장하는 경우 error x  // 자동으로 double로 변경되어 저장됨
		
		intNum1 = (int)longNum1; // int로 자료형 강제 변경 후 저장
		floatNum1 = (float)douNum1; // float로 자료형 강제 변경 후 저장
		
		
		
		
	}
}
