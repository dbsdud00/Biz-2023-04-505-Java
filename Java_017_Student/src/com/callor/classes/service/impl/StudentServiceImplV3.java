package com.callor.classes.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.classes.config.Line;
import com.callor.classes.datas.DataIndex;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;

/*
 *  StudentServiceImplV1은 StudentService interface 를 implements 하였고
 *  StudentServiceImplV3는 StudentServiceImplV1을 extends 하였다.
 */

public class StudentServiceImplV3 implements StudentService {
	
	protected List<StudentDto> stdList;
public StudentServiceImplV3() {
	// TODO Auto-generated constructor stub
	stdList = new ArrayList<>();
}
	@Override
	public void loadStudent() {
		// TODO Auto-generated method stub
		String studentFile = "src/com/callor/classes/datas/student.csv";
		
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(studentFile);
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println(studentFile + "이 없습니다");
			return;
		}
		scan = new Scanner(is);
		while(scan.hasNext()) {
			String line = scan.nextLine(); // 한줄 씩 파일에서 읽어 line에 저장
			String[] student = line.split(",");
			
			StudentDto stDto = new StudentDto();
			stDto.stNum = student[DataIndex.STUDENT.ST_NUM];
			stDto.stName = student[DataIndex.STUDENT.ST_NAME];
			stDto.stDept = student[DataIndex.STUDENT.ST_DEPT];
			stDto.stGrade = Integer.valueOf(student[DataIndex.STUDENT.ST_GRADE]);
			stDto.stTel = student[DataIndex.STUDENT.ST_TEL];
			stDto.stAddress = student[DataIndex.STUDENT.ST_ADDRESS];
			stdList.add(stDto);
		}
		scan.close(); // 닫아주어야 한다.
	}

	@Override
	public void printStudent() {
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
			if (i%5 == 0 && i < stdList.size()) {	// 5줄마다 구분선 출력하는데 맨 마지막엔 출력 안하기
				System.out.println(Line.sLine(130));
			}
			i++;
		}
		System.out.println(Line.dLine(130));
		
	}

	@Override
	public StudentDto getStudent(String stNum) {
		// TODO Auto-generated method stub
		for(StudentDto dto : stdList) {
			if (dto.stNum.equals(stNum)) {
				return dto;
			}
		}
		return null;
	}
	
}

