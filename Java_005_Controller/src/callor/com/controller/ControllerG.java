package callor.com.controller;

public class ControllerG {
	/*
	 *  prime() method {} 내에서 선언했던 rndNum 변수를
	 *  매개변수(parameter)로 변경하기
	 *  매개변수는 스스로 초기화 할 수 없다.
	 *  누군가 prime() method를 호출하면서
	 *  값을 전달해주어야만 그 값으로 초기화 할 수 있다.
	 *  prime(int rndNum = 0) 과 같은 코드 사용 불가
	 *  
	 *  main() 에서 prime(55) 와 같은 코드가 실행 될 때 매개변수 값이 초기화 된다.
	 *  
	 */
	public static boolean prime (int isPrime) { 
//		int isPrime = (int) (Math.random() * 50) + 51; // prime함수 내에서 선언된 isPrime은 main에서 사용할 수 없다.
		int index;
		for (index = 2; index < isPrime; index++) {
			if (isPrime % index == 0) {
				break;
//				return false;  
			}
		}
		boolean yesPrime = isPrime <= index; 
		
		return yesPrime; 
		
	}
	
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			// main 에서 랜덤 수를 만들고
			int mainRndNum = (int) (Math.random() * 50) + 51;
			
			// prime() 에게 "전달해 주기"
			// prime() 에게 mainRndNum 변수에 저장된 값을 "전댤해 주기"
			// 이때 mainRndNum를 argument (전달자) 라고 한다. 인수, 인자
			if( prime( mainRndNum ) ) {
				System.out.println(mainRndNum + "소수");
			}
			else { 
				System.err.println(mainRndNum + "소수 아님");
			}
		}
	}
}
