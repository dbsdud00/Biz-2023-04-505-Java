package com.callor.system.exec;

import com.callor.system.service.StudentServiceV2;

public class StudentD {
	public static void main(String[] args) {
		StudentServiceV2 studentServiceV2 = new StudentServiceV2();
		studentServiceV2.inputStudents();
		studentServiceV2.printStudents();
	}
}
