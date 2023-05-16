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

public class StudentServiceImplV2_1 extends StudentServiceImplV1{
	
	protected StudentDto inputStudent() {
		
		StudentDto stdDto = new StudentDto();
		
		System.out.println(Line.dLine(60));
		System.out.println("학생 정보 입력. 종료하려면 QUIT 입력");
		System.out.println(Line.sLine(60));
		
		// 학번 입력
		String stNum = "";
		while(true) {
			
			
			System.out.print("학번(정수) >> ");
			stNum = scan.nextLine();
			if (stNum.equals("QUIT")) return null;
			
			try {
				int intNum = Integer.valueOf(stNum);
				stNum = String.format("%04d", intNum);

				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("학번은 정수형으로 입력해 주세요");
				continue;
			}
			break;
		}
		
		if (stNum.equals("QUIT")) return null;
		

		for (StudentDto dto : stdList) {
			if (dto.stNum.equals(stNum)) {
//				System.out.println("동일 학번 학생 데이터 있음. 데이터 수정");
//				System.out.println(dto.toString());
//				
				// dto 의 어떤 데이터가 stdDto 에 저장될까??
				
				stdDto = dto;
			}
		}
		
		// 이름 입력
		System.out.printf("이름(%s) >> ",stdDto.stName == null ? "신규" : stdDto.stName);

		String stName = scan.nextLine();
		if (stName.equals("")) {
			stName = stdDto.stName;
		}
		if (stName.equals("QUIT")) return null;
		
		// 학과 입력
		System.out.printf("학과(%s) >> ", stdDto.stDept == null ? "신규" : stdDto.stDept);
		String stDept = scan.nextLine();
		if (stDept.equals("")) {
			stDept = stdDto.stDept;
		}
		if (stDept.equals("QUIT")) 	return null;
		
		
		// 학년 입력
		int intStGrade = 0;
		while(true) {
			
			System.out.printf("학년(%d) >> ",stdDto.stGrade == 0 ? "신규" : stdDto.stGrade);
			String stGrade = scan.nextLine();
			if (stGrade.equals("")) {
				intStGrade = stdDto.stGrade;
				break;
			}
			if (stGrade.equals("QUIT")) 	break;
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
		
		if (intStGrade == 0) return null;
		
		
		// 전화번호 입력
		System.out.printf("전화번호(%s) >> ",stdDto.stTel == null ? "신규" : stdDto.stTel);
		String stTel = scan.nextLine();
		if (stTel.equals("")) {
			stTel = stdDto.stTel;
		}
		
		if (stTel.equals("QUIT")) return null;

		
		// 리스트 추가
		stdDto.stNum = stNum;
		stdDto.stName = stName;
		stdDto.stDept = stDept;
		stdDto.stGrade = intStGrade;
		stdDto.stTel = stTel;
		
//		stdList.add(stdDto);
		
		return stdDto;
		
	}
	
	
	
	
			
	@Override
	public void insertStudent() {
		if (stdList.isEmpty()) {
			loadStudent();
		}
		// V2에서 상속받은 V1의 insertStudent() 를 먼저 
		// 실행해 달라
//		super.insertStudent();
		while(true) {
			StudentDto stDto = this.inputStudent();
			if (stDto == null) break;
			
			int index = 0;
			for (index = 0; index < stdList.size(); index++) {
				// inputStudent() 가 return 한 dto 하고
				// stdList 의 요소중에서 참조한 dto 하고
				// 주소가 일치하냐?
				// 주소가 일치하다 ==> stdList 에 있는 요소이다.
				if (stdList.get(index) == stDto) {
					break;
				}
			}
			if (index >= stdList.size()) {
				stdList.add(stDto);
			}
		}
		
		// 그리고 나머지는 내가 처리할께
		System.out.println("여기는 V2");
		OutputStream os = null;
		PrintWriter out = null;
		try {
			os = new FileOutputStream(Config.STUDENT_FILE);
			out = new PrintWriter(os);
			
			for (StudentDto dto : stdList) {
				out.printf("%s,",dto.stNum);
				out.printf("%s,",dto.stName);
				out.printf("%s,",dto.stDept);
				out.printf("%d,",dto.stGrade);
				out.printf("%s\n",dto.stTel);
			}
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printStudent();
		
		
	}
	
	
	@Override
	public void printStudent() {
		// TODO Auto-generated method stub
		if (stdList.isEmpty()) {
			
			loadStudent();
		}
		super.printStudent();
	}
	
	
	@Override
	public void loadStudent() {
		
		InputStream is = null;
		Scanner scan = null;
		
		try {
			
			is = new FileInputStream(Config.STUDENT_FILE);

			
			
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
			StudentDto stDto = new StudentDto();
			try {
				
				String stNum = str[Index.STUDENT.ST_NUM]; 
				String stName = str[Index.STUDENT.ST_NAME];
				String stDept = str[Index.STUDENT.ST_DEPT];
				int stGrade = Integer.valueOf(str[Index.STUDENT.ST_GRADE]);
				String stTel = str[Index.STUDENT.ST_TEL];
				
				
				stDto.stNum = stNum;
				stDto.stName = stName;
				stDto.stDept = stDept;
				stDto.stGrade = stGrade;
				stDto.stTel = stTel;
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(rows + " 라인에서 Exception 발생");
			}
			stdList.add(stDto);
		}
//		System.out.println("loadStudent 출력");
//		System.out.println(stdList);
//		System.out.println("Load 한 데이터 개수 : " + stdList.size());
		

//		printStudent();
		
		
		

	}
	
	
	
	
	public void deleteStudent() {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
		
		System.out.print("삭제할 데이터의 학번을 입력해 주세요.(QUIT : 나가기) >> ");
		
		String delNum = scan.nextLine();
		if (delNum.equals("QUIT")) break;
		
		try {
			delNum = String.format("%04d", Integer.valueOf(delNum));
		} catch (Exception e) {
			// TODO: handle exception
		}
		String choice = "";
		int index = -1;
		for (StudentDto dto : stdList) {
			
			index++;
			System.out.println(index);
			if (dto.stNum.equals(delNum)) {
				System.out.println(dto.toString());
				while(true) {
					System.out.print("정말 삭제할까요?(Y/N) >> ");
					choice = scan.nextLine();
					if (choice.equals("Y")) {
						stdList.remove(index);
						System.out.println("데이터가 삭제되었습니다.\n");
						break;
					} else if (choice.equals("N")){
						System.out.println("데이터가 삭제되지 않았습니다. \n처음으로 돌아갑니다.");
					} else {
						System.out.println("Y/N 중 하나를 입력해 주세요");
						continue;
					}
					break;
				}
				if (choice.isEmpty()) {
					continue;
				}
				break;
			}
			
		}
		if (index+1 >= stdList.size()) System.out.println("\n삭제할 데이터가 없습니다. \n학번을 확인해주시고 다시 입력해 주세요.\n");
		
		
		

		}
		
		OutputStream os = null;
		PrintWriter out = null;
		try {
			os = new FileOutputStream(Config.STUDENT_FILE);
			out = new PrintWriter(os);
			
			for (StudentDto dto : stdList) {
				out.printf("%s,",dto.stNum);
				out.printf("%s,",dto.stName);
				out.printf("%s,",dto.stDept);
				out.printf("%d,",dto.stGrade);
				out.printf("%s\n",dto.stTel);
				
			}
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("데이터 삭제 프로그램을 종료합니다.");
	}
	
	
}
