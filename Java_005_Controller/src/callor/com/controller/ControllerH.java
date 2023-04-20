package callor.com.controller;

public class ControllerH {

	/*
	 * 하나의 클래스 내에서는 메소드 이름이 중복될 수 없다.
	 * 하지만 매개변수가 달라지면 메소드 이름을 중복으로 사용할수 있다. -> 오버로딩
	 */
	public static boolean prime(int isPrime) {
		int index;
		for (index = 2; index < isPrime; index++) {
			if (isPrime % index == 0) {
				break;
			}
		}
		boolean yesPrime = isPrime <= index;
		return yesPrime;
	}
	// 자바에서는 method의 이름을 매개변수의 type으로 본다.
	// prime(int rndNum)는 prime(int) 라는 이름으로 선언되고
	// prime() 는 prime()라는 이름으로 선언된다.
	// 따라서 prime(int)와 prime()은 전혀 다른 method로 인식한다.
	// 이것을 Java 의 특성 중에 중복선언(OverLoding)이라고 한다.
	// 
	// 호출하는 곳에서 prime(30)과 같이 호출하면 prime(int)가 실행되고
	// prime() 과 같이 호출하면 prime()가 실행된다.
	public static boolean prime() {
		int isPrime = (int) (Math.random() * 50) + 51;
		int index;
		for (index = 2; index < isPrime; index++) {
			if (isPrime % index == 0) {
				break;
			}
		}
		boolean yesPrime = isPrime <= index;
		return yesPrime;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int mainRndNum = (int) (Math.random() * 50) + 51;

			if (prime(mainRndNum)) {
				System.out.println("\t\t\t" + mainRndNum + "소수");
			}
//			else { 
//				System.err.println(mainRndNum + "소수 아님");
//			}
			if (prime()) {
				System.out.println("소수");
			}
		}
	}
}
