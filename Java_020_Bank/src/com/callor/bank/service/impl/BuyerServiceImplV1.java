package com.callor.bank.service.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.model.BuyerDto;
import com.callor.bank.service.BuyerService;

public class BuyerServiceImplV1 implements BuyerService {

	List<BuyerDto> buyerList;

	public BuyerServiceImplV1() {
		buyerList = new ArrayList<>();
	}

	@Override
	public void loadBuyer() {

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
	
	
	
	

	@Override
	public void inputBuyer() {

		Scanner scan = new Scanner(System.in);
		
		// 전체적인 입력 반복을 위한 while
		while (true) {
			

			BuyerDto buDto = new BuyerDto();
			
			Boolean isIn = false;
			
			System.out.println("=".repeat(80));
			System.out.println("고객정보입력을 시작합니다. 종료하시려면 QUIT를 눌러주세요");
			System.out.println("=".repeat(80));

			int intNum = 0;
			String buId = "";
			while (true) {
				System.out.printf("고객ID(정수) >> ");
				buId = scan.nextLine();
				if (buId.equals("QUIT"))
					break;
				try {
					intNum = Integer.valueOf(buId);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("정수로 입력해 주세요");
					continue;
				}
				break;
			}
			
			if (buId.equals("QUIT"))
				break;
			buId = String.format("%04d", intNum);

			for (BuyerDto dto : buyerList) {
				if (buId.equals(dto.buId)) {
					isIn = true;
					buDto = dto;
				}
			}

			

			System.out.printf("고객이름(%s) >> ", buDto.buName == null ? "신규" : buDto.buName);
			String buName = scan.nextLine();
			if (buName.equals("QUIT"))	break;
			if (buName.equals("")) {
				buName = buDto.buTel;
			}
			
			System.out.printf("전화번호(%s) >> ", buDto.buTel == null ? "신규" : buDto.buTel);
			String buTel = scan.nextLine();
			if (buTel.equals("QUIT"))
				break;
			if (buTel.equals("")) {
				buTel = buDto.buTel;
			}

			System.out.printf("주소(%s) >> ", buDto.buAddr == null ? "신규" : buDto.buAddr);
			String buAddr = scan.nextLine();
			if (buAddr.equals("QUIT"))
				break;
			if (buAddr.equals("")) {
				buAddr = buDto.buAddr;
			}

			System.out.printf("생년월일(%s) >> ", buDto.buBirth == null ? "신규" : buDto.buBirth);
			String buBirth = scan.nextLine();
			if (buBirth.equals("QUIT"))
				break;
			if (buBirth.equals("")) {
				buBirth = buDto.buBirth;
			}
			System.out.printf("직업(%s) >> ", buDto.buJob == null ? "신규" : buDto.buJob);
			String buJob = scan.nextLine();
			if (buJob.equals("QUIT"))
				break;
			if (buJob.equals("")) {
				buJob = buDto.buJob;
			}

			buDto.buId = buId;
			buDto.buName = buName;
			buDto.buTel = buTel;
			buDto.buAddr = buAddr;
			buDto.buBirth = buBirth;
			buDto.buJob = buJob;

			if (isIn) {
				continue;
			}

			buyerList.add(buDto);

		}

		System.out.println("고객 정보 입력을 마칩니다.");
		System.out.println(buyerList.toString());

	}

	@Override
	public void printBuyerList(PrintWriter out) {
		// TODO Auto-generated method stub
		
	}

}
