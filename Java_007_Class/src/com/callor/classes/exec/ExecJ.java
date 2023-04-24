package com.callor.classes.exec;

import com.callor.classes.exec.module.ServiceA;

public class ExecJ {
	
	public static void main(String[] args) {
		ServiceA SA = new ServiceA();
		
		int rndNum1 = (int)(Math.random()*50)+51;
		int rndNum2 = (int)(Math.random()*50)+51;
		
		int result = SA.add(rndNum1,rndNum2);
		System.out.printf("%d + %d = %d\n",rndNum1, rndNum2, result);
	}
	
	
}
