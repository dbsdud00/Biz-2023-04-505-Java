package com.callor.scanner.exec;

import com.callor.scanner.service.PrimeServiceV1;

public class ScannerC {
	public static void main(String[] args) {
		PrimeServiceV1 primeServiceV1 = new PrimeServiceV1();
		
		
		while (true) {
			
			int num = primeServiceV1.getNum();
			
			if(num < 0) {
				System.out.println("\nGAME OVER!");
				break;
			}
			int result = primeServiceV1.primeYesNo(num);
			if (result > 0 ) {
				System.out.println("소수");
			} else {
				System.out.println("소수 아님");
			}
			System.out.println();
			
		}
		
		
	}
}
