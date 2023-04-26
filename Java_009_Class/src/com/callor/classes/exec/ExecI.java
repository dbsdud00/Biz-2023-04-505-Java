package com.callor.classes.exec;

public class ExecI {
	public static void main(String[] args) {
		int[] nums = new int[50];
//		int lastNum = 0;
		int lastIndex = -1;
		for (int i = 0; i<nums.length;i++) {
			nums[i] = (int)(Math.random()*50) +51;
		}
		for (int i = 0; i< nums.length;i++ ) {
			if(nums[i]%3 == 0) {
				System.out.println(i + ". " + nums[i]);
				lastIndex = i;
//				lastNum = nums[i];
			}
		}
		// !!!!!!!!!!!!!!!!!!!! 3의 배수가 없을수도 있음 !!!!!!!!!!!!!!!!!!!!!!!
		/*
		 * lastIndex 초기화를 0으로 실행할 경우
		 * 만약 배열에 담긴 값중에 3의 배수가 하나도 없을 경우
		 * lastIndex는 그대로 0이 될것이고
		 * 결과출력에서 0의 index와 index 0의 요소값이 출력된다.
		 * 이러한 논리적인 문제를 해결하기 위하여
		 * lastIndex 를 -1로 초기화 하고 
		 * 결과 출력 부분에서 lastIndex의 값을 한번 더 검사할 필요가 있다.
		 */
		if (lastIndex > -1) {
			System.out.println();
			System.out.printf("%d위치의 %d값이 가장 마지막 3의 배수",lastIndex, nums[lastIndex]);			
		} else { 
			System.out.println("3의 배수 없음");
		}
		
		/*
		 * index의 시작값 : nums.lenght = 50
		 * index의 종료값 : nums.length > 0 조건이 있어서 index 1일 경우에 for() 종료
		 * 49, 48 , 47, 46, ... 0까지 index 값을 생성해야 하는데
		 * 여기의 코드는 50, 49, 48, ... ,1 까지 index가 생성되고 있다.
		 * 사작하자마자 nums[50] 요소의 값을 읽으려고 시도한다.
		 * Index OutofBound오류 발생 
		 */
//		for (int index = nums.length;index > 0; index--) {
		for (int index = nums.length -1; index >=0 ;index --) {
			if(nums[index]%3 == 0) {
				System.out.println("\n\n마지막 3의 배수 : " + nums[index]);
				System.out.println("위치 : " + index);
				break;
			}
		}

	}
}
