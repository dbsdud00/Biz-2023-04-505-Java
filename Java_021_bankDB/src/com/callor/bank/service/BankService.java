package com.callor.bank.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.callor.bank.config.DBContract;
import com.callor.bank.models.AccDto;
import com.callor.bank.models.AccListDto;
import com.callor.bank.models.BuyerDto;
import com.callor.bank.service.impl.AccListServiceImplV1;
import com.callor.bank.service.impl.AccServiceV1;
import com.callor.bank.service.impl.BuyerServiceImplV1;
import com.callor.bank.utils.Line;

public class BankService {

	protected final Scanner scan;
	protected List<BuyerDto> buyerList;
	protected final BuyerService buyerService;
	protected final AccService accService;
	protected final AccListService accListService;

	public BankService() {
		scan = new Scanner(System.in);
		buyerService = new BuyerServiceImplV1();
		accService = new AccServiceV1();
		accListService = new AccListServiceImplV1();
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
		 * 계좌번호 만들기 : 날짜 + 일련번호 1. 오늘 날짜의 문자열 만들기 2. 계좌 리스트에 오늘 날짜에 해당하는 값이 있는지 검사 있으면
		 * 일련번호를 추출하여 + 1 하고 없으면 1로 설정
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

	public void insertAccList1() {

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat todayFormat = new SimpleDateFormat("YYYY-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		// 오늘날짜의 문자열을 만들기(20230524)
		String todayString = todayFormat.format(date);
		String timeString = timeFormat.format(date);

		this.printBuyerList();

		System.out.println("\n고객ID를 입력해 주세요.");
		System.out.print("고객 ID >> ");
		String buId = scan.nextLine();
		List<AccDto> acList = accService.findByBuId(buId);
		System.out.printf("\n계좌 리스트\n");
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

		// 고객 리스트, id입력 , 계좌 리스트 출력

		AccListDto dto = new AccListDto();
		System.out.println("거래를 원하시는 계좌번호를 입력해 주세요");
		System.out.println("(거래를 종료하시려면 Enter를 눌러주세요)");
		System.out.print(">> ");
		String acNum = scan.nextLine();
		if (acNum.equals("")) {
			System.out.println("거래를 종료합니다.");
			return;
		}

		AccDto accDto = null;
		for (AccDto acDto : acList) {
			if (acDto.acNum.equals(acNum)) {
				dto.acNum = acNum;
				dto.aioDate = todayString;
				dto.aioTime = timeString;
				accDto = acDto;
			}
		}
		if (accDto == null) {
			System.out.println("해당 계좌가 없습니다.");
			System.out.println("거래를 종료합니다.");
			return;
		}

		System.out.println("\n원하시는 거래 종류를 입력해 주세요");
		System.out.println("1. 입금");
		System.out.println("2. 출금");
		System.out.println("3. 종료");
		System.out.print(">> ");
		String aioDiv = scan.nextLine();

		while (true) {
			try {
				if (aioDiv.equals("1")) {
					dto.aioDiv = aioDiv;
					System.out.println("\n입금하실 금액을 입력해 주세요.");
					System.out.print("금액 입력 >> ");
					int aioInput = Integer.valueOf(scan.nextLine());
					dto.aioInput = aioInput;
					accDto.acBalance += aioInput;
				} else if (aioDiv.equals("2")) {
					dto.aioDiv = aioDiv;
					System.out.println("\n출금하실 금액을 입력해 주세요.");
					System.out.print("금액 입력 >> ");
					int aioOutput = Integer.valueOf(scan.nextLine());
					dto.aioOutput = aioOutput;
					if (aioOutput > accDto.acBalance) {
						System.out.println("잔액이 부족합니다.");
						System.out.println("거래를 종료합니다.");
						return;
					}
					accDto.acBalance -= aioOutput;
				} else if (aioDiv.equals("3")) {
					System.out.println("거래를 종료합니다.");
					return;
				} else {
					System.out.println("원하시는 거래 종류를 다시 입력해 주세요");
					continue;
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("금액은 정수형으로 입력해 주세요");
				continue;
			}

			if (accListService.insert(dto) == 1) {
				accService.update(accDto);
				System.out.println("\n거래가 완료되었습니다.\n");

				System.out.println(Line.sLine(100));
				System.out.println("계좌번호\t잔액\t거래일자\t거래시각\t거래구분\t입금액\t출금액\t적요");
				System.out.println(Line.sLine(100));

				List<AccListDto> aclList = accListService.findByAcNum(dto.acNum);
				for (AccListDto aclDto : aclList) {
					System.out.printf("%s\t", aclDto.acNum);
					System.out.printf("%s\t", accDto.acBalance);
					System.out.printf("%s\t", aclDto.aioDate);
					System.out.printf("%s\t", aclDto.aioTime);
					System.out.printf("%s\t\t", aclDto.aioDiv);
					System.out.printf("%s\t", aclDto.aioInput);
					System.out.printf("%s\t", aclDto.aioOutput);
					System.out.printf("%s\n", aclDto.aioREM);
				}
				System.out.println(Line.sLine(100));
				return;
			} else {
				System.out.println("\n거래를 실패했습니다.");
				System.out.println("다시 시작해 주세요");
				return;
			}

		}

	}

	public void insertAccList() {

		// 고객 정보 확인
		findUserInfo();

		while (true) {

			System.out.println(Line.sLine(100));
			System.out.println("입출금 등록");
			System.out.println(Line.sLine(100));
			System.out.print("계좌번호 >> ");
			String acNum = scan.nextLine();
			// 계좌번호를 사용하여 tbl_acc 테이블에서 데이터 조회
			// accDto 에는 acNum 계좌번호에 해당하는 데이터가 모두 담긴 상태
			AccDto accDto = accService.findById(acNum);
			if (accDto == null) {
				System.out.printf("계좌번호를 확인하세요.(%s)\n", acNum);
				continue;
			}
			System.out.print("거래 구분 (1: 입금 , 2: 출금 , -1: 종료) >> ");
			String aioDiv = scan.nextLine();
			int intDiv = 0;
			try {
				intDiv = Integer.valueOf(aioDiv);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.printf("선택이 잘못되었습니다.(%s)\n", aioDiv);
				continue;
			}
			if (intDiv == -1) {
				System.out.println("입출금 업무 중단");
				break;
			}
			if (intDiv != 1 && intDiv != 2) {
				System.out.println("1: 입금, 2: 출금 중에서 선택하세요.");
				continue;
			}
			String[] divs = { "입금", "출금" };
			int intAmt = 0;
			while (true) {
				String prompt = divs[intDiv - 1];
				System.out.printf("%s (QUIT:종료) >> ", prompt);
				String amount = scan.nextLine();
				if(amount.equals("QUIT")) {
					intAmt = -1;
					break;
				}
				try {
					intAmt = Integer.valueOf(amount);
				} catch (Exception e) {
					System.out.printf("%s 금액은 정수(숫자)로 입력해 주세요\n", prompt);
					continue;
				}
				if (aioDiv.equals("2")) {
					int balance = accDto.acBalance;
					if(balance < intAmt) {
						System.out.printf("잔액(%d) 가 부족하여 출금할 수 없음",balance);
						continue;
					}
				}
				break;
			} // 입출금 입력 while end
			if (intAmt < 0) break;
			AccListDto ioDto = new AccListDto();

			Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

			ioDto.aioDate = dateFormat.format(date);
			ioDto.aioTime = timeFormat.format(date);

			ioDto.aioDiv = aioDiv;
			ioDto.acNum = acNum;

			if (aioDiv.equals("1")) {
				ioDto.aioInput = intAmt;
			} else if (aioDiv.equals("2")) {
				ioDto.aioOutput = intAmt;
				intAmt *= -1;
			}

			accListService.insert(ioDto);
			accDto.acBalance = accDto.acBalance + intAmt;
			
			accService.update(accDto);
			System.out.println("거래가 종료되었습니다.");
			break;
		}
	}
}
