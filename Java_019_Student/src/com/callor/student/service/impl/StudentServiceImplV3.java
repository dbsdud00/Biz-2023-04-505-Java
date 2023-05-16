package com.callor.student.service.impl;

import java.util.Scanner;

import com.callor.student.models.StudentDto;
import com.callor.student.utils.Line;

public class StudentServiceImplV3 extends StudentServiceImplV2_1 {

	@Override
	public void deleteStudent() {
		Scanner scan = new Scanner(System.in);
		System.out.println(Line.dLine(100));
		System.out.println("학생정보 삭제, 삭제할 학번을 입력");
		System.out.print("학번(Enter : 종료) >> ");
		String stNum = scan.nextLine();
		if(stNum.equals("")) {
			return;
		}
		StudentDto stDto = null;
//		for (StudentDto dto : stdList) {
//			if (stDto.stNum.equals(stNum)) {
//				stDto = dto;
//				break;
//			}
//		}
		int index = 0;
		for (index = 0; index < stdList.size(); index++) {
			if (stdList.get(index).stNum.equals(stNum)) {
				System.out.println(Line.sLine(100));
				System.out.println(stdList.get(index));
				System.out.println(Line.sLine);
			}
		}
		if (index <stdList.size()) {
			System.out.println("학생 정보를 삭제 할까요?(Y/N)");
			String yesNo = scan.nextLine();
			if (yesNo.equals("Y")) {
				stdList.remove(index);
			} 
		}
		return;
	}
	
	
}
