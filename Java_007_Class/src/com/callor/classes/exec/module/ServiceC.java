package com.callor.classes.exec.module;

public class ServiceC {
	public void guguDan(int num) {
		System.out.println("============");
		System.out.println(num + "단 구구단");
		System.out.println("------------");
		for (int i = 0; i < 9; i++) {
			System.out.printf("%d X %d = %d\n", num, i + 1, num * (i + 1));
		}
	}
}
