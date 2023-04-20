package callor.com.controller;

public class ControllerI {


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

	public static boolean prime() {
		int rndNum = (int) (Math.random() * 50) + 51;
		return prime(rndNum);
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
