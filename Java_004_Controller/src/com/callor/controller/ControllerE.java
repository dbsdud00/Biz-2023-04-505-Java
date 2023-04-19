package com.callor.controller;

/*
 * 51~100 까지 랜덤 수 1개를 만들고
 * 이 수가 소수(Prime)수 가 아닌지 찾기
 * Prime : 1과 자신 이외의 약수를 갖지 않는 수
 * 		2 ~ (자신 -1) 범위의 정수로 각각 나누었을 때 
 * 		나머지가 한번도 0이 아닌 수
 * 
 * 		나머지가 한번이라도 0이 되면 prime이 아니다.
 * 
 */

public class ControllerE {
	public static void main(String[] args) {

		for (int j = 0; j<100;j++) {
			int isPrime = (int)(Math.random()*50)+51;
			// 이 for() 명령에 의해
			// index 값은 2 부터 isPrime -1 까지 연속된 정수로 만들어져 for() {} 에서 사용가능하다.
			for (int i = 2;i<(isPrime/2);i++) {
				if (isPrime % i == 0 ) { // isPrime을 i 로 나눴을 때 나머지가 0이면 소수가 아니다.
					System.out.println(isPrime + "은 소수가 아님.  " + i + "(으)로 나누어 진다.");
					// 반복문을 수행하며 연산을 실행하는 과정에서 소수가 아님을 판별하면 더이상 반복문을 진행할 필요가 없으므로 여기서 중단
					// break : for() 반복문을 중단할 때 사용. 반복문 밖에서는 사용할 수 없음.
					break;
				}
			}
		}
	}
}
