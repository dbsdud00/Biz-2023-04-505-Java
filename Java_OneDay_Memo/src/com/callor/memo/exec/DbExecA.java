package com.callor.memo.exec;

import org.apache.ibatis.session.SqlSession;

import com.callor.memo.config.DBConnection;
import com.callor.memo.mapper.MemoDao;
import com.callor.memo.models.MemoDto;

public class DbExecA {
	public static void main(String[] args) {
		SqlSession sqlSession = DBConnection.getFactory().openSession(true);
		
		MemoDao mDao = sqlSession.getMapper(MemoDao.class);
		
		MemoDto mDto = new MemoDto();
		
		
		mDto.m_writer = "최윤영";
		mDto.m_date = "2023-05-26";
		mDto.m_subject = "아무말";
		mDto.m_content = "놀이 황금시대를 것은 생생하며, 그와 뭇 간에 부패뿐이다. 찾아다녀도, 피고 원대하고, 보라. 커다란 과실이 가는 이것은 운다. 산야에 반짝이는 힘차게 끝에 새 것이다. 방지하는 우는 심장의 것이다.";
		
		int result = mDao.insert(mDto);
		if(result > 0 ) {
			System.out.println("성공");
			System.out.println(mDao.selectAll().toString());
		}
		System.out.println(mDao.selectAll().toString());
	}
}
