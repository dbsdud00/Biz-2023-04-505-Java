package com.callor.classes.exec;

import com.callor.classes.models.StdData;

public class ExecE {
	public static void main(String[] args) {
		
		// StdData 클래스의 Student 변수는 Static 키워드로 선언되어 있기 때문에
		// 객체를 생성하여 객체를 통해 접근하지 않아도 된다.
		// 대신 클래스를 통해 Dot(.) 연산자로 변수에 직접 접근이 가능하다.
		StdData stdData = new StdData();
		System.out.println(stdData.STUDENT);
		
		// 10명 학생 데이터를 각 요소에 저장한 문자열 배열 STUDENT 선언
		// static : 클래스를 통해서 직접 접근 가능한 변수가 된다.
		// final : 이 배열의 데이터는 아무도 수정하지 못한다.
		for(int i = 0; i < StdData.STUDENT.length; i++) {
			System.out.println(StdData.STUDENT[i]);
		}
		
		// StdData 클래스에 정의된 STUDENT 변수(Field)는 final 키워드가
		// 선언되어 있다. 따라서 STUDENT 변수는 다시 재 정의 할 수 없다.
		// StdData.STUDENT = new String[10];
		
		String[] str = new String[10];
		str = new String[20];
		str = new String[30];
		
		
		
	}
}
