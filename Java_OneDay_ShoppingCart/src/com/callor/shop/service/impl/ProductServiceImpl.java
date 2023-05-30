package com.callor.shop.service.impl;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import com.callor.shop.config.DBConnection;
import com.callor.shop.config.Line;
import com.callor.shop.mapper.ProductDao;
import com.callor.shop.models.ProductDto;
import com.callor.shop.service.ProductService;

public class ProductServiceImpl implements ProductService {
	protected List<ProductDto> pList;
	protected SqlSession sqlSession;
	protected ProductDao pDao;
	protected Scanner scan;

	public ProductServiceImpl() {
		sqlSession = DBConnection.getFactory().openSession(true);
		pDao = sqlSession.getMapper(ProductDao.class);
		scan = new Scanner(System.in);
	}

	@Override
	public List<ProductDto> productList() {
		pList = pDao.selectAll();
		System.out.println();
		System.out.println(Line.dLine(100));
		System.out.println("상품리스트");
		System.out.println(Line.dLine(100));
		System.out.println("상품코드\t상품명\t품목\t매입단가\t매출단가");
		System.out.println(Line.sLine(100));
		for (ProductDto dto : pList) {
			System.out.printf("%s\t", dto.pCode);
			System.out.printf("%s\t", dto.pName);
			System.out.printf("%s\t", dto.pItem);
			System.out.printf("%d\t\t", dto.pIPrice);
			System.out.printf("%d\n", dto.pOPrice);
		}
		System.out.println(Line.sLine(100));
		System.out.println();
		
		return pList;
	}

	@Override
	public void productUpdate() {
		pList = pDao.selectAll();
		ProductDto pDto = new ProductDto();
		boolean insertORUpdate = true;
		System.out.println();
		System.out.println(Line.dLine(100));
		System.out.println("상품 등록 및 수정");
		System.out.println(Line.dLine(100));
		while (true) {
			System.out.print("상품코드를 입력해 주세요 >> ");
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
					insertORUpdate = false;
					pDto = dto;
					break;
				}
			}
			System.out.println(Line.sLine(100));
			if (insertORUpdate) {
				System.out.println("상품 등록을 시작합니다.");
			} else {
				System.out.println("상품 수정을 시작합니다.");
			}
			System.out.println(Line.sLine(100));
			pDto.pCode = pCode;

			while (true) {
				System.out.printf("상품명(%s) >> ", insertORUpdate ? "신규" : pDto.pName);
				String pName = scan.nextLine();
				if (pName.equals("")) {
					if (insertORUpdate) {
						System.out.println("상품명을 등록해 주세요");
						continue;
					}
				} else {
					pDto.pName = pName;
				}
				break;
			}

			while (true) {

				System.out.printf("품목(%s) >> ", insertORUpdate ? "신규" : pDto.pItem);
				String pItem = scan.nextLine();
				if (pItem.equals("")) {
					if (insertORUpdate) {
						System.out.println("품목을 등록해 주세요");
						continue;
					}
				} else {
					pDto.pItem = pItem;
				}
				break;
			}

			while (true) {
				System.out.printf("매입단가(%s) >> ", insertORUpdate ? "신규" : pDto.pIPrice);
				String strPIPrice = scan.nextLine();
				int pIPrice = 0;
				if (strPIPrice.equals("")) {
					if (insertORUpdate) {
						System.out.println("매입단가를 등록해 주세요.");
						continue;
					} 
				} else {
					try {
						pIPrice = Integer.valueOf(strPIPrice);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("매입단가는 정수형으로 입력해 주세요");
						continue;
					}
					pDto.pIPrice = pIPrice;
					pDto.pOPrice = ((int)(pIPrice + (pIPrice * 0.22))/10)*10 ;
				}
				break;
			}
			
			if (insertORUpdate) {
				pDao.insert(pDto);
				System.out.println("상품 등록이 완료되었습니다.");
			} else {
				pDao.update(pDto);
				System.out.println("상품 수정이 완료되었습니다.");
			}
			break;
		}
		System.out.println("상품 등록 및 수정 시스템을 종료합니다.");
		System.out.println();
	}
	
	

}
