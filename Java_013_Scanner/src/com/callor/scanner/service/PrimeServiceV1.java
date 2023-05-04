package com.callor.scanner.service;

import java.util.Scanner;

public class PrimeServiceV1 {
	private static int getNum() {
		Scanner scan = new Scanner(System.in);
		int intNum;
		String inputNum = "";

		while (true) {
			System.out.print("3이상의 양의 정수를 입력하세요(QUIT:종료) : ");
			inputNum = scan.nextLine();
			if (inputNum.equals("QUIT")) {
				return -1;
			}
			try {
				intNum = Integer.valueOf(inputNum);
				if (intNum < 3) {
					continue;
				}
				// continue 키워드를 사용하고 싶지 않으면
//				if (intNum >= 3) {
//					break;
//				}
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("정수형이 아닙니다. 다시 입력하세요.");
			}
		}
		return intNum;
	}


	public static int prime(int num) {
		int i;

		for (i = 2; i < num; i++) {
			if (num % i == 0) {
				return -1;
			}
		}
		return num;
	}

}
