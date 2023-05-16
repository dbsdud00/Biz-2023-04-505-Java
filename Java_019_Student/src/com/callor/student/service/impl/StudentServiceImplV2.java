package com.callor.student.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.callor.student.models.StudentDto;
import com.callor.student.utils.Config;
import com.callor.student.utils.Index;
import com.callor.student.utils.Line;

/*
 *  insertStudent, printStudent, loadStudent 모두 상속받는다.
 */

public class StudentServiceImplV2 extends StudentServiceImplV1{
	
	public void insertStudent() {
		
		String studentFile = "src/com/callor/student/student.txt";

		OutputStream os = null;
		
		try {
			os = new FileOutputStream(studentFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintWriter out = new PrintWriter(os);
		
		while(true) {
			
			System.out.println(Line.dLine(60));
			System.out.println("학생 정보 추가. 종료하려면 QUIT 입력");
			System.out.println(Line.sLine(60));
			
			System.out.print("학번 >> ");
			String stNum = scan.nextLine();
			if (stNum.equals("QUIT")) break;

			System.out.print("이름 >> ");
			String stName = scan.nextLine();
			if (stName.equals("QUIT")) break;
			
			System.out.print("학과 >> ");
			String stDept = scan.nextLine();
			if (stDept.equals("QUIT")) 	break;
			
			int intStGrade = 0;
			while(true) {
				
				System.out.print("학년 >> ");
				String stGrade = scan.nextLine();
				if (stGrade.equals("QUIT")) {
					System.out.println("학생 정보 입력 종료");
					break;
				}
				try {
					intStGrade = Integer.valueOf(stGrade);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("학년은 정수형으로 입력해 주세요");
					continue;
				}
				if (intStGrade < 1 || intStGrade > 4) {
					System.out.println("1 ~ 4 범위의 수를 입력하세요");
					continue;
				}
				break;
				
			}
			
			if (intStGrade == 0) break;
			
			
			System.out.print("전화번호 >> ");
			String stTel = scan.nextLine();
			
			if (stTel.equals("QUIT")) break;
			
			out.print(stNum +",");
			out.print(stName + ",");
			out.print(stDept + ",");
			out.print(intStGrade + ",");
			out.println(stTel);
			
			
//			StudentDto stdDto = new StudentDto();
//			stdDto.stNum = stNum;
//			stdDto.stName = stName;
//			stdDto.stDept = stDept;
//			stdDto.stGrade = intStGrade;
//			stdDto.stTel = stTel;
//			
//			stdList.add(stdDto);
//			out.println(stdDto.toString());
			

		}
		out.close();
	}
	
	
	
	@Override
	public void loadStudent() {
		// TODO Auto-generated method stub
		super.loadStudent();
		
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(Config.STUDENT_FILE);

			
			System.out.println("loadStudent 출력");
			System.out.println(stdList);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scan = new Scanner(is);
		
		int rows = 0;
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] str = line.split(",");
			rows++;
			try {
				
				String stNum = str[Index.STUDENT.ST_NUM]; 
				String stName = str[Index.STUDENT.ST_NAME];
				String stDept = str[Index.STUDENT.ST_DEPT];
				int stGrade = Integer.valueOf(str[Index.STUDENT.ST_GRADE]);
				String stTel = str[Index.STUDENT.ST_TEL];
				
				StudentDto stDto = new StudentDto();
				stDto.stNum = stNum;
				stDto.stName = stName;
				stDto.stDept = stDept;
				stDto.stGrade = stGrade;
				stDto.stTel = stTel;
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(rows + " 라인에서 Exception 발생");
			}

		}
		
		System.out.println("Load 한 데이터 개수 : " + stdList.size());
		
		scan.close();

	}
	
}
