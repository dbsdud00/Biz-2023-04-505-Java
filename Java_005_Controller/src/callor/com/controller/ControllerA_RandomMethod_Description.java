package callor.com.controller;

public class ControllerA_RandomMethod_Description {
	public static void main(String[] args) {
		// 변수가 최초로 만들어 질 때 저장되는 값 : 초기화 값
		/*
		 *  큰 실수 형(double) douNum 변수를 선언하고
		 *  Math.random()가 만들어준 값으로 초기화한다.   
		 */
		double douNum = Math.random();
		douNum *= 50;
		
		/*
		 * 정수형 intNum 변수를 선언하고 
		 * douNum 변수의 값을 정수형으로 변환한 후
		 * 결과 값으로 intNum 변수를 초기화 하였다.
		 */
		int intNum = (int)(douNum);
		intNum += 51;
		
		/*
		 * int type(정수형) rndNum 변수를 선언하고
		 * 51 ~ 100까지 임의로 생성된 랜덤수로
		 * rndNum 변수를 초기화 하였다.
		 */
		int rndNum = (int)(Math.random()*50)+51; 
		
		// rndNum 변수에 저장된 값을 읽어서
		//Console 에 출력하라
		System.out.println(rndNum);
	}
}
