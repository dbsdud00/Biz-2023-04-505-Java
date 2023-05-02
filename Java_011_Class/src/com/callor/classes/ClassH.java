package com.callor.classes;

import java.util.Scanner;

public class ClassH {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str1;
		String str2;
		int num1;
		int num2;
		
		while(true) {
			System.out.println("두 개의 정수를 입력하세요.");
			System.out.println("정수가 아닌 수를 입력하면 종료합니다.");
			System.out.print("정수1 >> ");
			str1 = scan.nextLine();
			if (isInteger(str1) == true ) {
				num1 = Integer.parseInt(str1);
			} else {
				break;
			}

			System.out.print("정수2 >> ");
			str2 = scan.nextLine();
			if (isInteger(str2) == true ) {
				num2 = Integer.parseInt(str1);
			}
			else {
				break;
			}
			System.out.printf("%d + %d = %d\n", num1, num2, num1+num2);
			System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
			System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
			System.out.printf("%d / %d = %.2f\n", num1, num2, (float) num1 / (float) num2);
			System.out.println();
			
			

		}
		System.out.println("GAME OVER!");
	}
	 public static boolean isInteger(String num)
     {
      try
      {
       Integer.parseInt(num);    // int 형으로 변환해보고
       return true;                      // 이상없으면 true를 리턴
      }
      catch (NumberFormatException e)
      {
       return false;                    // 이상 있으면 false를 리턴
      }
     }
}
