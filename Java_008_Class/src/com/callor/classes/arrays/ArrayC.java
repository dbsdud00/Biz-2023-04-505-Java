package com.callor.classes.arrays;

public class ArrayC {
	public static void main(String[] args) {
		int[] nums = new int[10];
		nums[0] = 39;
		nums[1] = 96;
		nums[2] = 23;
		nums[3] = 37;
		nums[4] = 33;
		nums[5] = 34;
		nums[6] = 12;
		nums[7] = 83;
		nums[8] = 53;
		nums[9] = 23;
		
		//System.out.println(nums[0]);
		//System.out.println(nums[1]);
		//System.out.println(nums[2]);
		//...
		
		// num0, num1, num2 ...
		for (int i = 0; i<10;i++) {
			System.out.println(i + ". " + nums[i]);
		}
	}
}
