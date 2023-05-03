package com.callor.system.exec;

import java.util.Scanner;

public class ScannerE {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;
		
		while(true) { // while(1)
			
			System.out.println("두 개의 정수를 입력하세요."); 
			String strNum1 = "";
			String strNum2 = "";
			
			while (true) { // 정수 1 입력받을 while 문 - while(2)
				System.out.print("정수1 ( QUIT:종료 ) >> "); 
				strNum1 = scan.nextLine();				// 정수 1 문자열형으로 입력받기
				if (strNum1.equals("QUIT")) {			// 만약 입력받는 값이 "QUIT" 이라면 while(2) 종료 -> 33
					break;
				}				
				try {									// try문 이 오류 -> catch 문 출력
					num1 = Integer.valueOf(strNum1);	// 입력받은 값을 정수형으로 변경
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("정수 1은 정수 값만 입력해야 합니다.");		// 오류가 났다면 while(2) 다시 실행 -> 18
					continue;
				}
				break;	// 정상적으로 입력을 받았다면 while(2) 나가기 -> 33
			}
			
			
			
			
			
			if (strNum1.equals("QUIT")) {	// 입력받은 값이 "QUIT"라면 while(1) 나가기 -> 66
				 break;
			 }
			
			
			
			
			while(true) {
				System.out.print("정수2 ( QUIT:종료 ) >> ");
				strNum2 = scan.nextLine();
				if(strNum2.equals("QUIT")) {
					break;
				}
				try {
					num2 = Integer.valueOf(strNum2);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("정수 2는 정수 값만 입력해야 합니다.");
					continue;
				}
				break;
			}
			 if (strNum2.equals("QUIT")) {
				 break;
			 }
			
			System.out.printf("%d + %d = %d \n", num1 , num2, num1 + num2);
			System.out.printf("%d - %d = %d \n", num1 , num2, num1 - num2);
			System.out.printf("%d * %d = %d \n", num1 , num2, num1 * num2);
			System.out.printf("%d / %d = %.2f \n", num1 , num2, (float)num1 / (float)num2);
			System.out.println();
		}
		
		System.out.println("GAME OVER!");
	}
}
