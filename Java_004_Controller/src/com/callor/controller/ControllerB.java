package com.callor.controller;

public class ControllerB {
	public static void main(String[] args) {

		for (int i = 0;i<100;i++) {
			int intRnd = (int)(Math.random()*50) + 51;
			if (intRnd % 2 == 0 ) {
				System.out.println(intRnd + " : 짝수");
			} 
//			else {
//				System.err.println(intRnd + ": 짝수아님");
//			}
			else if (intRnd % 2 == 1) {
				System.err.println(intRnd + " : 홀수");
			}
			
		}
	}
}
