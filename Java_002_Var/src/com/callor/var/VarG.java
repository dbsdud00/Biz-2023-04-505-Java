package com.callor.var;

public class VarG {
	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 0;
		
		num1 = num1 + 10; // 10
		num2 += 10;
		
		num1 = num1 - 5; // 5
		num2 -= 5;
		
		num1 = num1 * 3; // 15
		num2 *= 3;
		
		num1 = num1 / 2; // 7
		num2 /= 2;
		
		num1 = num1 % 2; // 1
		num2 %= 2;
		
		System.out.println(num1);
		System.out.println(num2);

	}
}
