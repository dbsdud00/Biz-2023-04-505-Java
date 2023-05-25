package com.callor.bank.service;

import java.util.List;

import com.callor.bank.models.AccListDto;

public interface AccListService {
	
	public List<AccListDto> selectAll();
	public AccListDto findById(long seq);
	
	// 거래 내역 등록
	public int insert(AccListDto dto);
	
	// 날짜 범위로 검색하기(2개의 날짜 사이 검색)
	public List<AccListDto> findByDateDestance(String sDate, String eDate);
	
	// 계좌 번호로 검색하기
	public List<AccListDto> findByAcNum(String acNum);
	
	// 어떤 계좌의 날짜 범위의 거래 리스트 검색
	public List<AccListDto> findByAcNumAndDateDest(String acNum, String sDate, String eDate);
	
	
	/*
	 *  은행 거래의 특성상 한번 입력된 내용은 수정, 삭제를 금지한다.
	 *  만약 수정 삭제 해야 할 사항이 발생하면
	 *  정정하는 적요를 작성하고 별도로 내역을 추가한다.
	 */
	public int update(AccListDto dto);
	public int delete(Long seq);
	
}
