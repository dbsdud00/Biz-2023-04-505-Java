package com.callor.books.exec;

import com.callor.books.service.AuthorService;
import com.callor.books.service.impl.AuthorServiceImplV1;

public class BookExecD {
	public static void main(String[] args) {
		AuthorService auServ = new AuthorServiceImplV1();
		auServ.loadAuthor();
		auServ.printAuthorList();
		System.out.println(auServ.getAuthor("A0002"));
		System.out.println(auServ.getAuthorList());
	}
}
