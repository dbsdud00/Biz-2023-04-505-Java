package com.callor.student.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.student.models.StudentDto;
import com.callor.student.utils.Line;

public class StudentExecA {
	
	public static void main(String[] args) {
		
		List<StudentDto> stdList = new ArrayList<>();
		
		Scanner scan = new Scanner(System.in);
		StudentDto stdDto;
		
		
		while(true) {
			/*
			 *  어떤 데이터를 입력할 것인가 라는 안내 메시지
			 *  각 속성(요소)를 입력할때 prompt 보이기
			 */
			System.out.println(Line.dLine(50));
			System.out.println("학생정보입력을 시작합니다.");
			System.out.println(Line.sLine(50));
			
			System.out.print("학번을 입력하세요 >> ");
			String stNum = scan.nextLine();
			
			System.out.print("이름을 입력하세요 >> ");
			String stName = scan.nextLine();
			
			System.out.print("학과를 입력하세요 >> ");
			String stDept = scan.nextLine();
			
			int stGrade;
			while(true) {
				try {
					System.out.print("학년을 입력하세요 >> ");
					stGrade = Integer.valueOf(scan.nextLine());
					
				} catch (Exception e) {
					System.out.println("숫자로 다시 입력해 주세요");
					continue;
				}
				break;
			}
			
			System.out.print("전화번호를 입력하세요 >> ");
			String stTel = scan.nextLine();
			
			// field 생성자를 사용하여 (데이터가 포함된) 객체 생성
			stdDto = new StudentDto(
					stNum,stName,stDept,stGrade,stTel);
			
			// 객체 생성 후 각 요소에 데이터 setting
//			stdDto.stNum = stNum;
//			stdDto.stName = stName;
//			stdDto.stDept = stDept;
//			stdDto.stGrade = stGrade;
//			stdDto.stTel = stTel;
			
			stdList.add(stdDto);
			
			System.out.print("종료하시려면 stop, 계속 입력하시려면 엔터를 눌러주세요 >> ");
			if (scan.nextLine().equals("stop")) {
				System.out.println("학생정보입력을 종료합니다.");
				System.out.println(Line.dLine(50));
				break;
			}
		}
		System.out.println(stdList.toString());
		
		
		scan.close();
	}
}
