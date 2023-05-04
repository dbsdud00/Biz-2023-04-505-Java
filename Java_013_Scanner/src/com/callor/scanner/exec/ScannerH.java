package com.callor.scanner.exec;

import java.util.Scanner;

public class ScannerH {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] nums = new int[6];
		String strNum = "";
		int num = 0;
		int index = 0;
		int maxNum = 45;
		int rndNum =0;
		
		
		int r = 0 ;	// nums 배열의 r 번째에 값을 저장하면 1씩 증가할 것임
		while (r < nums.length) {	// 배열 안에 1 ~ maxNum 사이의 랜덤한 정수를 저장할 반복문
			rndNum = (int) (Math.random() * maxNum) + 1;	// 랜덤 정수 생성
//			System.out.println(rndNum);
			int i = 0;
			for (i = 0; i< r+1; i++) {	// 중복을 찾기위한 반복문
				if (rndNum == nums[i]) {	// 중복을 찾으면 중복 찾는 반복문 나감
//					System.out.println("중복수 제거" + rndNum);
					break;
				}
			}
			if (i >= r) {	// 만약 중복을 찾지 못했다면 i와 r값은 같아질 것임
				nums[r] = rndNum;	// 이때 nums[r]에 랜덤수 저장
				r++;				// r번째에 값을 저장했으니 r+1번째에 값을 저장하기 위해 1 증가
			}
			
		} // 배열에 랜덤값을 다 저장하면 빠져나옴
		
		
		// nums 배열 출력
		for (int i= 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();
		
		
		// 배열 안의 랜덤수 찾기 game 시작
		while (true) {
			System.out.println("=".repeat(30));
			System.out.println("숫자를 맞춰봐(싫으면 QUIT)");
			// 1~ 45 랜덤수 생성
			
			while (true) {	// nums의 index번째 값을 찾을 때까지 반복
				System.out.print(">> ");
				strNum = scan.nextLine();
				
				if (strNum.equals("QUIT")) {
					break;
				}

				try {
					num = Integer.valueOf(strNum);

					if (num < 1 || num > maxNum) {
						System.out.printf("1 ~ %d까지야",maxNum);
						continue;
					} else if (num == nums[index]) {
						System.out.println("참 잘했어요 :)");
						index ++;
						if (index > nums.length-1) {
							break;
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
			if (strNum.equals("QUIT")||index > nums.length-1) {
				System.out.println("GAME OVER");
				break;
			}
		}
		
		
		
		
		
		for (int i= 0; i < nums.length-1; i++) {
			for (int j = i+1;j<nums.length;j++) {
				if (nums[i] > nums[j]) {
					int tmp = nums[i];
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}

		}
		for (int k = 0; k< nums.length; k++) {
			System.out.print(nums[k] + " ");
		}
		
		
	}
}
