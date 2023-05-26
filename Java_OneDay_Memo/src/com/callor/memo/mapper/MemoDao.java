package com.callor.memo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.memo.mapper.sql.MemoSQL;
import com.callor.memo.models.MemoDto;

public interface MemoDao {
	
	@Select(" SELECT * FROM tbl_memo ORDER BY m_seq")
	public List<MemoDto> selectAll();
	
	@Select(" SELECT * FROM tbl_memo WHERE m_seq = #{seq} ")
	public MemoDto findBySeq(int seq);
	
	@Select(" SELECT * FROM tbl_memo WHERE m_writer = #{writer} ")
	public List<MemoDto> findByName(String writer);
	
	@Select(" SELECT * FROM tbl_memo WHERE m_subject = #{subject} ")
	public List<MemoDto> findBySubject(String subject);
	
	@Delete(" DELETE FROM tbl_memo WHERE m_seq = #{seq}")
	public int delete(int seq);
	
	@Insert(MemoSQL.MEMO_INSERT)
	public int insert(MemoDto dto);
	
	@Update(MemoSQL.MEMO_UPDATE)
	public int update(MemoDto dto);
	
}
