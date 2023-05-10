package com.callor.classes.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.callor.classes.config.Line;
import com.callor.classes.datas.DataIndex;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;

// 1. loadStudent() method student.csv 파일에서 데이터를 load(Read) 하여 stdList 데이터로 변환
// 2. printStudent() method 를 실행하여 학생 정보 출력


public class StudentServiceImplV2 implements StudentService {
	List<StudentDto> stdList;
	public StudentServiceImplV2() {
		// TODO Auto-generated constructor stub
		stdList = new ArrayList<>();
	}
	@Override
	public void loadStudent() {
		// TODO Auto-generated method stub
		
		String studentFile = "src/com/callor/classes/datas/student.csv";
		String saveFile = "src/com/callor/classes/datas/student-save.csv";

		Scanner fileScan = null;
		
		InputStream is = null;
		
		try {
			is = new FileInputStream(studentFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		StudentDto stdDto;
		
		
		fileScan = new Scanner(is); 
		while(fileScan.hasNext()) {	// hasNext() : 다음에 읽을 데이터가 있니? 있으면 읽고 없으면 끝내라
			stdDto = new StudentDto();
			String[] str = fileScan.nextLine().split(",");
			stdDto.stNum = str[DataIndex.STUDENT.ST_NUM];
			stdDto.stName = str[DataIndex.STUDENT.ST_NAME];
			stdDto.stDept = str[DataIndex.STUDENT.ST_DEPT];
			stdDto.stGrade = Integer.valueOf(str[DataIndex.STUDENT.ST_GRADE]);
			stdDto.stTel = str[DataIndex.STUDENT.ST_TEL];
			stdDto.stAddress = str[DataIndex.STUDENT.ST_ADDRESS];

			
			stdList.add(stdDto);
		}
//		System.out.println(stdList);
		fileScan.close();
	}

	@Override
	public void printStudent() {
		// TODO Auto-generated method stub
		System.out.println(Line.dLine(130));
		System.out.println("학번\t이름    \t학과\t\t\t학년\t전화번호\t주소");
		System.out.println(Line.sLine(130));
		int i = 1;
		for (StudentDto stdDto : stdList) {
			System.out.printf("%s\t", stdDto.stNum);
			System.out.printf("%5s\t", stdDto.stName);
			System.out.printf("%s\t\t", stdDto.stDept);
			System.out.printf("%d\t", stdDto.stGrade);
			System.out.printf("%s\t", stdDto.stTel);
			System.out.printf("%s\n", stdDto.stAddress);
			if (i%5 == 0) {
				System.out.println(Line.sLine(130));
			}
			i++;
		}
		System.out.println(Line.dLine(130));
	}

	@Override
	public StudentDto getStudent(String stNum) {
		// TODO Auto-generated method stub
//		for (StudentDto stdDto : stdList) {
//			if (stdDto.stNum.equals(stNum)) {
//				return stdDto;
//			}
//		}
//		return null;
//		System.out.println(stdList);
		
		System.out.println(stNum);
		for(StudentDto dto : stdList) {
			
			if (dto.stNum.equals(stNum)) {
				System.out.println("맞음");
				return dto;
			} else {
				System.out.print(dto.stNum + "\t");
			}
		}
		return null;
	}
	
}
