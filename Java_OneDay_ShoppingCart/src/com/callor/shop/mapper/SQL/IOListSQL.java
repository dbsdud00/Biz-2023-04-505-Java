package com.callor.shop.mapper.SQL;

public class IOListSQL {
	public static final String IOLIST_INSERT = 
			"INSERT INTO tbl_iolist ( "
			+ "    ioSEQ, "
			+ "    ioDate, "
			+ "    ioTime, "
			+ "    ioBuId, "
			+ "    ioPCode, "
			+ "    ioQuan, "
			+ "    ioPrice ) "
			+ " VALUES (seq_num.NEXTVAL,#{ioDate},#{ioTime},#{ioBuId},#{ioPCode},#{ioQuan},#{ioPrice}) ";
	

}
