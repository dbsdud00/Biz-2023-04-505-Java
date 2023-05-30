package com.callor.shop.exec;

import org.apache.ibatis.session.SqlSession;

import com.callor.shop.config.DBConnection;
import com.callor.shop.mapper.BuyerDao;
import com.callor.shop.models.BuyerDto;
import com.callor.shop.models.ProductDto;

public class ShopExecA {
	public static void main(String[] args) {
		SqlSession sqlSession = DBConnection.getFactory().openSession(true);
		
		BuyerDao dao = sqlSession.getMapper(BuyerDao.class);
		
//		ProductDto dto = new ProductDto();
//		dto.pCode = "000000000001";
//		dto.pName = "참크래커";
//		dto.pItem = "과자류";
//		dto.pIPrice = 1500;
//		dto.pOPrice = 1600;
//		dao.update(dto);
		
		BuyerDto bDto = new BuyerDto();
		bDto.buId = String.format("%010d", 2);
		bDto.buName = "성춘향";
		bDto.buTel = "010-556-5555";
		bDto.buAddr = "광주";
		dao.update(bDto);
		
		System.out.println(dao.selectAll().toString());
		
		
	}
}
