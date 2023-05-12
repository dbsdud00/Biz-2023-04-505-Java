package com.callor.books.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.books.config.DataIndex;
import com.callor.books.models.PublisherDto;
import com.callor.books.service.PublisherService;

public class PublisherServiceImplV1 implements PublisherService {
	List<PublisherDto> pubList;
	public PublisherServiceImplV1() {
		pubList = new ArrayList<>();
	}
	@Override
	public void loadPublisher() {
		// TODO Auto-generated method stub
		String pubFile = "src/com/callor/books/data/출판사정보(2023-05-11).txt";
		
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(pubFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan = new Scanner(is);
		
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] str = line.split(",");
			
			PublisherDto pubDto = new PublisherDto();
			for (String pubStr : str) {
				pubDto.setPubCode(str[DataIndex.PUBLISHER.PUBCODE]);
				pubDto.setPubName(str[DataIndex.PUBLISHER.PUBNAME]);
				pubDto.setpubCeo(str[DataIndex.PUBLISHER.PUBCEO]);
				pubDto.setPubTel(str[DataIndex.PUBLISHER.PUBTEL]);
				pubDto.setPubAddress(str[DataIndex.PUBLISHER.PUBADDRESS]);
				
			}
			pubList.add(pubDto);
			
		}
		scan.close();
//		System.out.println(pubList);
	}

	@Override
	public void printPublisher() {
		// TODO Auto-generated method stub
		String[] pubIndex = "출판사코드,출판사명,대표,전화번호,주소".split(",");
		System.out.println("=".repeat(120));
		System.out.printf("%-10s\t",pubIndex[DataIndex.PUBLISHER.PUBCODE]);
		System.out.printf("%-10s\t",pubIndex[DataIndex.PUBLISHER.PUBNAME]);
		System.out.printf("%-10s\t",pubIndex[DataIndex.PUBLISHER.PUBCEO]);
		System.out.printf("%-10s\t",pubIndex[DataIndex.PUBLISHER.PUBTEL]);
		System.out.printf("%-10s\n",pubIndex[DataIndex.PUBLISHER.PUBADDRESS]);
		

		System.out.println("-".repeat(120));
		int i = 0;
		for (PublisherDto pubDto : pubList) {
			System.out.printf(" %-10s\t",pubDto.getPubCode());
			System.out.printf("%-10s\t",pubDto.getPubName());
			System.out.printf("%-10s\t",pubDto.getpubCeo());
			System.out.printf("%-10s\t",pubDto.getPubTel());
			System.out.printf("%-10s\n",pubDto.getPubAddress());
			if (++i %5 == 0 && i < pubList.size()) {
				System.out.println("-".repeat(120));
			}
		}
		System.out.println("=".repeat(120));
	}

	@Override
	public PublisherDto getPublisher(String code) {
		// TODO Auto-generated method stub
		if (pubList.isEmpty()) {
			this.loadPublisher();
		}
		for (PublisherDto pubDto : pubList) {
			if(pubDto.getPubCode().equals(code)) {
				return pubDto;
			}
		}
		return null;
	}

	@Override
	public List<PublisherDto> getPublisherList() {
		if (pubList.isEmpty()) {
			this.loadPublisher();
		}
		return pubList;
	}

	@Override
	public List<PublisherDto> getPublisherListByName(String Name) {
		
		List<PublisherDto> findList = new ArrayList<>();
		
		for (PublisherDto pubDto : pubList) {
			String pubName = pubDto.getPubName();
			for (int i = 0 ; i < pubName.length() - Name.length()+1; i++) {
				if (pubName.substring(i,i+Name.length()).equals(Name)) {
					findList.add(pubDto);
				}
			}
		}
		return findList;
		
	}
	
}
