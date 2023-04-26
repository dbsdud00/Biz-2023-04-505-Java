package com.callor.classes.exec;

public class ExecC {
	public static void main(String[] args) {
		// 배열 생성(선언, 초기화)
		int[] nums = new int[10]; // 정수형 배열 10개를 nums 이름으로 선언
		
		int total = 0; // 정수들의 합을 저장할 변수
		
		// 생성된 배열 요소에 값 채워넣기
		// 데이터 수집
		for(int i = 0; i<10; i++) { // 51~ 100 까지의 랜덤수를 생성하여 각 요소에 저장
			nums[i] = (int)(Math.random()*50)+51;
			System.out.print(nums[i] + "\t");
		}
		
		// 배열 요소에 채워진 값들의 전체를 합산
		// 데이터 처리
		System.out.println();
		for (int i = 0; i<10 ;i++) { // 배열에 저장된 정수들의 합을 계산
			total += nums[i]; 
		}
		System.out.println(total); // 그 결과를 Console에 출력
	}
}
