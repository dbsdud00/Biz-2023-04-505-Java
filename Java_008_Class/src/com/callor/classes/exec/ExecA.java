package com.callor.classes.exec;

import com.callor.classes.module.ServiceA;

public class ExecA {
	public static void main(String[] args) {
		int kor = (int)(Math.random()*50)+51;
		int eng = (int)(Math.random()*50)+51;
		int mat = (int)(Math.random()*50)+51;
		int his = (int)(Math.random()*50)+51;
		int mus = (int)(Math.random()*50)+51;
		int art = (int)(Math.random()*50)+51;
		int phy = (int)(Math.random()*50)+51;
		
		ServiceA sa = new ServiceA();
		sa.score(kor, eng, mat, his, mus, art, phy);
	}
}
