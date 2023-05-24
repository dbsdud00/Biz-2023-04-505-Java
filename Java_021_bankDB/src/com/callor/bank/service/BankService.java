package com.callor.bank.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.config.DBContract;
import com.callor.bank.models.AccDto;
import com.callor.bank.models.BuyerDto;
import com.callor.bank.service.impl.AccServiceV1;
import com.callor.bank.service.impl.BuyerServiceImplV1;
import com.callor.bank.utils.Line;

public class BankService {

	protected final Scanner scan;
	protected List<BuyerDto> buyerList;
	protected final BuyerService buyerService;
	protected final AccService accService;

	public BankService() {
		scan = new Scanner(System.in);
		buyerService = new BuyerServiceImplV1();
		accService = new AccServiceV1();
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
		if (buyerDto == null) {
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
		if (buyerDto == null) {
			System.out.printf("%s 고객ID 는 없는 정보 입니다.", strBuId);
		} else {
			System.out.println(buyerDto.toString());
			System.out.println("고객 정보를 정말 삭제 할까요??? (YES/NO)");
			String yesNo = scan.nextLine();
			if (yesNo.equals("YES")) {
				int result = buyerService.delete(strBuId);
				if (result > 0) {
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
		while (true) {
			System.out.print("수정할 고객 id 를 입력하세요 >> ");
			String strBuId = scan.nextLine();
			BuyerDto buyerDto = buyerService.findById(strBuId);
			if (buyerDto == null) {
				System.out.println("없습니다.");
				continue;
			}
			System.out.println(buyerDto.toString());

			System.out.printf("고객ID : %s\n", buyerDto.buId);

			System.out.printf("고객이름(%s) >> ", buyerDto.buName);
			String strBuName = scan.nextLine();
			if (!strBuName.equals(""))
				buyerDto.buName = strBuName;

			System.out.printf("전화번호(%s) >> ", buyerDto.buTel);
			String strBuTel = scan.nextLine();
			if (!strBuTel.equals(""))
				buyerDto.buTel = strBuTel;

			int result = buyerService.update(buyerDto);
			if (result > 0)
				System.out.println("변경 성공");
			else
				System.out.println("변경 실패");

			break;

		}
	}

	public void findUserInfo() {

		this.printBuyerList();

		System.out.println("\n찾으실 고객 ID를 입력해 주세요.");
		System.out.print("고객 ID >> ");
		String buId = scan.nextLine();
		BuyerDto buDto = buyerService.findById(buId);
		if (buDto == null) {
			System.out.println("고객 정보가 없습니다.");
			return;
		} else {
			System.out.println();
			System.out.printf("고객 정보 --------------------\n");
			System.out.printf("  고객 이름 : %s\n", buDto.buName);
			System.out.printf("  전화번호  : %s\n", buDto.buTel);
			System.out.printf("  주소      : %s\n", buDto.buAddr);
			System.out.printf("  생년월일  : %s\n", buDto.buBirth);
			System.out.printf("  직업      : %s\n", buDto.buJob);
			System.out.println(Line.sLine(30));
			System.out.println();
			List<AccDto> acList = accService.findByBuId(buId);
			System.out.printf("계좌 리스트\n");
			if (acList.isEmpty()) {
				System.out.println("고객의 계좌 정보가 없습니다.\n");
				System.out.println("  " + Line.sLine(30));
				return;
			}
			System.out.println(Line.sLine(50));
			System.out.println(" 계좌번호\t구분\t\t잔액");
			System.out.println(Line.sLine(50));
			for (AccDto acDto : acList) {

				System.out.printf(" %s\t", acDto.acNum);
				int intDiv = 0;
				try {
					intDiv = Integer.valueOf(acDto.acDiv);
					System.out.printf("%s\t", DBContract.ACC_DIV[intDiv - 1]);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.printf("%s\t", "종류 불명");
				}
				System.out.printf("%s\n", acDto.acBalance);

			}
			System.out.println(Line.sLine(50));
			System.out.println();
		}

	}

	public void makeAcount() {
		/*
		 *  계좌번호 만들기 : 날짜 + 일련번호
		 *  1. 오늘 날짜의 문자열 만들기
		 *  2. 계좌 리스트에 오늘 날짜에 해당하는 값이 있는지 검사
		 *  	있으면 일련번호를 추출하여 + 1 하고 
		 *  	없으면 1로 설정
		 */
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat todayFormat = new SimpleDateFormat("YYYYMMdd");
		// 오늘날짜의 문자열을 만들기(20230524)
		String todayString = todayFormat.format(date);

		System.out.println("\n계좌 생성 시스템 입니다.");
		System.out.println("고객 ID를 입력해 주세요.");
		System.out.print("고객 ID >> ");
		String buId = scan.nextLine();
		BuyerDto buDto = buyerService.findById(buId);
		if (buDto == null) {
			System.out.println("고객 정보가 없습니다.");
			return;
		} else {
			System.out.println();
			System.out.printf("고객 정보 --------------------\n");
			System.out.printf("  고객 이름 : %s\n", buDto.buName);
			System.out.printf("  전화번호  : %s\n", buDto.buTel);
			System.out.printf("  주소      : %s\n", buDto.buAddr);
			System.out.printf("  생년월일  : %s\n", buDto.buBirth);
			System.out.printf("  직업      : %s\n", buDto.buJob);
			System.out.println(Line.sLine(30));
			System.out.println();
			
			String accNum = "";
//			int intAccNum = 0;
//			while (true) {
//				String strAccNum = String.format("%02d", intAccNum);
//				accNum = String.format("%s-%s", todayString, strAccNum);
//				if (accService.findById(accNum) == null) {
//					break;
//				}
//				intAccNum++;
//			}
			
//			List<AccDto> accList = accService.selectAll();
//			int maxNum = 0;
//			for (AccDto dto : accList) {
////				String[] spAccNum = dto.acNum.split("-");
//				String tempDate = dto.acNum.substring(0,todayString.length());
//				// 날짜와 같은 데이터 있으면 일련번호 추출
//				if (tempDate.equals(todayString)) {
//					String strNum = dto.acNum.substring(todayString.length());
//					int intNum = Integer.valueOf(strNum);
//					if (intNum > maxNum) maxNum = intNum;
//
//				}
//			}
//			maxNum++;
			int maxNum = Integer.valueOf(accService.maxAcNum(todayString));
			accNum = String.format("%s%02d", todayString, maxNum + 1);
			

			System.out.println("생성된 계좌 번호");
			System.out.println(" >> " + accNum);
			
			System.out.println("\n생성할 계좌를 입력해 주세요.");
			System.out.println(" 1. 입출금 계좌");
			System.out.println(" 2. 적금 계좌");
			System.out.println(" 3. 대출 계좌");
			System.out.print(" 계좌 구분 >> ");
			String acDiv = scan.nextLine();
			
			try {
				int intAcDiv = Integer.valueOf(acDiv);
				if (intAcDiv < 1 || intAcDiv > 3) {
					System.out.println("1 ~ 3 의 값을 입력해 주세요");
					return;
				} else {
					AccDto accDto = new AccDto();
					accDto.acBuId = buId;
					accDto.acNum = accNum;
					accDto.acDiv = acDiv;
					accDto.acBalance = 10000;

					if (accService.insert(accDto) == 1) {
						System.out.println("\n계좌가 생성되었습니다.\n");
					}
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("정수형으로 입력해 주세요.");
				return;
			}
		}

	}
	/*
	 *  입출금
	 *  입출금 테이블(dto)
	 *  계좌번호, 입금, 출금 변수
	 * 	입금 method -> 해당 계좌의 입금 변수에 값 넣기 (출금엔 0)
	 *  출금 method -> 해당 계좌의 출금 변수에 값 넣기 (입금엔 0)
	 *  잔액 조회 method -> 입출금 dto
	 *  
	 *  
	 */

}
