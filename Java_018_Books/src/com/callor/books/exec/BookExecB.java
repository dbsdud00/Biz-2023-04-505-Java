package com.callor.books.exec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class BookExecB {
	// ISBN,도서명,출판사,저자,발행일,페이지,가격
	//  0,    1,     2,    3.    4,     5,    6

	/*
	 * 도서정보.txt 파일을 열어서 각 line 을 읽어들인 후 index 0번 부터 index 8번 까지 데이터를 console에 출력해 보기
	 */

	public static void main(String[] args) {
		String bookInfoPath = "src/com/callor/books/data/도서정보(2023-05-11).txt";

		InputStream is = null;
		Scanner fileScan = null;

		try {
			is = new FileInputStream(bookInfoPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(bookInfoPath + "파일이 없습니다.");
		}
		
		fileScan = new Scanner(is);

		System.out.println("=".repeat(120));
		System.out.println("ISBN\t도서명\t출판사\t저자\t발행일\t페이지\t가격");
		System.out.println("-".repeat(120));
		
		int rows = 0;
		
		while (fileScan.hasNext()) {

			String line = fileScan.nextLine();
			String[] bookStr = line.split(",");
			rows++;
			if (bookStr.length < 7) {
				System.out.printf("%d 번째 데이터 문제\n", rows);
				System.out.println(line);
				break;
			}
			
			System.out.printf("%s\t", bookStr[0]);
			System.out.printf("%s\t", bookStr[1]);
			System.out.printf("%s\n", bookStr[2]);

			System.out.println();
			System.out.println("-".repeat(120));
			System.out.println();

		}
		fileScan.close();

	}

}
