package com.callor.classes.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.callor.classes.config.Line;
import com.callor.classes.datas.DataIndex;
import com.callor.classes.models.ScoreDto;
import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;

public class ScoreServiceImplV2 extends ScoreServiceImplV1 {
	public ScoreServiceImplV2() {
		// V1에서 protected로 선언된 scList 를 사용할 수 있도록 
		// 초기화 하는 작업. 반드시 필요
		scList = new ArrayList<>();
		
	}
	@Override
	public void loadScore() {
		String studentFile = "src/com/callor/classes/datas/score.csv";
		
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
			
			String line = scan.nextLine();
			String[] sc = line.split(",");
			
			ScoreDto scDto = str2Dto(line);
			
			scList.add(scDto);
		}
	}
	
	@Override
	public void printScore() {
		StudentService stV1 = new StudentServiceImplV3();
		
		stV1.loadStudent();
		
		System.out.println(Line.dLine(100));
		System.out.println("학번\t이름\t학과\t\t\t국어\t영어\t수학\t음악\t미술\t총점\t평균");
		System.out.println(Line.sLine(100));
		int i = 0;
		for(ScoreDto dto : scList) {
			
			// 학번을 StudentServiceImplV1.getStudent() method 에게 전달하고
			// 학번에 해당하는 학생 데이터를 return 받아서
			// StudentDto type의 객체에 저장하기
			StudentDto stDto = stV1.getStudent(dto.getStNum());
			
			System.out.printf("%s\t",dto.getStNum());
			
			if (stDto != null) {
				System.out.printf("%3s\t", stDto.stName.substring(0,3));
				System.out.printf("%s\t\t", stDto.stDept);
				
			} else {
				System.out.printf(" -\t");
				System.out.printf(" -\t\t");				
			}
			
			
			int scTotal = dto.getScKor();
			scTotal += dto.getScEng();
			scTotal += dto.getScMath();
			scTotal += dto.getScMusic();
			scTotal += dto.getScArt();
			
			System.out.printf("%3d\t",dto.getScKor());
			System.out.printf("%3d\t",dto.getScEng());
			System.out.printf("%3d\t",dto.getScMath());
			System.out.printf("%3d\t",dto.getScMusic());
			System.out.printf("%3d\t",dto.getScArt());
			System.out.printf("%3d\t",scTotal);
			System.out.printf("%5.2f\n",(float)scTotal/5);
			if ( ++i %5 == 0 && i < scList.size()) {
				System.out.println(Line.sLine(100));
			}
		}
		System.out.println(Line.dLine(100));
	}
}
