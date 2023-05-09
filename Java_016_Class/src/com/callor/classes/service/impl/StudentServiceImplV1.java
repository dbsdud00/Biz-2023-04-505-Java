package com.callor.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.models.StdData;
import com.callor.classes.models.StudentDto;

public class StudentServiceImplV1 implements StudentService {

	private List<StudentDto> stdList; 
	@Override
	public void loadStudent() {
		// TODO Auto-generated method stub
		stdList = new ArrayList<>();
		StudentDto stdDto;
		
		for (int i = 0; i < StdData.STUDENT.length; i++) {
			
			String[] std = StdData.STUDENT[i].split(",");
			
			stdDto = new StudentDto();
			
			stdDto.stNum = std[StdData.ST_NUM];
			stdDto.stName = std[StdData.ST_NAME];
			stdDto.stDept = std[StdData.ST_DEPT];
			stdDto.stGrade = Integer.valueOf(std[StdData.ST_GRADE]);
			stdDto.stProf = std[StdData.ST_PROF];
			stdDto.stTel = std[StdData.ST_TEL];
			stdDto.stAddress = std[StdData.ST_ADDRESS];
			
			stdList.add(stdDto);

		}
	}

	@Override
	public void printStudent() {
		// TODO Auto-generated method stub
		System.out.println("=".repeat(120));
		System.out.println("학번\t이름\t\t학과\t\t학년\t     교수\t전화번호\t주소");
		System.out.println("-".repeat(120));
		for (int i = 0; i< StdData.STUDENT.length;i++) {
			System.out.printf("%s\t", stdList.get(i).stNum);
			System.out.printf("%3s\t\t", stdList.get(i).stName);
			System.out.printf("%s\t", stdList.get(i).stDept);
			System.out.printf("%2d\t", stdList.get(i).stGrade);
			System.out.printf("%7s\t", stdList.get(i).stProf);
			System.out.printf("%13s\t", stdList.get(i).stTel);
			System.out.printf("%5s\n", stdList.get(i).stAddress);
			
		}
		System.out.println("=".repeat(120));
	}

	@Override
	public StudentDto getStudent(String stNum) {
		// TODO Auto-generated method stub
		for(StudentDto std : stdList) {
			if (std.stNum.equals(stNum)) {
				return std;
			}
		}
		System.out.println("없어요");
		
		return null;
	}

}
