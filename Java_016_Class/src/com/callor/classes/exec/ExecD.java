package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.ScoreDto;
import com.callor.classes.service.ScoreServiceV2;

public class ExecD {
	public static void main(String[] args) {
		ScoreServiceV2 ex = new ScoreServiceV2();
		List<ScoreDto> scList = new ArrayList<>();
//		ex.makeScore(scList);
		ex.makeScore(scList);
		ex.makeScore();
		
		System.out.println(scList);
	}
}
