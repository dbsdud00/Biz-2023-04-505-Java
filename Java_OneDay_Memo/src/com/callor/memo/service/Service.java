package com.callor.memo.service;

import com.callor.memo.models.MemoDto;

public interface Service {
	// 전체 메모 목록 불러오기
	public void LoadMemo();
	
	// 선택한 메모 불러오기
	public MemoDto ReadMemo();
	
	// 새로 만들기
	public void NewMemo();
	
	// 메모 수정하기
	public void UpdateMemo();

	
	// 메모 삭제하기
	public void DeleteMemo();
}
