package com.callor.classes;

import java.util.Scanner;

public class ClassH {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;

		while(true) {
			System.out.println("두 개의 정수를 입력하세요.");
			System.out.println("-1을 입력하면 종료합니다.");
			System.out.print("정수1 >> ");
			num1 = scan.nextInt();

			System.out.print("정수2 >> ");
			num2 = scan.nextInt();

			System.out.printf("%d + %d = %d\n", num1, num2, num1+num2);
			System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
			System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
			System.out.printf("%d / %d = %.2f\n", num1, num2, (float) num1 / (float) num2);
			System.out.println();
			if ((-2 < num1 && num1 < 0) || (-2 < num2 && num2 < 0)) {
				break;
			}
		}
		System.out.println("GAME OVER!");
	}
}
