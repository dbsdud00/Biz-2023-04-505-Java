package com.callor.system.var;

public class VarBC {
	public static void main(String[] args) {
		
		int intNum1 = 0;
		int intNum2 = 0;
		
		intNum1 = 32;
		intNum2 = 41;
		
		// 두 변수에 저장된 값의 크기를 비교하는 연산
		System.out.println(intNum1 > intNum2);
		System.out.println(intNum1 < intNum2);
		System.out.println(intNum1 == intNum2);
		System.out.println(intNum1 >= intNum2);
		System.out.println(intNum1 <= intNum2);
		System.out.println(intNum1 != intNum2);
		
		System.out.println("----------");
		
		// 각 변수에 저장된 값이 짝수인가?
		System.out.println(intNum1 % 2 == 0);
		System.out.println(intNum2 % 2 == 0);
		
		System.out.println("----------");
		
		// 두 변수에 저장된 값이 모두 짝수인가?
		System.out.println(intNum1 % 2 == 0 && intNum2 % 2 == 0); // and
		
		// 두 변수에 저장된 값 중에 한개라도 짝수인가?
		System.out.println((intNum1 % 2 == 0) || (intNum2 % 2 == 0)); // or
		
		System.out.println("----------");
		
		
		int intYes1 = intNum1 % 2;
		int intYes2 = intNum2 % 2;
		
		System.out.println(intYes1 + intYes2 > 0); // and
		System.out.println(intYes1 * intYes2 > 0); // or

		
		
		
		
		
		
	}
}
