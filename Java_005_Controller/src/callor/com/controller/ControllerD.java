package callor.com.controller;

public class ControllerD {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int isPrime = (int) (Math.random() * 50) + 51;
			int index;
			for (index = 2; index < isPrime; index++) {
				if (isPrime % index == 0) { // 소수가 아니면 for문을 빠져나옴
					break;
				}
			}
			if (index >= isPrime) { // for문을 빠져나왔을 때의 index 값이 isPrime보다 크거나 같으면 
									// for문을 다 돌고도 나머지가 0으로 나눠지는 수를 찾지 못했다는 의미 == 소수임
				System.err.println("\t\t\t" + isPrime + "은(는) 소수임");
			} else { // index값이 isPrime보다 작으면 중간에 빠져나왔다는 의미로 
					// 나머지가 0으로 나눠지는 값이 있다는 의미 == 소수아님
//				System.out.println(isPrime + "은(는) 소수아님");
			}
		}
	}
}
