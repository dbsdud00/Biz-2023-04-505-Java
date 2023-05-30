package com.callor.shop.mapper.SQL;

public class ProductSQL {
	public static final String PRODUCT_INSERT = 
			"INSERT INTO tbl_product ( "
			+ "    pCode, "
			+ "    pName, "
			+ "    pItem, "
			+ "    pIPrice, "
			+ "    pOprice ) "
			+ " VALUES (#{pCode},#{pName},#{pItem},#{pIPrice},#{pOPrice}) ";
	
	public static final String PRODUCT_UPDATE = 
			"UPDATE tbl_product  "
			+ " SET pCode = #{pCode}, "
			+ "    pName = #{pName}, "
			+ "    pItem = #{pItem}, "
			+ "    pIPrice = #{pIPrice}, "
			+ "    pOprice = #{pOPrice} "
			+ " WHERE pCode = #{pCode} ";

			
}
