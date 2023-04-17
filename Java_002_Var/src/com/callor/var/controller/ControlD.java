package com.callor.var.controller;

public class ControlD {
	public static void main(String[] args) {
		int intRnd = (int)(Math.random()*10);
		if (intRnd % 2 == 0) {
			System.out.println(intRnd + " : 짝수");
		}
		if (intRnd % 2 != 0) {
			System.err.println(intRnd + " : 짝수가 아님");
		}
		if (intRnd % 2 == 1) {
			System.out.println(intRnd + " : 홀수");
		}
		if (intRnd % 2 != 1) {
			System.err.println(intRnd + " : 홀수가 아님");
		}
		
	}
}
