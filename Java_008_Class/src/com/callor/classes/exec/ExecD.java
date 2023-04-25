package com.callor.classes.exec;

public class ExecD {
	public static void main(String[] args) {
		int student1 = 50;
		int student2 = 60;
		int student3 = 70;
		int student4 = 80;
		int student5 = 91;
		
		int total = student1 + student2 + student3 +student4 + student5;
		float avg = (float)total/5;
		
		System.out.println("국어점수 합계 : "+ total);
		System.out.println("국어점수 평균 : "+ avg);
	}

}
