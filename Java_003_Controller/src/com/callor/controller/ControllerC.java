package com.callor.controller;

public class ControllerC {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			if (i%2 == 1) {
				System.out.print(i + "\t");
			}
		}
		System.out.println();
		for (int i = 0; i < 20; i+=2) {
			// for() 내에서 index 값 변경하는 것은 가급적 사용하지 않는 것이 좋다.
			System.out.print(i+1 + "\t" );
		}

	}
}
