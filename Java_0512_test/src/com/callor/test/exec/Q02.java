package com.callor.test.exec;

import com.callor.test.service.GuideService;
import com.callor.test.service.GuideServiceImplV1;

public class Q02 {
	public static void main(String[] args) {
		GuideService gdServ = new GuideServiceImplV1();
		gdServ.loadGuide();
		gdServ.printGuideList();
	}
}
