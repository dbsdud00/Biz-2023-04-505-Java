package com.callor.classes.exec;

public class ExecD {
	public static void main(String[] args) {
		int[] nums = new int[10]; // 정수형 배열 10개를 nums 이름으로 선언
		
		// 데이터 준비, 데이터 수집
		for (int i = 0 ; i<10 ; i++) { // 50 ~ 100 까지의 랜덤수를 각 요소에 저장
			nums[i] = (int)(Math.random()*50) + 51;
			System.out.print(nums[i] + "\t");
		}
		System.out.println();
		
		// 데이터 처리 5의 배수 찾기
		for (int i = 0; i<10 ; i++) { // 저장된 수 중에서 5의 배수들만 찾아서 Console에 출력
			if (nums[i]%5 == 0) {
				System.out.println(nums[i]);
			}
		}
	}
}
