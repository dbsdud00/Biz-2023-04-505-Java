package com.callor.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.config.DataIndex;
import com.callor.books.models.BookDto;
import com.callor.books.service.BookService;

public class BookServiceImplV1 implements BookService {
	
	
	protected List<BookDto> bookList;
	
	public BookServiceImplV1() {
		// TODO Auto-generated constructor stub
		bookList = new ArrayList<>();
	}
	
	@Override
	public void loadBooks() {
		// TODO Auto-generated method stub
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

		int rows = 0;
		BookDto bDto;
		while (fileScan.hasNext()) {
			
			String line = fileScan.nextLine();
			String[] bookStr = line.split(",");
			rows++;
			if (bookStr.length < 7) {
				System.out.printf("%d 번째 데이터 문제발생\n", rows);
				System.out.println(line);
				break;
			}
//			for (String str: bookStr) {
//				System.out.print(str + "\t");
//			}
//			System.out.println();
			int bPage = Integer.valueOf(bookStr[DataIndex.BOOK.PAGES].split(" ")[0]);
			int bPrice = Integer.valueOf(bookStr[DataIndex.BOOK.PRICE].split(" ")[0]);
			String bTitle = bookStr[DataIndex.BOOK.TITLE];
			if (bookStr[DataIndex.BOOK.TITLE].length()>14) {
				bTitle = bookStr[DataIndex.BOOK.TITLE].substring(0,14);
			}
			
			bDto = new BookDto(
					bookStr[DataIndex.BOOK.ISBN],
					bTitle,
					bookStr[DataIndex.BOOK.PUBLISHER],
					bookStr[DataIndex.BOOK.AUTHOR],
					bookStr[DataIndex.BOOK.PDATE],
					bPage,
					bPrice);
			
//			System.out.println(bDto.toString());
			
			bookList.add(bDto);
		}
		fileScan.close();

	}

	@Override
	public void printBookList() {
		// TODO Auto-generated method stub
		System.out.println("=".repeat(130));
		System.out.println("ISBN\t\t도서명\t\t\t\t출판사\t저자\t발행일\t\t페이지\t가격");
		System.out.println("=".repeat(130));
		
		for (BookDto bDto : bookList) {
			System.out.printf("%13s\t",bDto.getbIsbn());
			System.out.printf("%-20s\t",bDto.getbTitle());
			System.out.printf("%-5s\t",bDto.getbPublisher());
			System.out.printf("%-5s\t",bDto.getbAuthor());
			System.out.printf("%-10s\t",bDto.getbPublishDate());
			System.out.printf("%-4d\t",bDto.getbPages());
			System.out.printf("%-5d\n",bDto.getbPrice());
			
		}
		
	}

	@Override
	public BookDto getBook(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDto> getBookList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBook(BookDto bookDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(String isbn) {
		// TODO Auto-generated method stub
		
	}

}
