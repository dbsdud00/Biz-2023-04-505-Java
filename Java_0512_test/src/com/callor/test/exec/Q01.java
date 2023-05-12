package com.callor.test.exec;

public class Q01 {
	public static void main(String[] args) {
		int rndNum;
		int test = 100;
		int count = 0;
		
		for (int i = 0; i< test ; i++ ) {
			
			rndNum = (int)(Math.random()*100)+1;
			
			count++;
			
			if (rndNum <1 || rndNum>100){
				System.out.printf("테스트 횟수 : %d\n", count);
				System.err.printf("%d 번 테스트를 수행하려고 하였으나 %d번째에서 테스트에 실패함",test,count);
				return;
			}
		}
		System.out.printf("테스트 횟수 : %d\n", count);
		System.out.printf("%d 번 테스트 수행 결과 1~100 까지 범위의 랜덤수를 만들어 내고 있음",count);
		
	}
}	
