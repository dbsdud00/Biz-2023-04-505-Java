package com.callor.classes.exec;

import com.callor.classes.models.StudentDto;
import com.callor.classes.service.StudentService;
import com.callor.classes.service.impl.StudentServiceImplV2;

public class StudentExecD {
	
	
	public static void main(String[] args) {
		StudentService stdServ = new StudentServiceImplV2();

		stdServ.loadStudent();
		stdServ.printStudent();
		
		StudentDto stdDto = stdServ.getStudent("﻿﻿S0011");
		System.out.println();
		System.out.println(stdDto);
	}
}
