package com.callor.shop.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.shop.config.DBConnection;
import com.callor.shop.config.Line;
import com.callor.shop.mapper.BuyerDao;
import com.callor.shop.mapper.IOListDao;
import com.callor.shop.mapper.ProductDao;
import com.callor.shop.models.BuyerDto;
import com.callor.shop.models.IOListDto;
import com.callor.shop.models.ProductDto;
import com.callor.shop.service.BuyerService;
import com.callor.shop.service.IOListService;
import com.callor.shop.service.ProductService;

public class IOListServiceImpl implements IOListService {
	
	protected Scanner scan;
	protected SqlSession sqlSession;
	BuyerService buServ;
	ProductService proServ;
	IOListDao ioDao;
	BuyerDao bDao;
	ProductDao pDao;
	
	public IOListServiceImpl() {
		scan = new Scanner(System.in);
		sqlSession = DBConnection.getFactory().openSession(true);
		buServ = new BuyerServiceImpl();
		proServ = new ProductServiceImpl();
		ioDao = sqlSession.getMapper(IOListDao.class);
		bDao = sqlSession.getMapper(BuyerDao.class);
		pDao = sqlSession.getMapper(ProductDao.class);
	}
	
	@Override
	public void addCart() {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat todayFormat = new SimpleDateFormat("YYYY-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		String todayString = todayFormat.format(date);
		String timeString = timeFormat.format(date);
		
		
		
		
		System.out.println();
		System.out.println(Line.dLine(100));
		System.out.println("장바구니 상품 담기");
		System.out.println(Line.dLine(100));
		IOListDto IODto = new IOListDto();
		List<BuyerDto> bList = buServ.BuyerList();
		
		while(true) {
			System.out.printf("고객 ID를 입력해 주세요 >> ");
			int intBuId = 0;
			try {
				intBuId = Integer.valueOf(scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("고객 ID는 정수형으로 입력해 주세요");
				continue;
			}
			String buId = String.format("%010d", intBuId);
			for (BuyerDto dto : bList ) {
				if (dto.buId.equals(buId)) {
					IODto.ioBuId = buId;
					break;
				}
			}
			if (IODto.ioBuId == null) {
				System.out.println("입력하신 고객 ID 의 정보가 없습니다. 다시 입력해 주세요");
				continue;

			}
			
			break;
		}
		List<ProductDto> pList = proServ.productList();
		while(true) {
			System.out.print("원하시는 상품 코드를 입력해 주세요 >> ");
			String strPCode = scan.nextLine();
			int intPCode = 0;
			try {
				intPCode = Integer.valueOf(strPCode);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("상품코드는 정수형으로 입력해 주세요");
				continue;
			}
			String pCode = String.format("%012d", intPCode);
			for (ProductDto dto : pList) {
				if (dto.pCode.equals(pCode)) {
					IODto.ioPCode = pCode;
					while(true) {
						
						System.out.println("수량을 입력해 주세요 >> ");
						int ioQuan = 0;
						try {
							ioQuan = Integer.valueOf(scan.nextLine());
							
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("수량은 정수로 입력해 주세요");	
						}
						IODto.ioQuan = ioQuan;
						break;
					}
					IODto.ioPrice = dto.pOPrice;
					break;
				}
				
			}
			if (IODto.ioPCode == null) {
				System.out.println("입력하신 상품코드의 정보가 없습니다. 다시 입력해 주세요");
				continue;
			}
			break;
		}
		
		IODto.ioDate = todayString;
		IODto.ioTime = timeString;
		
		ioDao.insert(IODto);
		
		System.out.println("상품 담기를 완료되었습니다.");
		
	}
	

	@Override
	public void showListByBuyer() {
		System.out.println();
		System.out.println(Line.dLine(100));
		System.out.println("구매자별 장바구니 리스트 보기");
		System.out.println(Line.dLine(100));
		IOListDto IODto = new IOListDto();
		String buId = "";
		List<BuyerDto> bList = buServ.BuyerList();
		
		while(true) {
			System.out.printf("고객 ID를 입력해 주세요 >> ");
			int intBuId = 0;
			try {
				intBuId = Integer.valueOf(scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("고객 ID는 정수형으로 입력해 주세요");
				continue;
			}
			buId = String.format("%010d", intBuId);
			for (BuyerDto dto : bList ) {
				if (dto.buId.equals(buId)) {
					IODto.ioBuId = buId;
					break;
				}
			}
			if (IODto.ioBuId == null) {
				System.out.println("입력하신 고객 ID 의 정보가 없습니다. 다시 입력해 주세요");
				continue;
			}

			break;
		}
		List<IOListDto> dtoList = ioDao.findBybuId(buId);
		System.out.println(Line.dLine(100));
		System.out.println("SEQ\t거래일자\t거래시각\t고객ID\t상품코드\t수량\t판매단가");
		System.out.println(Line.sLine(100));
		for (IOListDto dto : dtoList) {
			System.out.printf("%d\t",dto.ioSEQ);
			System.out.printf("%s\t",dto.ioDate);
			System.out.printf("%s\t",dto.ioTime);
			System.out.printf("%s\t",dto.ioBuId);
			System.out.printf("%s\t",dto.ioPCode);
			System.out.printf("%d\t",dto.ioQuan);
			System.out.printf("%d\n",dto.ioPrice);
		}
		System.out.println(Line.dLine(100));
		System.out.println();
		
		
		
		
		
	}

	@Override
	public void showAllList() {
		System.out.println();
		System.out.println(Line.dLine(100));
		System.out.println("장바구니 전체 리스트 보기");
		System.out.println(Line.dLine(100));
		List<IOListDto> dtoList = ioDao.SelectAll();
		BuyerDto bDto = null;
		ProductDto pDto = null;
		System.out.println(Line.dLine(100));
		System.out.println("상품판매리스트");
		System.out.println(Line.dLine(100));
		System.out.println("거래일자\t거래시각\t고객ID\t고객이름\t전화번호\t상품코드\t상품명\t판매단가\t수량\t판매합계");
		System.out.println(Line.sLine(100));
		for (IOListDto dto : dtoList) {
			bDto = bDao.findByID(dto.ioBuId);
			pDto = pDao.findByCode(dto.ioPCode);
			System.out.printf("%s\t",dto.ioDate);
			System.out.printf("%s\t",dto.ioTime);
			System.out.printf("%s\t",dto.ioBuId);
			System.out.printf("%s\t",bDto.buName);
			System.out.printf("%s\t",bDto.buTel);
			System.out.printf("%s\t",dto.ioPCode);
			System.out.printf("%s\t",pDto.pName);
			System.out.printf("%d\t",dto.ioPrice);
			System.out.printf("%d\t",dto.ioQuan);
			System.out.printf("%d\n",dto.ioQuan * dto.ioPrice);
		}
		System.out.println(Line.dLine(100));
		System.out.println();
		
	}

	@Override
	public void showListByProduct() {
		// TODO Auto-generated method stub
		List<IOListDto> dtoList = null;
		List<ProductDto> pList = proServ.productList();
		System.out.printf("리스트를 확인하실 상품명을 입력하세요 >> ");
		String pName = scan.nextLine();
		BuyerDto bDto = null;
		System.out.println(Line.dLine(100));
		System.out.println("상품별 판매리스트");
		System.out.println(Line.dLine(100));
		System.out.println("거래일자\t거래시각\t고객ID\t고객이름\t전화번호\t상품코드\t상품명\t판매단가\t수량\t판매합계");
		System.out.println(Line.sLine(100));
		for (ProductDto pDto : pList) {
			if (pDto.pName.equals(pName)) {
				dtoList = ioDao.findByProduct(pDto.pCode);
				for (IOListDto dto : dtoList) {
					bDto = bDao.findByID(dto.ioBuId);
					pDto = pDao.findByCode(dto.ioPCode);
					System.out.printf("%s\t",dto.ioDate);
					System.out.printf("%s\t",dto.ioTime);
					System.out.printf("%s\t",dto.ioBuId);
					System.out.printf("%s\t",bDto.buName);
					System.out.printf("%s\t",bDto.buTel);
					System.out.printf("%s\t",dto.ioPCode);
					System.out.printf("%s\t",pDto.pName);
					System.out.printf("%d\t",dto.ioPrice);
					System.out.printf("%d\t",dto.ioQuan);
					System.out.printf("%d\n",dto.ioQuan * dto.ioPrice);
				}
			}
		}
		System.out.println(Line.dLine(100));
		System.out.println();
	}





}
