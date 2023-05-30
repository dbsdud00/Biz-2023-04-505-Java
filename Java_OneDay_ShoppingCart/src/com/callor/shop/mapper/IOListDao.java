package com.callor.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.callor.shop.mapper.SQL.IOListSQL;
import com.callor.shop.models.IOListDto;

public interface IOListDao {
	
	@Select(" SELECT ioSEQ, ioDate, ioTime, ioBuId,ioPCode,ioQuan,ioPrice FROM tbl_iolist ORDER BY ioSEQ ")
	public List<IOListDto> SelectAll();
	
	@Insert(IOListSQL.IOLIST_INSERT)
	public int insert(IOListDto dto);
	
	@Select(" SELECT ioSEQ, ioDate, ioTime, ioBuId,ioPCode,ioQuan,ioPrice FROM tbl_iolist WHERE ioBuid = #{buid}   ")
	public List<IOListDto> findBybuId(String buid);
	
	@Select(" SELECT ioSEQ, ioDate, ioTime, ioBuId,ioPCode,ioQuan,ioPrice FROM tbl_iolist WHERE ioPCode = #{ioPCode}   ")
	public List<IOListDto> findByProduct(String ioPCode);
	
	@Select(" SELECT * FROM tbl_iolist WHERE ioDate BETWEEN #{startDate} AND #{endDate}  ")
	public List<IOListDto> findByPeriod(String startDate, String endDate);
	
}
