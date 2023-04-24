package com.callor.classes.exec.module;

public class ServiceF {
	public void score(int intKor,int intEng, int intMath,int intHis,int intMusic,int intart,int intphy) {
		int total = intKor+ intEng+ intMath+intHis+intMusic+intart+intphy;
		float avg = (float)total/7;
		System.out.println("총점 : "+ total);
		System.out.printf("평균 : %2.1f",avg);
	}
}
