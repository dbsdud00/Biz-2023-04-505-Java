package com.callor.classes.exec;

public class ExecJ {

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

		int firstIndex = -1;
		int lastIndex = -1;

		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * 50) + 51;
		}
		System.out.println("==================================================================");
		for (int i = 0; i < nums.length; i++) {
			if (prime(nums[i]) > 0) {
				firstIndex = i;
				break;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (prime(nums[i]) > 0) {
				lastIndex = i;
			}
		}
		if (firstIndex < 0) {
			System.out.println("소수 없음");
		} else {
			System.out.println("첫번째 소수는 '" + firstIndex + "'인덱스의 '" + nums[firstIndex] + "'");
			System.out.println("마지막 소수는 '" + lastIndex + "'인덱스의 '" + nums[lastIndex] + "'");
		}
		
		System.out.println("==================================================================");
		int index;
		for (index = 0; index < nums.length; index++) {
			if (prime(nums[index])>0 ) {
				break;
			}
		}
		System.out.println("첫번째 소수는 '" + index + "'인덱스의 '" + nums[index] + "'");
		
		for (int i = 0; i < nums.length; i++) {
			if (prime(nums[i])>0 ) {
				lastIndex = i;
			}
		}
		System.out.println("마지막 소수는 '" + lastIndex + "'인덱스의 '" + nums[lastIndex] + "'");
		
		System.out.println("==================================================================");
		
		firstIndex = -1;
		lastIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			if(firstIndex < 0 && prime(nums[i]) >0) {
				firstIndex = i;
			}
			if (prime(nums[i])>0) {
				lastIndex = i;
			}
		}
		if (firstIndex < 0) {
			System.out.println("소수 없음");
		} else {
			System.out.println("첫번째 소수는 '" + firstIndex + "'인덱스의 '" + nums[firstIndex] + "'");
			System.out.println("마지막 소수는 '" + lastIndex + "'인덱스의 '" + nums[lastIndex] + "'");
		}
		System.out.println("==================================================================");
	}
}
