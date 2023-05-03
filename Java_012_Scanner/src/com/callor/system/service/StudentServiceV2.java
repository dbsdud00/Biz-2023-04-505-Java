package com.callor.system.service;

import java.util.Scanner;

import com.callor.system.models.StudentDto;

public class StudentServiceV2 {
	// 학생 리스트를 담을 배열 선언
	private StudentDto[] stList;
	
	public void inputStudents() {
		
		Scanner scan = new Scanner(System.in);
		// 요소가 5개인 배열을 선언
		// 배열의 요소는 초기화가 안된 상태. 사용 불가
		stList = new StudentDto[5];
		
		// 학생 수 만큼 반복
		while (true) {

			System.out.println("학생정보를 입력하세요.");
			
			int intNum = 0;
			while (true) {
				
				System.out.print("학번(1 ~ 5) >> ");
				String stNum = scan.nextLine();
				try {
					intNum = Integer.valueOf(stNum);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("학번은 정수로 입력하세요");
					continue;
				}
				// 학번에서 -1을 입력하면 더이상 입력 받지 않기
				if(intNum < 0) {
					// method를 종료하라. inputStudents 자체가 끝남
					return;
				}
				if(intNum <1  || intNum > stList.length +1) {
					System.out.println("학번은 1~5 까지 입력하세요");
					continue;
				}
				break;
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
			
			
			StudentDto student = new StudentDto();
			
			
			// stList[intNum-1] = new StudentDto();
			student.setStNum(intNum+"");
			student.setStName(stName);
			student.setStDept(stDept);
			student.setStGrade(intGrade);
			student.setStTel(stTel);
			
			
			
			
			/*
			 * 현재 stList 배열의 요소는 초기화가 되지 않은 상태
			 * 이때 StudentDto type student 객체를 생성하였고,
			 * student 객체의 속성 값
			 */
			stList[intNum-1] = student;
			
			
			System.out.println();
			
		}
//		for (int i = 0; i< stList.length;i++) {
//			System.out.println(stList[i].toString());
//		}
//		System.out.println();
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
