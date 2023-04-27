package com.callor.classes.arrays;

public class ArrayC_Lotto {
	public static void main(String[] args) {
		int[] nums = new int[45]; // 정수형 배열 nums를 선언하고 요소 45개를 생성
		for(int i = 0; i<nums.length;i++) { // 45개 배열에 1~45까지 연속된 숫자를 저장
			nums[i] = i + 1;
		}
		
		for (int i = 0; i < 1000 ; i ++) {	// nums 배열에 저장된 값을 무작위로 섞는 연산을 1000번 수행
			int index1 = (int)(Math.random() * nums.length);
			int index2 = (int)(Math.random() * nums.length);
			
			int _tmp = nums[index1];
			nums[index1] = nums[index2];
			nums[index2] = _tmp;
			
			//nums[index1] = nums[index1] + nums[index2];
			//nums[index2] = nums[index1] - nums[index2];
			//nums[index1] = nums[index1] - nums[index2];
		}
		
		for (int i = 0 ; i < 6; i++) {	// nums 배열의 0~5 번 요소만 console 에 출력
			System.out.printf("%d\t",nums[i]);
		}
		
		
		
		System.out.println();
		System.out.println();
		
		int[] lottos = new int[6];
		for (int i = 0 ; i < lottos.length ; i++) {	
			lottos[i] = nums[i];
		}
		
		for(int i = 0 ; i< lottos.length-1 ; i++) {
			for (int k = i+1; k < lottos.length ; k++) {
				if(lottos[i] > lottos[k] ) {
					int _tmp = lottos[i];
					lottos[i] = lottos[k];
					lottos[k] = _tmp;
				}
			}
		}
		for (int i = 0; i< lottos.length;i++) {
			System.out.printf("%d\t",lottos[i]);
		}
	}
}
