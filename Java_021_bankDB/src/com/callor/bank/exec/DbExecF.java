package com.callor.bank.exec;

import com.callor.bank.service.AccService;
import com.callor.bank.service.BankService;
import com.callor.bank.service.impl.AccServiceV1;

public class DbExecF {
	public static void main(String[] args) {
		AccService accService = new AccServiceV1();
		BankService bank = new BankService();
		System.out.println(accService.selectAll().toString());
//		System.out.println(accService.findByBuId("0003"));
	}
}
