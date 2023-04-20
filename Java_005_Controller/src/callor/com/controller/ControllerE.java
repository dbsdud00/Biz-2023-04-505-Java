package callor.com.controller;

public class ControllerE {
	/*
	 *  method의 선언
	 *  method 는 마치 java의 명령문을 새로 만드는 것과 같아
	 *  method 선언 규칙에 따라 이름() {} 등을 만들고 
	 *  {} 내에 원하는 코드를 작성한다.
	 */
	public static void prime () {
		int isPrime = (int) (Math.random() * 50) + 51;
		int index;
		for (index = 2; index < isPrime; index++) {
			if (isPrime % index == 0) {
				break;
			}
		}
		if (index >= isPrime) {
			System.out.println("\t\t\t" + isPrime + "은(는) 소수임");
		} else {
//			System.out.println(isPrime + "은(는) 소수아님");
		}
		return ; // 생략된것과 같다 , 원래 나를 불렀던 곳으로 되돌아가라
	}
	
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			// prime() method의 {} 내의 코드를 실행해달라
			// prime() method 를 '호출한다' 라고 표현
			prime();
		}
	}
}
