package com.callor.classes.exec;

public class ClassA {
	public static void main(String[] args) {
		// 정수형 배열 10개 생성
		int[] nums = new int[10];
		
		// 개별요소(0번요소)에 값 저장
		nums[0] = (int)(Math.random() * 50) + 51;
		
		// 정수형 배열 10의 요소에 51~100까지 랜덤수 저장
		for (int i = 0 ; i< nums.length;i++) {
			nums[i] = (int)(Math.random()*50) +51;
		}
		
		for (int i = 0 ; i < nums.length; i++) {
			if( nums[i] % 2 == 0) {
				System.out.println(i + ". " +nums[i]);
				break;
			}
		}
		
		
		
	}
}
