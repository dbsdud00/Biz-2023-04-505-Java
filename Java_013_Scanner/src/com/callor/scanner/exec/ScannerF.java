package com.callor.scanner.exec;

import java.util.Scanner;

public class ScannerF {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[6];
		String strNum = "";
		int num = 0;
		int index = 0;
		int maxNum = 7;
		
		while (true) {

			System.out.println("=".repeat(30));
			System.out.println("숫자를 맞춰봐(싫으면 QUIT)");
			// 1~ 45 랜덤수 생성
			int rndNum = (int) (Math.random() * maxNum) + 1;
			int r = 0;
//			for (r = 0; r < nums.length ; r++) {
//				if (rndNum == nums[r]) {
//					rndNum = (int) (Math.random() * maxNum) + 1;
//					r = 0;											// ********************* 0을 넣으면 r++로 1부터 for문 다시 시작됨 그래스 -1을 넣어야함 **********************
//					System.out.println("중복수 제거");
//				} 
//			}
			while (r < nums.length) {
				System.out.println(rndNum);
				if (rndNum == nums[r]) {
					System.out.println("중복수 제거" + rndNum);
					rndNum = (int) (Math.random() * maxNum) + 1;
					r = 0;
					continue;
				} else {
					r ++;
				}
			}
			for (int i= 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}

			while (true) {
				System.out.print(">> ");
				strNum = scan.nextLine();
				
				if (strNum.equals("QUIT") || index > nums.length) {
					System.out.println("GAME OVER");
					return;
				}

				try {
					num = Integer.valueOf(strNum);

					if (num < 1 || num > maxNum) {
						System.out.printf("1 ~ %d까지야",maxNum);
						continue;
					} else if (num == rndNum) {
						System.out.println("참 잘했어요 :)");
						nums[index] = num;
						index ++;
						if (index > nums.length-1) {
							System.out.println("GAME OVER");
							for (int i= 0; i < nums.length; i++) {
								System.out.print(nums[i] + " ");
							}
							return;
						}
						
						break;
					} else if (num > rndNum) {
						System.out.println("너무 커");
					} else if (num < rndNum) {
						System.out.println("너무 작아");
					}

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("정수가 아니잖아");
					continue;
				}

			}
			System.out.println();
		}
	}
}
