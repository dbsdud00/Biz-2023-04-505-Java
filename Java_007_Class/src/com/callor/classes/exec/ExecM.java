package com.callor.classes.exec;

import com.callor.classes.exec.module.ServiceD;

public class ExecM {
	public static void main(String[] args) {
		int rndNum1 = (int)(Math.random()*50)+51;
		int rndNum2 = (int)(Math.random()*50)+51;
		
		ServiceD sd = new ServiceD();
		sd.add(rndNum1, rndNum2);
	}
}
