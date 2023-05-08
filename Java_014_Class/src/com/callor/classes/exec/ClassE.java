package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

public class ClassE {
	public static void main(String[] args) {
		
		// Generic type <> 로 감싸진 클래스
		// numList 에 추가할 수 있는 데이터는 정수만 가능하다
		// Generic type은 primitive type은 사용할 수 없다.
		// 반드시 클래스(Wrapper class, data class)만 사용할 수 있다.
		
		// List<int> numList1 = new ArrayList<>();
		// numlist 에는 정수값만 추가할 수 있는 규칙 부여
		List<Integer> numList = new ArrayList<>();
		
		System.out.println(numList.size());
		
		// List type의 변수에 item 추가하기
		numList.add(10);
		numList.add(20);
		numList.add(30);
		numList.add(40);
		numList.add(50);
		
		
		System.out.println(numList.size());
		
		// index 3 위치에 100의 값을 추가하기
		numList.add(3,100);
		numList.add(3,200);
		
		for (int i = 0; i< numList.size();i++) {
			System.out.print(numList.get(i) + "\t");
		}
		
		
		
	}
}
