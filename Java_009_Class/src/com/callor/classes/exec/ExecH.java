package com.callor.classes.exec;

public class ExecH {
	public static void main(String[] args) {
		int[] nums = new int[50];
		int count = 0; // 3의 배수의 개수를 저장할 변수
		int total = 0; // 3의 배수의 합계를 저장할 변수
		for (int i = 0; i < nums.length; i++) {	// 랜덤값 저장
			nums[i] = (int) (Math.random() * 50) + 51;
		}
		// 조건에 맞는 개수와 조건에 맞는 값의 합계를 계산
		// 개수의 합계를 저장할 변수를 먼저 선언
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 3 == 0) {	// 3의 배수 찾기
				count++;			// 3의 배수 개수 세기
				total += nums[i]; // 3의 배수 값 누적
				System.out.print(nums[i] + "  ");
			}
		}
		System.out.println();
		System.out.println("3의 배수 개수는 " + count + "개 이고,");
		System.out.println("3의 배수 합계는 " + total + "이다.");
	}
}
