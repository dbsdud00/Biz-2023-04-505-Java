package com.callor.classes.exec;

public class ExecG {
	// 매개변수 num 변수로 전달받은 값이
	// prime 이면 num을 아니면 0을 return 하는 method 선언
	public static int prime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return 0;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		int[] nums = new int[50];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50) + 51;
		}
		for (int i = 0; i < nums.length; i++) {

			if (prime(nums[i]) > 0) {
				System.out.println(nums[i]);
			}
		}
	}
}
