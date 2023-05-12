package com.callor.test.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.test.model.GuideDto;

public class GuideServiceImplV1 implements GuideService {

	List<GuideDto> guideList;
	public GuideServiceImplV1() {
		guideList = new ArrayList<>();
	}
	@Override
	public void loadGuide() {
		// TODO Auto-generated method stub
		String guideFile = "src/com/callor/test/data/guide.txt";
		InputStream is = null;
		Scanner scan = null;
		
		try {
			is = new FileInputStream(guideFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scan = new Scanner(is);
		
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] guideStr = line.split(",");
			GuideDto gdDto = new GuideDto(
					guideStr[0],
					guideStr[1],
					Integer.valueOf(guideStr[2]),
					guideStr[3]
					);
//			gdDto.guideId = guideStr[DataIndex.GUIDE.GUIDEID];
//			gdDto.guideName = guideStr[DataIndex.GUIDE.GUIDENAME];
//			gdDto.guideSeq = guideStr[DataIndex.GUIDE.GUIDESEQ];
//			gdDto.guideDes = guideStr[DataIndex.GUIDE.GUIDEDESCRIP];
			
			guideList.add(gdDto);
		}
		scan.close();
	}

	@Override
	public void printGuideList() {
		String[] printIndex = "id,종목명,순서,가이드".split(",");
		// TODO Auto-generated method stub
		System.out.println("=".repeat(120));
		System.out.printf("%-5s\t",printIndex[0]);
		System.out.printf("%-20s\t\t\t",printIndex[1]);
		System.out.printf("%4s\t\t",printIndex[2]);
		System.out.printf("%s\n",printIndex[3]);
		System.out.println("-".repeat(120));
		
		String id = guideList.get(0).guideId;
		
		for (GuideDto gdDto : guideList) {
			if (!(id.equals(gdDto.guideId))) {
				id = gdDto.guideId;
				System.out.println("-".repeat(120));
			}

			System.out.printf("%-5s\t",gdDto.guideId);
			System.out.printf("%-20s\t\t",gdDto.guideName);
			System.out.printf("%4d회\t\t",gdDto.guideSeq);
			System.out.printf("%s\n",gdDto.guideDes);

		}
		
		System.out.println("=".repeat(120));
	}

}
