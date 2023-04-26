package com.callor.classes.arrays;

import com.callor.classes.model.ScoreDto;

public class ArrayA {
	public static void main(String[] args) {
		ScoreDto 홍길동 = new ScoreDto();
		ScoreDto 이몽룡 = new ScoreDto();
		ScoreDto 성춘향 = new ScoreDto();
		
		홍길동.stName = "홍길동";
		홍길동.stNum = "0001";
		홍길동.scKor = 87;
		홍길동.scEng = 96;
		홍길동.scMath = 83;
		
		이몽룡.stName = "이몽룡";
		이몽룡.stNum = "0002";
		이몽룡.scKor = 81;
		이몽룡.scEng = 64;
		이몽룡.scMath = 98;
		
		성춘향.stName = "성춘향";
		성춘향.stNum = "0003";
		성춘향.scKor = 81;
		성춘향.scEng = 92;
		성춘향.scMath = 87;
		System.out.println("=".repeat(72));
		
		System.out.println("학번\t이름\t\t국어\t영어\t수학\t\t총점\t평균");
		System.out.println("------------------------------------------------------------------------");
		System.out.printf("%s\t%s\t\t%3d\t%3d\t%3d\t\t%3d\t%5.1f\n",홍길동.stNum,홍길동.stName,홍길동.scKor,홍길동.scEng,홍길동.scMath,홍길동.getTotal(),홍길동.getAvg());
		System.out.printf("%s\t%s\t\t%3d\t%3d\t%3d\t\t%3d\t%5.1f\n",이몽룡.stNum,이몽룡.stName,이몽룡.scKor,이몽룡.scEng,이몽룡.scMath,이몽룡.getTotal(),이몽룡.getAvg());
		System.out.printf("%s\t%s\t\t%3d\t%3d\t%3d\t\t%3d\t%5.1f\n",성춘향.stNum,성춘향.stName,성춘향.scKor,성춘향.scEng,성춘향.scMath,성춘향.getTotal(),성춘향.getAvg());
		System.out.println("=".repeat(72));
		
		
		
	}
}
