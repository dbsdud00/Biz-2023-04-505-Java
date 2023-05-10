package com.callor.classes.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.callor.classes.config.Line;
import com.callor.classes.datas.DataIndex;
import com.callor.classes.datas.DataSource;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;

public class StudentServiceImplV1 implements StudentService {

	// 클래스 영역에 필드 변수로 StudentDto List type으로
	// stdList 객체 선언
	protected List<StudentDto> stdList; // = new ArrayList<>();
	
	// stdList 객체는 Service 생성자에서 초기화 한다.
	public StudentServiceImplV1() {
		// 기본 생성자에서 객체를 초기화(사용할 수 있도록 생성)
		stdList = new ArrayList<>();
	}
	
	@Override
	public void loadStudent() {
		// TODO Auto-generated method stub
		StudentDto stdDto;
		// STUDENT 문자열 배열 데이터를 forEach(확장 for)를 
		// 분해하여 개별 문자열을 str에 담고 for() {} 에 전달하기
		for (String str : DataSource.STUDENT) {
			// str 문자열 변수에 저장된 문자열을 컴마(,)기준으로 다시 분해
			// student 배열에 저장하기
			String[] std = str.split(",");
			// StudentDto class type의 stdDto 객체를 생성하고
			// StudentDto type의 객체를 생성하고
			stdDto = new StudentDto();
			
			// student 배열의 각 요소를 StudentDto type 객체 요소(변수)에 저장하기
			stdDto.stNum = std[DataIndex.STUDENT.ST_NUM];
			stdDto.stName = std[DataIndex.STUDENT.ST_NAME];
			stdDto.stDept = std[DataIndex.STUDENT.ST_DEPT];
			stdDto.stGrade = Integer.valueOf(std[DataIndex.STUDENT.ST_GRADE]);
			stdDto.stProf = std[DataIndex.STUDENT.ST_PROF];
			stdDto.stTel = std[DataIndex.STUDENT.ST_TEL];
			stdDto.stAddress = std[DataIndex.STUDENT.ST_ADDRESS];
			
			// List<StudentDto> type 의 리스트에 추가하기
			stdList.add(stdDto);

		}
	}

	@Override
	public void printStudent() {
		// TODO Auto-generated method stub
		System.out.println(Line.dLine(120));
		System.out.println("학번\t이름\t\t학과\t\t학년\t     교수\t전화번호\t주소");
		System.out.println(Line.sLine(120));
		for (StudentDto dto : stdList) {
			System.out.printf("%s\t", dto.stNum);
			System.out.printf("%3s\t\t", dto.stName);
			System.out.printf("%s\t", dto.stDept);
			System.out.printf("%2d\t", dto.stGrade);
			System.out.printf("%7s\t", dto.stProf);
			System.out.printf("%13s\t", dto.stTel);
			System.out.printf("%5s\n", dto.stAddress);
		}
		System.out.println(Line.dLine(120));
	}
	
	/*
	 *  stdList 에서 stNum 학번의 학생 데이터를 찾아서 
	 *  학생 데이터를 return
	 */
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
