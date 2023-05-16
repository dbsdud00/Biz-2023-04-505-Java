package com.callor.student.exec;

import com.callor.student.service.StudentService;
import com.callor.student.service.impl.StudentServiceImplV2_1;

public class StudentExecF {
	public static void main(String[] args) {
		StudentService stServ = new StudentServiceImplV2_1();
		stServ.loadStudent();
		stServ.printStudent();
		stServ.insertStudent();
	}
}
