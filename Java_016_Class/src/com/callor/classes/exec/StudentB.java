package com.callor.classes.exec;

import com.callor.classes.models.StdData;

public class StudentB {

	public static void main(String[] args) {

		for (int i = 0; i < StdData.STUDENT.length; i++) {
			
			String[] std = StdData.STUDENT[i].split(",");
			
			System.out.print(std[StdData.ST_NUM] + "\t");
			System.out.print(std[StdData.ST_NAME] + "\t");
			System.out.print(std[StdData.ST_DEPT] + "\t");
			System.out.print(std[StdData.ST_GRADE] + "\t");
			System.out.print(std[StdData.ST_TEL] + "\t");
			System.out.print(std[StdData.ST_ADDRESS] + "\n");
			
			
			
		}

	}
}
