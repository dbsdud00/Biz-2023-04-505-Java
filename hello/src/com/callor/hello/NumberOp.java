package com.callor.hello;
/*
 * 두개의 숫자 30과 40의 4칙연산을 수행하여 
 * 결과를 Console에 출력하시오
 */
public class NumberOp {
	public static void main(String[] args) {
		System.out.println(30 + 40);
		System.out.println(30 - 40);
		System.out.println(30 * 40);
		// 정수의 나눗셈은 몫을 구하는 연산
		System.out.println(30 / 40);
		// 정수의 나머지 연산
		System.out.println(30 % 40);
		
		// 실수와 실수를 나눗셈 연산
		// 연산 결과도 실수로 나타난다.
		System.out.println(30.0 / 40.0);
		// 소수점 이햐 17째 자리에서 버림 현상이 나타난다.
		System.out.println(4.0/3.0); // 배정도 실수 : double
		
		System.out.println(4.0F / 3.0F); // 단정도 실수 : float
		
		/*
		 * 코드에서 사용하는 숫자는 정수와 실수가 있고
		 * 큰 정수(Long)와 작은 정수(int, Integer), 배정도 실수(double), 단정도 실수(float)가 있다.
		 * 배정도 실수 : 소수점 이하 16자리까지 표시
		 * 단정도 실수 : 소수점 이하 7자리까지 표시
		 */
		System.out.println(999_999_999); // int 9자리
		System.out.println(999_999_999_999_999L); //Long 15자리
	}
}

//VCS(Version Control System)
//- 버전 관리 시스템
//- 소스코드의 변경 추적하고 관리하는 시스템
//- 어떤 내용을 누가 어느 시점에 변경했는지 History 관리
//- git, svn 등이 많이 사용
//- 2022년 기준 git 점유율이 90%이상 될 것이라고 예상