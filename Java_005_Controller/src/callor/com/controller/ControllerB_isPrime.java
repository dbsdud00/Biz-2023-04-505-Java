package callor.com.controller;

public class ControllerB_isPrime {
	public static void main(String[] args) {
		int isPrime = (int) (Math.random() * 50) + 51;
		System.out.println(isPrime);

		int primeCount = 0;
		for (int i = 2; i < isPrime; i++) {
			if (isPrime % i == 0) {
//				System.out.println(isPrime + " 소수가 아님");
				primeCount++;
				break;
			}
		}
		if (primeCount > 0) {
			System.out.println(isPrime + " 는 소수가 아님");
		} else {
			System.out.println(isPrime + "는 소수");
		}
		if (primeCount == 0) {
			System.out.println(isPrime + "는 소수");
		} else {
			System.out.println(isPrime + "는 소수가 아님");
		}

//------------------------------------------------------------

		for (int j = 2; j < (isPrime / 2); j++) {
			if (isPrime % j != 0) {
				if (j == (isPrime / 2) - 1) {
					System.out.println("소수2");
				}
			} else {
				System.out.println("소수아님2");
				break;
			}
		}
//-------------------------------------------------------------

		boolean wP = true;
		for (int k = 2; k < isPrime; k++) {
			if (isPrime % k == 0) {
				wP = false;
				break;
			}
		}
		if (wP) {
			System.out.println("소수임3");
		} else {
			System.out.println("소수아님3");
		}
	}
}
