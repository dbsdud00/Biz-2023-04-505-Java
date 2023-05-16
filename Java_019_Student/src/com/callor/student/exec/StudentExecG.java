package com.callor.student.exec;

import java.util.Scanner;

import com.callor.student.service.StudentService;
import com.callor.student.service.impl.StudentServiceImplV2_1;
import com.callor.student.service.impl.StudentServiceImplV3;
import com.callor.student.utils.Line;

public class StudentExecG {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentService stServ = new StudentServiceImplV3();

		System.out.println(Line.dLine(40));
		System.out.println("대한고교 학사관리 2023");
		System.out.println(Line.dLine(40));

		while (true) {
			
			System.out.println("실행할 업무를 선택하세요");
			System.out.println(Line.sLine(40));
			System.out.println("1. 학생 리스트 확인");
			System.out.println("2. 학쟁 정보 추가/수정");
			System.out.println("3. 학생 정보 삭제");
			System.out.println("9. 업무 종료");
			System.out.println(Line.sLine(40));
			System.out.print("업무 선택 >> ");

			int choice = 0;
			try {
				choice = Integer.valueOf(scan.nextLine());

			} catch (Exception e) {
				// TODO: handle exception
				System.out.printf("업무선택을 확인하시고\n 1~9의 정수로 입력해 주세요.(%s)",choice);
				continue;
			}

			if (choice == 1) {
				stServ.printStudent();
				
			} else if (choice == 2) {
				stServ.insertStudent();
			} else if (choice == 3) {
				/*
				 *  deleteStudent() method 는 Service interface에 
				 *  없는 method 이다.
				 *  따라서 method 를 포함하고 있는 class type 으로 
				 *  stService 를 객체 형 변환 해 주어야만 
				 *  사용할 수 있다.
				 */
				((StudentServiceImplV3)stServ).deleteStudent();
			} else if (choice == 9) {
				break;
			} else {
				System.out.printf("업무선택이 잘못되었습니다. 다시 입력해 주세요(%s)",choice);
			}
		}
		System.out.println("업무를 종료합니다.");
		scan.close();
	}
}
