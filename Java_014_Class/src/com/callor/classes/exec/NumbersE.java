package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumbersE {
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<>();  // 1,2
		
		for (int i = 0; i < 45; i++) {
			numList.add(i+1);
		}
		
		/*
		 *  List type의 데이터를 shuffle 하기 위한 도구
		 */
		Collections.shuffle(numList);
		
		List<Integer> lottos = new ArrayList<>();
		for (int i = 0; i < 5 ; i++) {
//			System.out.println(numList.get(i));
			lottos.add(numList.get(i));
		}
		System.out.println(lottos);
		Collections.sort(lottos);
		System.out.println(lottos);
	}
}
