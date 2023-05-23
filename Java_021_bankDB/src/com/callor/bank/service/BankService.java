package com.callor.bank.service;

import java.util.List;
import java.util.Scanner;

import com.callor.bank.models.BuyerDto;
import com.callor.bank.service.impl.BuyerServiceImplV1;

public class BankService {
	
	protected final Scanner scan;
	protected List<BuyerDto> buyerList;
	protected final BuyerService buyerService;
	
	public BankService() {
		scan = new Scanner(System.in);
		buyerService = new BuyerServiceImplV1();
	}
	
	public void printBuyerList() {
		buyerList = buyerService.selectAll();
		System.out.println("=".repeat(100));
		System.out.println("대한은행 고객 리스트");
		System.out.println("=".repeat(100));
		System.out.println("ID\t이름\t전화번호\t주소\t생년월일\t직업");
		System.out.println("-".repeat(100));
		for (BuyerDto buyerDto : buyerList) {
			System.out.printf("%s\t", buyerDto.buId);
			System.out.printf("%s\t", buyerDto.buName);
			System.out.printf("%s\t", buyerDto.buTel);
			System.out.printf("%s\t", buyerDto.buAddr);
			System.out.printf("%s\t", buyerDto.buBirth);
			System.out.printf("%s\n", buyerDto.buJob);
		}
		System.out.println("=".repeat(100));
	}
	public void findByBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("조회하고자 하는 고객 ID를 입력하세요");
		System.out.print("ID >> ");
		String strId = scan.nextLine();
		BuyerDto buyerDto = buyerService.findById(strId);
		if(buyerDto == null) {
			System.out.println("조회한 고객ID는 없는 데이터 입니다.");
		} else {
			System.out.println(buyerDto.toString());
		}
	}
	
	public void insertBuyer() {
		System.out.println("=".repeat(100));
		System.out.println("고객 정보 등록");
		System.out.println("=".repeat(100));
		
		System.out.print("고객 ID >> ");
		String strBuId = scan.nextLine();
		
		System.out.print("고객명 >> ");
		String strBuName = scan.nextLine();
		
		System.out.print("전화번호 >> ");
		String strBuTel = scan.nextLine();
		
		BuyerDto buyerDto = new BuyerDto();
		buyerDto.buId = strBuId;
		buyerDto.buName = strBuName;
		buyerDto.buTel = strBuTel;
		
		buyerService.insert(buyerDto);
		
	}
	
	public void delete() {
		System.out.println("=".repeat(100));
		System.out.println("삭제할 고객ID 를 입력하세요");
		System.out.println("고객 ID >> ");
		String strBuId = scan.nextLine();
		BuyerDto buyerDto = buyerService.findById(strBuId);
		if(buyerDto == null) {
			System.out.printf("%s 고객ID 는 없는 정보 입니다.", strBuId);
		} else {
			System.out.println(buyerDto.toString());
			System.out.println("고객 정보를 정말 삭제 할까요??? (YES/NO)");
			String yesNo = scan.nextLine();
			if (yesNo.equals("YES")) {
				int result = buyerService.delete(strBuId);
				if(result > 0) {
					System.out.println("고객 정보 삭제 완료");
				} else {
					System.out.println("고객 정보 삭제 실패");
				}
			} else {
				System.out.println("삭제 취소");
			}
			

		}
	}
	
	
	public void update() {
		while(true) {
			System.out.print("수정할 고객 id 를 입력하세요 >> ");
			String strBuId = scan.nextLine();
			BuyerDto buyerDto = buyerService.findById(strBuId);
			if(buyerDto == null) {
				System.out.println("없습니다.");
				continue;
			}
			System.out.println(buyerDto.toString());
			
			System.out.printf("고객ID : %s\n", buyerDto.buId);
			
			System.out.printf("고객이름(%s) >> ", buyerDto.buName);
			String strBuName = scan.nextLine();
			if (!strBuName.equals("")) buyerDto.buName = strBuName;
			
			System.out.printf("전화번호(%s) >> ", buyerDto.buTel);
			String strBuTel = scan.nextLine();
			if (!strBuTel.equals("")) buyerDto.buTel = strBuTel;
			
			int result = buyerService.update(buyerDto);
			if (result > 0) System.out.println("변경 성공");
			else System.out.println("변경 실패");
			
			break;
			
		}
	}
}
