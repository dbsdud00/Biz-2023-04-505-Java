package com.callor.system.service;

import java.util.Scanner;

import com.callor.system.models.StudentDto;

public class StudentServiceV22 {
	private StudentDto[] stList;
	
	public void inputStudents() {
		stList = new StudentDto[5];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i<stList.length; i++) {
			stList[i] = new StudentDto();
		}
		
		for (int i = 0; i<stList.length;i++ ) {
			System.out.println(i+1 +"번 학생정보를 입력하세요.");
			System.out.print("학번 >> ");
			String stNum = scan.nextLine();
			int intNum = 0;
			try {
				intNum = Integer.valueOf(stNum);
			} catch (Exception e) {
				// TODO: handle exception
			}
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
		System.out.println();
	}
	
	
	public void printStudents() {
		System.out.println("=".repeat(60));
		System.out.println("학번\t이름\t학과\t\t학년\t전화번호");
		
		System.out.println("-".repeat(60));
		for (int i = 0; i< stList.length; i++) {
			System.out.printf("%s\t ",stList[i].getStNum());
			System.out.printf("%s\t ",stList[i].getStName());
			System.out.printf("%s\t\t ",stList[i].getStDept());
			System.out.printf("%d\t ",stList[i].getStGrade());
			System.out.printf("%s\t ",stList[i].getStTel());
			if (i<stList.length-1) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("=".repeat(60));
		
	}
	
	
}
