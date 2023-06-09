package com.callor.bank.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.model.BuyerDto;
import com.callor.bank.service.BuyerService;
import com.callor.bank.utils.Line;

public class BuyerServiceImplV1B implements BuyerService {
	List<BuyerDto> buyerList;
	protected Scanner scan;

	public BuyerServiceImplV1B() {
		buyerList = new ArrayList<>();
		scan = new Scanner(System.in);
	}
	@Override
	public void loadBuyer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printBuyerList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BuyerDto getBuyer(String buId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 *  현재 buyerList에 저장된 요소들을 탐색하여
	 *  고객 ID가 가장 큰 값을 갖는 요소를 찾아서 고객 ID +1의 값을 return
	 */
	protected int getMaxId() {
		int maxId = 0;
		for(BuyerDto dto : buyerList) {
			int intId = Integer.valueOf(dto.buId);
			if (intId > maxId) maxId = intId;
		}
		return maxId + 1;
	}
	
	protected BuyerDto buyerItemImput() {
		// null 값으로 임시 clear
		BuyerDto buDto = null;

		String buId = "";
		while(true) {
			
			
			System.out.printf("고객ID(%04d) >> ",getMaxId());
			buId = scan.nextLine();

			if (buId.equals("QUIT")) return null;
			if (buId.equals("")) buId = String.format("%04d",getMaxId());
			
			try {
				int intBuId = Integer.valueOf(buId);
				buId = String.format("%04d", intBuId);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("고객 ID 는 정수로만 입력하세요");
			}
			
			// 여기까지 buDto는 "null"인 상태
			for (BuyerDto dto : buyerList) {
				// 고객 ID에 해당하는 정보가 있으면
				// 이때부터는 buDto 는 null인 상태가 아니고
				// 입력한 고객 ID의 데이터 의 주소를 갖는 상태
				if (dto.buId.equals(buId)) {
					buDto = dto;
				}
			}
			
			break;
		} // buId 입력 끝
		
		
		
		
		System.out.printf("고객이름(%s) >> ", buDto == null ? "신규" : buDto.buName);
		String buName = scan.nextLine();
		if (buName.equals("QUIT")) return null;
		
		System.out.printf("전화번호(%s) >> ", buDto == null ? "신규" : buDto.buTel);
		String buTel = scan.nextLine();
		if (buTel.equals("QUIT")) return null;
		
		System.out.printf("주소(%s) >> ", buDto == null ? "신규" : buDto.buAddr);
		String buAddr = scan.nextLine();
		if (buAddr.equals("QUIT")) return null;
		
		System.out.printf("생년월일(%s) >> ", buDto == null ? "신규" : buDto.buBirth);
		String buBirth = scan.nextLine();
		if (buBirth.equals("QUIT")) return null;
		
		System.out.printf("직업(%s) >> ", buDto == null ? "신규" : buDto.buJob);
		String buJob = scan.nextLine();
		if (buJob.equals("QUIT")) return null;
		
		if (buDto == null) buDto = new BuyerDto();
		
		buDto.buId = buId;
		buDto.buName = buName;
		buDto.buTel = buTel;
		buDto.buAddr = buAddr;
		buDto.buBirth = buBirth;
		buDto.buJob = buJob;
		return buDto;
		
	}

	@Override
	public void inputBuyer() {
		while(true) {
			
			System.out.println(Line.dLine(100));
			System.out.println("고객 정보 관리");
			System.out.println(Line.sLine(100));
			
			BuyerDto buDto = buyerItemImput();
			
			if (buDto == null) break;
			
			// buyerList 데이터를 추가 또는 수정
			// buyerList 데이터에 buDto 요소가 없으면 추가, 있으면 무시
			// 주소에 대한 개념으로 이해하여 보자
			
			// List type 객체의 contains method
			// List type 객체(buyerList)의 요소중에
			// buDto 변수에 담긴 주소를 가진 요소가 있나?
			if(!buyerList.contains(buDto))	buyerList.add(buDto);
			
		}
		
		System.out.println("고객정보 입력 종료");
		
		String buyerFile = "src/com/callor/bank/datas/buyer.txt";
		
		PrintWriter out = null;
		OutputStream os = null;
		
		try {
			os = new FileOutputStream(buyerFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out = new PrintWriter(os);
		
		for(BuyerDto dto : buyerList) {
			out.print(dto.buId + ",");
			out.print(dto.buName + ",");
			out.print(dto.buTel + ",");
			out.print(dto.buAddr + ",");
			out.print(dto.buBirth + ",");
			out.print(dto.buJob + "\n");
		}
		out.close();
		
		
		
		
		
	}
	@Override
	public void printBuyerList(PrintWriter out) {
		// TODO Auto-generated method stub
		
	}

}
