package com.callor.bank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.model.AccDto;
import com.callor.bank.service.AccService;

public class AccServiceImplV1 implements AccService {

	List<AccDto> accList;
	Scanner scan;

	public AccServiceImplV1() {
		accList = new ArrayList<>();
		scan = new Scanner(System.in);
	}

	@Override
	public void accInit() {
		// TODO Auto-generated method stub
		AccDto acdto = new AccDto();
		System.out.print("신규 계좌번호 개설 >> ");
		acdto.acNum = scan.nextLine();
		acdto.acDiv = scan.nextLine();
		acdto.acInput = Integer.valueOf(scan.nextLine());
		acdto.acOutput = Integer.valueOf(scan.nextLine());
		acdto.acDate = scan.nextLine();
		acdto.acTime = scan.nextLine();

	}

	@Override
	public void inout() {
		// TODO Auto-generated method stub
		System.out.println("입출금 서비스");
		
		AccDto acDto = new AccDto();

		int choice = 0;
		while (true) {
			System.out.println("원하시는 서비스를 선택하세요");
			System.out.println("1. 입금");
			System.out.println("2. 출금");
			System.out.println("3. 돌아가기");
			try {
				choice = Integer.valueOf(scan.nextLine());
				if (choice == 1) {
					break;
				} else if (choice == 2) {
					break;
				} else if (choice == 3) {
					break;
				} else {
					System.out.println("서비스 항목 번호를 확인해 주시고 다시 입력해 주세요");
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("서비스 항목 번호를 확인해 주시고 숫자로 입력해 주세요");
			}
		}

		if (choice == 1) {
			System.out.println("입금 서비스입니다.");
			while (true) {
				System.out.println("입금액을 입력해 주세요");
				try {
					acDto.acInput = Integer.valueOf(scan.nextLine());

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("정수형 숫자로 입력해 주세요");
					continue;
				}
				System.out.println("입금되었습니다.");
				break;
			}
		}
		else if (choice == 2) {
			System.out.println("출금 서비스 입니다.");
			while (true) {
				System.out.println("출금액을 입력해 주세요");
				try {
					acDto.acOutput += Integer.valueOf(scan.nextLine());
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("정수형 숫자로 입력해 주세요");
					continue;
				}
				if (acDto.acInput >= acDto.acOutput) {
					acDto.acInput -= acDto.acOutput;
					System.out.println("출금되었습니다.");
				} else if (acDto.acInput < acDto.acOutput) {
					System.out.println("잔액이 부족합니다.");
					continue;
				}
				break;
			}
		} else if (choice == 3) {
			
		}
		accList.add(acDto);

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
