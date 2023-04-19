package com.callor.controller;

public class ControllerA {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int intRnd = (int) (Math.random() * 50) + 51;

			if (intRnd >= 51 && intRnd <= 100) {
				System.out.print(intRnd + "\t");
			} else {
				System.err.print(intRnd + "\t");
			}
			if ((i + 1) % 5 == 0) {
				System.out.println();
				System.out.println();
			}
		}
	}
}
