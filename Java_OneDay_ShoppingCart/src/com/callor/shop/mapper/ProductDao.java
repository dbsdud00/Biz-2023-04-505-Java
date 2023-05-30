package com.callor.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.callor.shop.mapper.SQL.ProductSQL;
import com.callor.shop.models.ProductDto;

public interface ProductDao {
	
	@Select(" SELECT * FROM tbl_product ORDER BY pCode ")
	public List<ProductDto> selectAll();
	
	@Select(" SELECT * FROM tbl_product WHERE pCode = #{pCode}")
	public ProductDto findByCode(String pCode);
	
	@Select("SELECT * FROM tbl_product WHERE pName LIKE '%' || #{pName} || '%' ")
	public List<ProductDto> findByName(String pName);
	
	@Insert(ProductSQL.PRODUCT_INSERT)
	public int insert(ProductDto dto);
	
	@Update(ProductSQL.PRODUCT_UPDATE)
	public int update(ProductDto dto);
	
	
}
