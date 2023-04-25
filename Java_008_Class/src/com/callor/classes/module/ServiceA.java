package com.callor.classes.module;

public class ServiceA {
	public void score(int kor, int eng,int mat, int his, int mus, int art, int phy) {
		int total = kor+ eng+ mat+  his+  mus+  art+  phy;
		float avg = (float)total / 7;
		
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + mat);
		System.out.println("국사 : " + his);
		System.out.println("음악 : " + mus);
		System.out.println("미술 : " + art);
		System.out.println("체육 : " + phy);
		System.out.println("총점 : " + total);
		System.out.printf("평균 : %2.1f", avg);
		
		
		
	}
}
