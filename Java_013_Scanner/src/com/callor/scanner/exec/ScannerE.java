package com.callor.scanner.exec;

import java.util.Scanner;

public class ScannerE {
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
				} else if(num > rndNum){
					System.out.println("너무 커");
				} else if (num < rndNum){
					System.out.println("너무 작아");
				} 
			}
			System.out.println();
		}
	}
}
