package com.callor.bank.exec;

import com.callor.bank.service.AccService;
import com.callor.bank.service.impl.AccServiceImplV1A;

public class AccExecA {
	public static void main(String[] args) {
		AccService accServ = new AccServiceImplV1A();
		accServ.accInit();
	}
}
