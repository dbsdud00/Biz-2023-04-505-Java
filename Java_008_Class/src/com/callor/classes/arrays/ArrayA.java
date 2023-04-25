package com.callor.classes.arrays;

/*
 *  컴퓨터를 이용한 데이터 처리에서는
 *  1개의 데이터만 처리하는 경우는 극히 드물다.
 *  일반적으로 컴퓨터를 이용하는 정보처리는
 *  다수의 데이터를 효과적으로 처리하는 목적이 있다.
 *  다수의 데이터를 빠른시간에 효율적으로 처리하고 답을 구하는 것이 정보처리이다.
 *  
 *  이때 변수를 선언하는데 
 *  한번에 다수의 변수를 선언하고, 사용하는 방법으로
 *  배열(Array) 라는 것을 시작한다.
 */
public class ArrayA {
	/*
	 *  다수의 데이터를 변수에 저장하기 위하여
	 *  num1, num2, num3, num4, num5 ... 과 같이 변수를 선언하는 방법이 있으나,
	 *  변수의 개수가 매우 많아질 경우에는 코딩에 매우 어려움이 있다.
	 *  
	 *  이런경우 배열을 이용하여 처리한다.
	 */
	public static void main(String[] args) {
		// 국어 점수를 저장할 intKor 변수를
		// 10개 생성하기
		/*
		 * int[] : 정수형 데이터를 저장할 기억장소 공간이 여러개 필요하다 라는 선언
		 * 			=> 배열 선언 키워드
		 * 저장소의 이름은 intKor로 하겠다.
		 * ? 몇개가 필요한데
		 * new int[10] : 10개의 데이터 저장 공간이 필요하다.
		 */
		int[] intKor = new int[10];  
		float[] floatKor = new float[10];
		String[] strs = new String[10];


	}
}
