package com.callor.classes.exec;

import com.callor.classes.models.StudentDto;
import com.callor.classes.service.impl.StudentService;
import com.callor.classes.service.impl.StudentServiceImplV1;

public class StudentD {
	public static void main(String[] args) {
		StudentService stdService = new StudentServiceImplV1();
		stdService.loadStudent();
		stdService.printStudent();
		StudentDto stdDto = stdService.getStudent("S0003");
		System.out.println(stdDto);
		
	}
}
