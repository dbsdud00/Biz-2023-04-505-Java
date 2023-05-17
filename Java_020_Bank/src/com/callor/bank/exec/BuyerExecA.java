package com.callor.bank.exec;

import com.callor.bank.service.BuyerService;
import com.callor.bank.service.impl.BuyerServiceImplV1C;

public class BuyerExecA {
	public static void main(String[] args) {
		BuyerService buServ = new BuyerServiceImplV1C();
		buServ.loadBuyer();
		buServ.inputBuyer();
		/*
		 *  printBuyerList() 에 전달할 출력 방향을 화면으로 지정하여 전달
		 *  PrintWriter out  = new PrintWriter(System.out);
		 *  
		 *  "내파일"에 저장하기
		 *  OutputSteram os = new FileOutputStream("내파일");
		 *  PrintWriter out = new PrintWriter(os);
		 */
		// PrintWriter out = new PrintWriter(System.out);
		// buServ.printBuyerList(out);
		// out.close();
		buServ.printBuyerList();
	}
}
 