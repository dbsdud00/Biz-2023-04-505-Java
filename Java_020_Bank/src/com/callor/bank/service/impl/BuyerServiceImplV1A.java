package com.callor.bank.service.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.model.BuyerDto;
import com.callor.bank.service.BuyerService;
import com.callor.bank.utils.Line;

public class BuyerServiceImplV1A implements BuyerService {
	List<BuyerDto> buyerList;
	protected Scanner scan;

	public BuyerServiceImplV1A() {
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

	protected BuyerDto buyerItemImput() {

		BuyerDto buDto = new BuyerDto();
		BuyerDto lastDto;
		int newId = 0;
		try {
			lastDto = buyerList.get(buyerList.size() - 1);
			newId = Integer.valueOf(lastDto.buId)+1;
		} catch (Exception e) {
			// TODO: handle exception
			newId = 0;
		}

		String buId;

		while (true) {
			String newStrId = String.format("%04d", newId);
			System.out.printf("고객ID(%s) >> ", newStrId);
			buId = scan.nextLine();
			// Q 처럼 단독 알파벳으로 쓰면 좋을 것 같은데?
			// 입력하는 도중 알파벳은 실수로 자꾸 눌릴 수 있다.
			// 실수로 알파벳 Q는 쉽게 누를 수 있지만
			// 상대적으로 QUIT는 실수로 입력할 확률이 낮다.
			// 입력도중 알파벳을 잘못 입력하여 종료되는 것을 방지하기 위함
			if (buId.equals("QUIT"))
				return null;
			if (buId.equals("")) {
				buId = newStrId;
			} else {

				try {
					int intBuId = Integer.valueOf(buId);
					if (intBuId < 0 || intBuId > newId) {
						System.out.println("고객ID는 순서대로 입력 가능합니다.");
						continue;
					}
					buId = String.format("%04d", intBuId);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("고객ID 는 정수로만 입력하세요");
					continue;
				}
			}
			break;

		} // buId 입력 끝

		System.out.print("고객이름 >> ");
		String buName = scan.nextLine();
		if (buName.equals("QUIT"))
			return null;

		System.out.print("전화번호 >> ");
		String buTel = scan.nextLine();
		if (buTel.equals("QUIT"))
			return null;

		System.out.print("주소 >> ");
		String buAddr = scan.nextLine();
		if (buAddr.equals("QUIT"))
			return null;

		System.out.print("생년월일 >> ");
		String buBirth = scan.nextLine();
		if (buBirth.equals("QUIT"))
			return null;

		System.out.print("직업 >> ");
		String buJob = scan.nextLine();
		if (buJob.equals("QUIT"))
			return null;

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
		while (true) {

			System.out.println(Line.dLine(100));
			System.out.println("고객 정보 관리");
			System.out.println(Line.sLine(100));

			BuyerDto buDto = buyerItemImput();

			if (buDto == null)
				break;
			buyerList.add(buDto);
			System.out.println(buyerList);
		}

		System.out.println("고객정보 입력 종료");
		
	}

	@Override
	public void printBuyerList(PrintWriter out) {
		// TODO Auto-generated method stub
		
	}

}
