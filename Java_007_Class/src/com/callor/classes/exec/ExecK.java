package com.callor.classes.exec;

import com.callor.classes.exec.module.ServiceB;

/*
 *  학생이름, 국어, 영어, 수학 점수를 저장할 변수 선언
 *  학생이름 : 홍길동
 *  과목 점수 : 51 ~ 100 범위의 랜덤 수
 *  ServiceB 클래스에 scorePrint() method를 생성하여 
 *  학생이름, 각 과목점수를 매개변수로 값을 받아 다음과 같이 출력
 *  ======================================
 *  이름	국어 영어 수학  총점  평균
 *  --------------------------------------
 *  홍길동	 66   67   99   232   77.3
 *  ======================================
 */

public class ExecK {
	public static void main(String[] args) {
		String name = "홍길동";
		int intKor = (int) (Math.random() * 50) + 51;
		int intEng = (int) (Math.random() * 50) + 51;
		int intMath = (int) (Math.random() * 50) + 51;

		ServiceB sb = new ServiceB();
		sb.scorePrint(name, intKor, intEng, intMath);

	}
}
