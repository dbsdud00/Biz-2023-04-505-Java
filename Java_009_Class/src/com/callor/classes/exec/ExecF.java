package com.callor.classes.exec;

public class ExecF {
	public static void main(String[] args) {
		int[] nums = new int[10]; // nums 배열에 저장공간 10개

		for (int i = 0; i < nums.length; i++) {	// 각 배열 요소에 랜덤수 저장
			nums[i] = (int) (Math.random() * 50) + 51;
			System.out.println(i + ". " + nums[i]);
		}
		System.out.println();
		// 배열의 요소에 저장된 값 중에서 최초로 5의 배수가 저장된 위치 찾기
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 5 == 0) {	// 배열에서 5의 배수 찾기
				System.out.println(i + "인덱스에 최초로 5의 배수인 " + nums[i] + "가 들어있다!");
				break;// 찾았으면 for문 나가기
			}
		}
	}
}
