package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

public class NumersD {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();  // 1,2
		
		for (int i = 0; i < 45; i++) {
			numList.add(i+1);
		}
		System.out.println(numList);
		
		// List shuffle 하기
		for (int i = 0; i< 1000;i++ ) {
			
			int num1 = (int)(Math.random()* numList.size());
			int num2 = (int)(Math.random()* numList.size());
			
			int tmp = numList.get(num1);
			numList.set(num1, numList.get(num2));
			numList.set(num2, tmp);
					
		}
		System.out.println(numList);
		System.out.println();
		for (int i = 0; i< 5 ; i++) {
			System.out.printf("%2d\t",numList.get(i));
			
		}
		
	}
}
