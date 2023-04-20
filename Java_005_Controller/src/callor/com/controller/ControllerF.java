package callor.com.controller;

public class ControllerF {
/*
 *  prime() method의 코드를 수정하여
 *  생성된 랜덤 수가 소수인지 아닌지 판별하는 코드로 변경하시오
 *  
 *  void type 의 prime() method를 
 *  boolean type 의 prime() method로 변경
 *  
 *  method를 선언할 때 void type이외의 type으로 선언하면
 *  method {} 내에서 반드시 return 명령문이 있어야 한다.
 */
	public static boolean prime () { // boolean type의 prime method // void가 아닌 경우에는 return문이 필수이다.
		int isPrime = (int) (Math.random() * 50) + 51;
		int index;
		for (index = 2; index < isPrime; index++) {
			if (isPrime % index == 0) {
//				break;
				return false;  // 소수가 아니면 false를 강제로 return함 
			}
		}
		boolean yesPrime = isPrime <= index; // isPrime의 값이 index보다 작거나 같으면(= 소수이면) yesPrime에 true을 저장, 소수가 아니면 false를 저장 
		
		return yesPrime; // method와 같은 자료형 타입의 변수(boolean)만 리턴 가능
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			// prime() method의 {} 내의 코드를 실행해달라
			// prime() method 를 '호출한다' 라고 표현
			if( prime() ) {
				System.out.println("소수");
			}
			else { 
				System.err.println("소수 아님");
			}
		}
	}
}
