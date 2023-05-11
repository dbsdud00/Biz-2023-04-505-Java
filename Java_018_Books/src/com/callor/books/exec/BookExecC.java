package com.callor.books.exec;

import com.callor.books.service.BookService;
import com.callor.books.service.impl.BookServiceImplV2;

public class BookExecC {
	public static void main(String[] args) {
		BookService bServ = new BookServiceImplV2();
		bServ.loadBooks();
//		bServ.printBookList();
	}
}
