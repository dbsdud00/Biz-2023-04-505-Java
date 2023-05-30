package com.callor.shop.service.impl;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.shop.config.DBConnection;
import com.callor.shop.config.Line;
import com.callor.shop.mapper.BuyerDao;
import com.callor.shop.models.BuyerDto;
import com.callor.shop.service.BuyerService;

public class BuyerServiceImpl implements BuyerService {
	protected List<BuyerDto> bList;
	protected SqlSession sqlSession;
	protected BuyerDao bDao;
	protected Scanner scan;

	public BuyerServiceImpl() {

		sqlSession = DBConnection.getFactory().openSession(true);
		bDao = sqlSession.getMapper(BuyerDao.class);
		scan = new Scanner(System.in);
		
	}
	
	protected String newId() {
		int maxId = 0;
		bList = bDao.selectAll();
		for (BuyerDto bDto : bList) {
			int nowId = Integer.valueOf(bDto.buId);
			if ( nowId > maxId ) {
				maxId = nowId;
			}
		}
		String newId = String.format("%010d", maxId+1);
		return newId;
	}

	@Override
	public List<BuyerDto> BuyerList() {
		bList = bDao.selectAll();
		System.out.println();
		System.out.println(Line.dLine(100));
		System.out.println("고객리스트");
		System.out.println(Line.dLine(100));
		System.out.println("고객ID\t고객이름\t전화번호\t주소");
		System.out.println(Line.sLine(100));
		for (BuyerDto dto : bList) {
			System.out.printf("%s\t", dto.buId);
			System.out.printf("%s\t", dto.buName);
			System.out.printf("%s\t", dto.buTel);
			System.out.printf("%s\n", dto.buAddr);
		}
		System.out.println(Line.sLine(100));
		System.out.println();
		return bList;
	}

	@Override
	public void BuyerUpdate() {
		bList = bDao.selectAll();
		BuyerDto bDto = new BuyerDto();
		boolean insertORUpdate = true;
		System.out.println();
		System.out.println(Line.dLine(100));
		System.out.println("고객 등록 및 수정");
		System.out.println(Line.dLine(100));
		while(true) {
			System.out.println("\t1. 고객 등록");
			System.out.println("\t2. 고객 수정");
			System.out.println(Line.sLine(100));
			System.out.print(">> ");
			String choice = scan.nextLine();
			if (choice.equals("1")) {
				System.out.println("고객 정보 등록을 시작합니다.");
				insertORUpdate = true;
			} else if (choice.equals("2")){
				System.out.println("고객 정보 수정을 시작합니다.");
				insertORUpdate = false;
			} else {
				System.out.println("다시 입력해 주세요");
				continue;
			}
			
			
			
			if (insertORUpdate) {
				bDto.buId = newId();
				System.out.printf("신규 ID (%s) 가 생성되었습니다.\n",bDto.buId);
			} else {
				while(true) {
					
					System.out.print("고객 ID 를 입력해주세요 >> ");
					int findId = 0;
					try {
						findId = Integer.valueOf(scan.nextLine());
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("고객 ID 는 정수형으로 입력해 주세요.");
						continue;
					}
					String buId = String.format("%010d", findId);
					for (BuyerDto dto : bList) {
						if (dto.buId.equals(buId)) {
							bDto = dto;
							break;
						}
					}
					if (bDto == null) {
						System.out.println("찾으시는 고객 정보가 없습니다.");
						continue;
					}
					break;
				}
			}
			while (true) {

				System.out.printf("고객이름(%s) >> ", insertORUpdate ? "신규" : bDto.buName);
				String buName = scan.nextLine();
				if (buName.equals("")) {

				} else {
					bDto.buName = buName;
				}
				break;
			}
			
			while (true) {

				System.out.printf("전화번호(%s) >> ", insertORUpdate ? "신규" : bDto.buTel);
				String buTel = scan.nextLine();
				if (buTel.equals("")) {

				} else {
					bDto.buTel = buTel;
				}
				break;
			}
			while (true) {

				System.out.printf("주소(%s) >> ", insertORUpdate ? "신규" : bDto.buAddr);
				String buAddr = scan.nextLine();
				if (buAddr.equals("")) {
					
				} else {
					bDto.buAddr = buAddr;
				}
				break;
			}
			if (insertORUpdate) {
				bDao.insert(bDto);
				System.out.println("고객 정보 등록이 완료되었습니다.");
			} else {
				bDao.update(bDto);
				System.out.println("고객 정보 수정이 완료되었습니다.");
			}
			break;
			

		}
		System.out.println("고객 정보 등록 및 수정 시스템을 종료합니다.");
		System.out.println();
	}
	
	
	
	
	
	
	
}
