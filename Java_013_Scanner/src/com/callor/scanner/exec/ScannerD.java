package com.callor.scanner.exec;

import java.util.Scanner;

/*
 *  1. 1~10 까지 범위의 랜덤수를 생성하여 rndNum 변수에 저장
 *  2. Scanner 클래스를 사용하여 키보드로 1~ 10 까지 정수를 입력 받고
 *  3. rndNum 변수에 저장된 값을 맞추기
 *  4. 숫자를 맞추면 "잘했어요" 출력 후 새로운 게임 시작
 *  5. QUIT를 입력하면 "GAME OVER"
 */

public class ScannerD {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String strNum = "";
		int num = 0;

		while (true) {

			System.out.println("=".repeat(30));
			System.out.println("숫자를 맞춰봐(싫으면 QUIT)");
			int rndNum = (int) (Math.random() * 10) + 1;

			while (true) {
				System.out.print(">> ");
				strNum = scan.nextLine();

				if (strNum.equals("QUIT")) {
					System.out.println("GAME OVER");
					return;
				}

				try {
					num = Integer.valueOf(strNum);
					if (num < 1 || num > 10) {
						System.out.println("1 ~ 10까지야");
						continue;
					}

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("정수가 아니잖아");
					continue;
				}

				if (num == rndNum) {
					System.out.println("참 잘했어요 :)");
					break;
				} else {
					System.out.println("틀렸어");
					continue;
				}
			}
			System.out.println();
		}
	}
}
