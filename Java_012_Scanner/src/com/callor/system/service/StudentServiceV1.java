package com.callor.system.service;

import java.util.Scanner;

import com.callor.system.models.StudentDto;

public class StudentServiceV1 {
	
	Scanner scan = new Scanner(System.in);
	public void inputStudent() {
		StudentDto student = new StudentDto();
		System.out.println("학생정보를 입력하세요.");
		System.out.print("\n학번 >> ");
		student.setStNum(scan.nextLine());
		System.out.print("\n이름 >> ");
		student.setStName(scan.nextLine());
		System.out.print("\n학과 >> ");
		student.setStDept(scan.nextLine());
		
		String stGrade = "";
		int intGrade = 0;
		
		while (true) {
			System.out.print("\n학년 >> ");
			stGrade = scan.nextLine();
			try {
				intGrade = Integer.valueOf(stGrade);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("정수만 입력해");
				continue;
			}
			if (intGrade < 1 || intGrade >4) {
				System.out.println("학년은 1학년에서 4학년까지 입니다");
				continue;
			}else {
				student.setStGrade(intGrade);
			}
			break;
		}
		System.out.print("\n전화번호 >> ");
		student.setStTel(scan.nextLine());
		System.out.println();
		System.out.println(student.toString());
	}
}
