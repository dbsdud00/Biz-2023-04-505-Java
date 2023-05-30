package com.callor.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.shop.mapper.SQL.BuyerSQL;
import com.callor.shop.models.BuyerDto;

public interface BuyerDao {
	
	@Select(" SELECT buId, buName, buTel, buAddr FROM tbl_buyer ORDER BY buName ")
	public List<BuyerDto> selectAll();
	
	@Insert(BuyerSQL.BUYER_INSERT)
	public int insert(BuyerDto dto);
	
	@Update(BuyerSQL.BUYER_UPDATE)
	public int update(BuyerDto dto);
	
	@Select(" SELECT buId, buName, buTel, buAddr FROM tbl_buyer WHERE buId = #{buId} ")
	public BuyerDto findByID(String buId);
	
	@Select(" SELECT buId, buName, buTel, buAddr FROM tbl_buyer WHERE buName "
			+ " LIKE '%' || #{buName} || '%' ORDER BY buId ")
	public List<BuyerDto> findByName();
	
	
}
