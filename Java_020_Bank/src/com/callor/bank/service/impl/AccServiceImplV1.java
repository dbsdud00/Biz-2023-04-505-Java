package com.callor.bank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.model.AccDto;
import com.callor.bank.model.BuyerDto;
import com.callor.bank.service.AccService;
import com.callor.bank.service.BuyerService;

public class AccServiceImplV1 implements AccService {
	
	List<AccDto> accList;
	Scanner scan;
	public AccServiceImplV1() {
		accList = new ArrayList<>();
		scan = new Scanner(System.in);
	}
	
	/*
	 *  신규계좌 등록하기
	 *  1. 고객ID를 입력받고, 
	 *  2. 고객ID가 고객정보가 있는가 확인
	 *  	BuyerServiceImplV1.getBuyer() method를 사용하여 고객 정보 찾기
	 *  	없으면 : 고객정보를 등록하세요 라고 메시지 표현
	 *  3. 고객번호가 있으면 신규계좌를 생성 : List<AccDto> type accList에 추가
	 *  
	 */
	@Override
	public void accInit() {
		// TODO Auto-generated method stub
		BuyerService buServ = new BuyerServiceImplV1D();
		System.out.println("신규 계좌 등록 서비스 입니다.");
		while(true) {
			System.out.print("고객ID를 입력해 주세요. >> ");
			int intBuId = 0;
			try {
				intBuId = Integer.valueOf( scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("정수로 입력해 주세요");
				continue;
			}
			String BuId = String.format("%04d", intBuId);
			BuyerDto buDto = buServ.getBuyer(BuId);
			if (buDto == null) {
				System.out.println("고객ID가 없습니다. 고객정보를 등록하세요");
				break;
			}
			System.out.printf("%s고객님 확인되셨습니다.\n",buDto.buName);
			System.out.println("신규계좌를 생성합니다.");
			AccDto accDto = new AccDto();
			System.out.print("계좌번호를 입력해주세요 >> ");
			accDto.acNum =  scan.nextLine();
			accDto.BuId =  BuId;
		
			
			accList.add(accDto);
			
			System.out.println("계좌 등록이 완료되었습니다.");
			break;
		}
		System.out.println(accList);
	}

	@Override
	public void inout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printAccList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveAccList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadAccList() {
		// TODO Auto-generated method stub
		
	}

	
}
