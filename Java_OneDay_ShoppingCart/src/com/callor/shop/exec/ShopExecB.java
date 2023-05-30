package com.callor.shop.exec;

import java.util.Scanner;

import com.callor.shop.config.Line;
import com.callor.shop.mapper.SQL.IOListSQL;
import com.callor.shop.service.BuyerService;
import com.callor.shop.service.IOListService;
import com.callor.shop.service.ProductService;
import com.callor.shop.service.impl.BuyerServiceImpl;
import com.callor.shop.service.impl.IOListServiceImpl;
import com.callor.shop.service.impl.ProductServiceImpl;

public class ShopExecB {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ProductService productService = new ProductServiceImpl();
		BuyerService buyerService = new BuyerServiceImpl();
		IOListService ioService = new IOListServiceImpl();
		System.out.println(Line.dLine(100));
		System.out.println("빛나라 쇼핑몰 2023");
		System.out.println(Line.dLine(100));
		System.out.println("상품관리");
		System.out.println(Line.sLine(50));
		System.out.println("\t1. 상품리스트");
		System.out.println("\t2. 상품등록 및 수정");
		System.out.println("고객관리");
		System.out.println(Line.sLine(50));
		System.out.println("\t3. 고객리스트");
		System.out.println("\t4. 고객 등록 및 수정");
		System.out.println("상품관리");
		System.out.println(Line.sLine(50));
		System.out.println("\t5. 장바구니 상품 담기");
		System.out.println("\t6. 구매자별 장바구니 리스트 보기");
		System.out.println("\t7. 장바구니 전체 리스트 보기");
		System.out.println("\t8. 상품별 리스트 보기");
		System.out.println(Line.sLine(50));
		System.out.println("QUIT. 끝내기");
		System.out.println(Line.dLine(100));
		while(true) {
			System.out.print("선택 >> ");
			String strChoice = scan.nextLine();
			int choice = 0;
			if(strChoice.equals("QUIT")) {
				System.out.println("쇼핑몰을 종료합니다.");
				break;
			}
			try {
				choice = Integer.valueOf(strChoice);
				if (choice < 1 || choice > 8) {
					System.out.println("업무 선택은 1 ~ 8 까지 중에 선택하세요.");
					continue;
				}
			} catch (Exception e) {
				System.out.printf("업무 선택은 QUIT(끝내기), 1 ~ 8 정수만 입력할 수 있습니다.(%s)\n",strChoice);
				continue;
			}
			if (choice == 1) productService.productList();
			else if (choice == 2) productService.productUpdate();
			else if (choice == 3) buyerService.BuyerList();
			else if (choice == 4) buyerService.BuyerUpdate();
			else if (choice == 5) ioService.addCart();
			else if (choice == 6) ioService.showListByBuyer();
			else if (choice == 7) ioService.showAllList();
			else if (choice == 8) ioService.showListByProduct();
		}

	}
}
