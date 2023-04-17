package com.callor.var;

public class VarI {
	public static void main(String[] args) {
		int dan = 5;
		int index = 1;
		
		System.out.printf("%d X %d = %d\n", dan, index, dan * index++);
		System.out.printf("%d X %d = %d\n", dan, index, dan * index++);
		System.out.printf("%d X %d = %d\n", dan, index, dan * index++);
		System.out.printf("%d X %d = %d\n", dan, index, dan * index++);
		System.out.printf("%d X %d = %d\n", dan, index, dan * index++);
		System.out.printf("%d X %d = %d\n", dan, index, dan * index++);
		System.out.printf("%d X %d = %d\n", dan, index, dan * index++);
		System.out.printf("%d X %d = %d\n", dan, index, dan * index++);
		System.out.printf("%d X %d = %d\n", dan, index, dan * index++);
		
		int result = index + 1;
		index++;
		
	}
}
