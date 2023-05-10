package com.callor.classes.service.impl;

import java.util.ArrayList;

public class ScoreServiceImplV2 extends ScoreServiceImplV1 {
	public ScoreServiceImplV2() {
		// V1에서 protected로 선언된 scList 를 사용할 수 있도록 
		// 초기화 하는 작업. 반드시 필요
		scList = new ArrayList<>();
	}
	
}
