package com.callor.system.service;

import java.util.Scanner;

import com.callor.system.models.StudentDto;

public class StudentServiceV2 {
	public void inputStudents() {
		
		StudentDto[] stList = new StudentDto[5];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i<stList.length; i++) {
			stList[i] = new StudentDto();
		}
		
		for (int i = 0; i<stList.length;i++ ) {
			System.out.println(i+1 +"번 학생정보를 입력하세요.");
			System.out.print("학번 >> ");
			String stNum = scan.nextLine();
			System.out.print("이름 >> ");
			String stName = scan.nextLine();
			System.out.print("학과 >> ");
			String stDept = scan.nextLine();
			
			int intGrade = 0;
			while(true) {
				System.out.print("학년 >> ");
				String stGrade = scan.nextLine();	
				try {
					intGrade = Integer.valueOf(stGrade);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("정수가 아니야");
					continue;
				}
				if (intGrade <1 || intGrade>4) {
					System.out.println("학년은 1학년에서 4학년까지야");
					continue;
				}
				break;
			}
			
			System.out.print("전화번호 >> ");
			String stTel = scan.nextLine();
			
			stList[i].setStNum(stNum);
			stList[i].setStName(stName);
			stList[i].setStDept(stDept);
			stList[i].setStGrade(intGrade);
			stList[i].setStTel(stTel);
			System.out.println();
		}
		for (int i = 0; i< stList.length;i++) {
			System.out.println(stList[i].toString());
		}
	}
}
