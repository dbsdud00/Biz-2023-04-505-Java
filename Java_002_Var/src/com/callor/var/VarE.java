package com.callor.var;

public class VarE {
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		
		num1 = 30;
		num2 = 40;
		
		int plus1, minus1, times1, devide1;
		plus1 = num1 + num2;
		minus1 = num1 - num2;
		times1 = num1 * num2;
		devide1 = num1 / num2;
		
		System.out.printf("덧  셈 : %d + %d = %d\n", num1, num2, plus1);
		System.out.printf("뺄  셈 : %d - %d = %d\n", num1, num2, minus1);
		System.out.printf("곱  셈 : %d * %d = %d\n", num1, num2, times1);
		System.out.printf("나눗셈 : %d / %d = %d\n", num1, num2, devide1);
		
		
	}
}
