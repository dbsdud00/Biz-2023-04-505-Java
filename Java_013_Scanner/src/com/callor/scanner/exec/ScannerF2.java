package com.callor.scanner.exec;

import java.util.Scanner;

import com.callor.scanner.config.PublicConfig;

public class ScannerF2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 정수형 배열 6개를 만들어라 -> 정수형 요소 6개를 갖는 nums 배열 생성
		int[] nums = new int[6];
		
		// nums 배열 요소에 한번도 저장되지 않은 rndNum 값 찾기(만들기)
		int numsSaveIndex = 0; // nums의 "어느 위치"를 알려줄 변수
		
		while(true) {
			int rndNum = (int)(Math.random()*45)+1;
			int searchIndex;
			for (searchIndex = 0; searchIndex< nums.length; searchIndex++ ) {
				if(nums[searchIndex] == rndNum) {
					break;
				}
			}
			// rndNum 에 저장된 값이 nums 요소에 있으면 다시 while() 처음으로
			if (searchIndex < nums.length) {
				continue;
			}
			System.out.println(rndNum); // 테스팅용
			// 여기에 도달하면 rndNum는 중복되지 않은 랜덤수 
			while(true) {
				System.out.println(PublicConfig.dLine);
				System.out.print("정수 입력 ( QUIT : 종료 ) >> ");
				String strNum = scan.nextLine();
				if(strNum.equals("QUIT")) {
					System.out.println("게임을 중단");
					return;
				}
				int intNum =0;
				try {
					intNum = Integer.valueOf(strNum);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("입력값 오류!!");
					System.out.println("정수만 입력하세요!");
					continue;
				}
				
				System.out.println(PublicConfig.sLine);
				
				if (intNum<0 || intNum>45) {
					System.out.println("1~45 범위의 정수 값을 입력하세요!");
				} else if (rndNum == intNum) {
					System.out.println("참 잘했어요");
					// nums 배열에 "어느 위치"에 rndNum를 저장해야 한다.
					nums[numsSaveIndex++] = rndNum;
					break;
				} else if (rndNum > intNum) {
					System.out.printf("%d, 입력값이 작아요\n", intNum);
				}else if (rndNum < intNum) {
					System.out.printf("%d, 입력값이 커요\n", intNum);
				}
					
			}// 숫자 맞추기
			
			// 참 잘해써요 break 를 만났을 때 진행 곳
			if (numsSaveIndex >=nums.length) {
				break;
			}
			System.out.println();		
			System.out.println();
		} // 1st while
		
		System.out.println("GAME OVER!!");
		for (int i = 0; i< nums.length; i++) {
			System.out.printf("%d\t",nums[i]);
		}
		System.out.println();		
		System.out.println();
		
	}
}
