package com.callor.scanner.exec;

import java.util.Scanner;

// 입력받은 수가 소수인지 판별

public class ScannerA {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int intNum;
		String inputNum = "";

		while (true) {
			System.out.print("수를 입력하세요 : ");
			inputNum = scan.nextLine();
			try {
				intNum = Integer.valueOf(inputNum); // 여기서 오류가 발생하면 밑의 try문은 실행되지 않고 catch로 넘어감
				break;	// 오류가 나지 않으면 break로 while을 나가게 됨
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("정수형이 아닙니다. 다시 입력하세요.");
			}
		}
		int i;

		for (i = 2; i < intNum; i++) {
			if (intNum % i == 0) {
				break;
			}
		}
		if (i >= intNum) {
			System.out.println("소수");
		} else {
			System.out.println("소수아님");
		}
		

	}
}
