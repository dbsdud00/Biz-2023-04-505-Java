package com.callor.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.config.DataIndex;
import com.callor.books.config.Utils;
import com.callor.books.models.AuthorDto;
import com.callor.books.service.AuthorService;

public class AuthorServiceImplV1 implements AuthorService{
	private List<AuthorDto> auList;
	public AuthorServiceImplV1() {
		auList = new ArrayList<>();
	}
	@Override
	public void loadAuthor() {
		// TODO Auto-generated method stub
		String auFile = "src/com/callor/books/data/저자정보(2023-05-11).txt";
		InputStream is =null;
		Scanner scan = null;
		try {
			is = new FileInputStream(auFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan = new Scanner(is);
		
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] auStr = line.split(",");
			
			AuthorDto auDto = new AuthorDto();
			auDto.setAuAddress(auStr[DataIndex.AUTHOR.AUADDRESS]);
			auDto.setAuCode(auStr[DataIndex.AUTHOR.AUCODE]);
			auDto.setAuName(auStr[DataIndex.AUTHOR.AUNAME]);
			auDto.setAuTel(auStr[DataIndex.AUTHOR.AUTEL]);
			auList.add(auDto);
		}
//		System.out.println(auList);
		scan.close();
	}

	@Override
	public void printAuthorList() {
		// TODO Auto-generated method stub
		String[] printIndex = "저자코드,저자명,전화번호,주소".split(",");
		System.out.println(Utils.dLine(100));
		System.out.printf("%-5s\t",printIndex[DataIndex.AUTHOR.AUCODE]);
		System.out.printf("%-20s\t",printIndex[DataIndex.AUTHOR.AUNAME]);
		System.out.printf("%-10s\t\t",printIndex[DataIndex.AUTHOR.AUTEL]);
		System.out.printf("%s\n",printIndex[DataIndex.AUTHOR.AUADDRESS]);
		System.out.println(Utils.sLine(100));
		
		for (AuthorDto auDto : auList) {
			System.out.printf("%-5s\t\t",auDto.getAuCode());
			System.out.printf("%-20s\t",auDto.getAuName());
			System.out.printf("%-10s\t\t",auDto.getAuTel());
			System.out.printf("%s\n",auDto.getAuAddress());
			
		}
		System.out.println(Utils.dLine(100));
	}

	@Override
	public AuthorDto getAuthor(String code) {
		// TODO Auto-generated method stub
		if(auList.isEmpty()) {
			this.loadAuthor();
		}
		for (AuthorDto auDto : auList) {
			if (auDto.getAuCode().equals(code)) {
				return auDto;
			}
		}
		return null;
	}

	@Override
	public List<AuthorDto> getAuthorList() {
		// TODO Auto-generated method stub
		if(auList.isEmpty()) {
			this.loadAuthor();
		}
		return auList;
	}
}
