package com.callor.memo.exec;

import java.util.Scanner;

import com.callor.memo.config.Line;
import com.callor.memo.service.Service;
import com.callor.memo.service.impl.ServiceImplV1;

public class DbExecB {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Service service = new ServiceImplV1();
		System.out.println(Line.dLine(70));
		System.out.println("메모장");
		System.out.println(Line.dLine(70));
		while(true) {
			System.out.println("1. 전체 메모 목록 불러오기");
			System.out.println("2. 메모 불러오기");
			System.out.println("3. 새로 만들기");
			System.out.println("4. 메모 수정하기");
			System.out.println("5. 메모 삭제하기");
			System.out.println("9. 종료하기");
			System.out.print(">> ");
			int intChoice = 0;
			try {
				intChoice = Integer.valueOf( scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("정수로 입력해 주세요");
				continue;
			}
			if (intChoice == 1) service.LoadMemo();
			else if (intChoice == 2) service.ReadMemo();
			else if (intChoice == 3) service.NewMemo();
			else if (intChoice == 4) service.UpdateMemo();
			else if (intChoice == 5) service.DeleteMemo();
			else if (intChoice == 9) break;
			else {
				System.out.println("번호를 다시 입력해 주세요.");
				System.out.println(Line.sLine(70));
				continue;
			}
			
		}
		System.out.println("메모장을 종료합니다.");
	}
}
