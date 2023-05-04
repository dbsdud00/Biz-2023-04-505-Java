package com.callor.scanner.exec;

import java.util.Scanner;

// 입력받은 수가 소수인지 판별

public class ScannerB {

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
//				if (intNum < 3) {
//					continue;
//				}
				// continue 키워드를 사용하고 싶지 않으면
				if (intNum >= 3) {
					break;
				}
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("정수형이 아닙니다. 다시 입력하세요.");
			}
		}
		return intNum;
	}

	// 매개변수를 통하여 전달받은 num 변수의 값이
	// prime이 아니면 -1을 return, prime이면 num 변수의 값을 return
	public static int prime(int num) {
		int i;

		for (i = 2; i < num; i++) {
			if (num % i == 0) {
				return -1;
			}
		}
		return num;
	}

	public static void main(String[] args) {


		while(true) {
			int num = getNum();
			if (num < 0) {
				System.out.println("GAME OVER!");
				// 메인에서 return 명령이 실행되면
				// 프로젝트 코드 전체를 중단하라는 것이다.
				return;
			}

			// prime() method는 전달받는 num "변수의 값"이 prime 이면 num을 return, 아니면 -1을 return 한다.
			// return한 결과를 result 변수에 저장한다.
			int result = prime(num);

			// result 변수에 저장된 값을 보고 prime 인지 아닌지 판단한다.
			if (result > 0) {
				System.out.println("소수");
			} else {
				System.out.println("소수아님");
			}
		}
	}
}
