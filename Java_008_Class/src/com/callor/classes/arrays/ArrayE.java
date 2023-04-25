package com.callor.classes.arrays;

public class ArrayE {
	public static void main(String[] args) {
		int[] nums = new int[10];
		for (int i = 0; i < 10; i++) {
			nums[i] = i + 1;
			// System.out.print(nums[i] + "\t");
		}
		System.out.println("------------------------------------------------");
		System.out.println("===================짝수구하기===================");
		for (int i = 0; i < 10; i++) {
			if (nums[i] % 2 == 0) {
				System.out.println(nums[i]);
			}
		}
		System.out.println("------------------------------------------------");
		System.out.println("===================소수구하기===================");
		for (int i = 0; i < 10; i++) {
			if (nums[i] > 1) {
				int j;
				for (j = 2; j < nums[i]; j++) {
					if (nums[i] % j == 0) {
						break;
					}
				}
				if (j >= nums[i]) {
					System.out.println(nums[i]);
				} else {
					System.err.println(nums[i]);
				}
			}
		}
		System.out.println("------------------------------------------------");
	}
}
