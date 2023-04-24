package com.callor.classes.exec;

import com.callor.classes.exec.module.MyClassC;
/*
 *  51~100 범위의 랜덤수(난수)를 100개 생성
 *  MyClassC 의 prime() method 에 전달하고, 
 *  호출한 후 return 한 결과를 확인하여, 
 *  소수의 개수가 몇 개인지 Console에 출력
 */

public class ExecI {
	public static void main(String[] args) {
		
		MyClassC myC = new MyClassC(); // MyClassC 객체 myC 생성
		int count = 0;	// 소수의 개수를 셀 변수 count 선언
		
		for (int i = 0; i <100; i++) {	// 100번 반복
			int rndNum = (int)(Math.random()*50)+51;	// 51~100 사이의 난수 생성
			int result = myC.prime(rndNum); // MyClassC의 객체 myC의 
			if(result > 0) {
				count++;
			}
		}
		System.out.println("소수의 개수 : " + count + "개");
	}
}


