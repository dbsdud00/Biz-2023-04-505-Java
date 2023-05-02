package com.callor.classes;

import java.util.Scanner;

public class ClassE {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;
		System.out.print("첫번째 숫자 >> ");
		num1 = scan.nextInt();
		System.out.print("두번째 숫자 >> ");
		num2 = scan.nextInt();
		
		System.out.printf("%d + %d = %d\n", num1, num2, num1+num2);
		System.out.printf("%d - %d = %d\n", num1, num2, num1-num2);
		System.out.printf("%d * %d = %d\n", num1, num2, num1*num2);
		System.out.printf("%d / %d = %.2f\n", num1, num2, (float)num1/(float)num2);
		
		
		
	}
}	
