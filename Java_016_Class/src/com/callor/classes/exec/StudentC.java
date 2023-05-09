package com.callor.classes.exec;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.StdData;
import com.callor.classes.models.StudentDto;

public class StudentC {
	public static void main(String[] args) {
		
		List<StudentDto> stdList = new ArrayList<>();
		StudentDto stdDto;
		
		for (int i = 0; i < StdData.STUDENT.length; i++) {
			
			String[] std = StdData.STUDENT[i].split(",");
			
			stdDto = new StudentDto();
			
			stdDto.stNum = std[StdData.ST_NUM];
			stdDto.stName = std[StdData.ST_NAME];
			stdDto.stDept = std[StdData.ST_DEPT];
			stdDto.stGrade = Integer.valueOf(std[StdData.ST_GRADE]);
			stdDto.stTel = std[StdData.ST_TEL];
			stdDto.stAddress = std[StdData.ST_ADDRESS];
			
			stdList.add(stdDto);

		}

		System.out.println(stdList);

	}
}
