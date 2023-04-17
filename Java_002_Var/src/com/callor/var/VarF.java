package com.callor.var;

public class VarF {
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		num1 = 30;
		num2 = 43;
		// 데이터 type 이 true, false 로만 나타난다.
		boolean bEven1 = num1 % 2 == 0;
		boolean bEven2 = num2 % 2 == 0;
		
		System.out.println(num1 + "은 짝수니? : " + (bEven1?"응":"아니"));
		System.out.println(num2 + "은 짝수니? : " + (bEven2?"응":"아니"));
	}
}
