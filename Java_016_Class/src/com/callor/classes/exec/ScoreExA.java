package com.callor.classes.exec;

import com.callor.classes.service.ScoreService;
import com.callor.classes.service.impl.ScoreServiceImplV3;
import com.callor.classes.service.impl.StudentService;
import com.callor.classes.service.impl.StudentServiceImplV1;

public class ScoreExA {
	public static void main(String[] args) {
		ScoreService scService = new ScoreServiceImplV3();
		scService.makeScore();

		scService.printScore();
	}
}
