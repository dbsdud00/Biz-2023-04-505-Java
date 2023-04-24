package com.callor.classes.exec;

import com.callor.classes.exec.module.ServiceC;

public class ExecL {
	public static void main(String[] args) {
		int rndNum = (int) (Math.random() * 10);
		ServiceC sc = new ServiceC();
		// num1 변수에 저장된 값을 전달하면서
		// 구구단을 출력해줘 라는 요청
		// guguDan method 호출
		if (rndNum >= 2 && rndNum <= 9) {

			sc.guguDan(rndNum);
		} else {
			System.out.println("구구단이 아니야");
		}
	}
}
