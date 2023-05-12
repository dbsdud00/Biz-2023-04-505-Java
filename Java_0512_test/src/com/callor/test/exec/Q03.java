package com.callor.test.exec;

import java.util.ArrayList;
import java.util.List;

public class Q03 {
	
	public static int isPrime(int num) {
		for (int i = 2; i< num; i++) {
			if (num%i == 0) {
				return 0;
			}
		}
		return num;
	}
	
	
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();
		int rndNum = 0;
		int primeCount = 0;
		int primeSum = 0;
		for (int i = 0; i< 30; i++) {
			rndNum = (int)(Math.random()*50)+51;
			numList.add(rndNum);
			
		}
		for (int i = 0; i<numList.size();i++) {
			int vfNum = numList.get(i);
			if (isPrime(vfNum)>0) {
				primeCount++;
				primeSum += vfNum;
//				System.out.println(vfNum);
			}
		}
		System.out.println("소수 개수 : " + primeCount );
		System.out.println("소수의 합 : " + primeSum);
	}
}
