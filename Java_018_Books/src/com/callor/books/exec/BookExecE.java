package com.callor.books.exec;

import com.callor.books.service.PublisherService;
import com.callor.books.service.impl.PublisherServiceImplV1;

public class BookExecE {
	public static void main(String[] args) {
		PublisherService pubServ = new PublisherServiceImplV1();
		
		pubServ.loadPublisher();
		pubServ.printPublisher();
		System.out.println(pubServ.getPublisher("C0048"));
		System.out.println(pubServ.getPublisherList());
		System.out.println(pubServ.getPublisherListByName("글"));
	}
}
