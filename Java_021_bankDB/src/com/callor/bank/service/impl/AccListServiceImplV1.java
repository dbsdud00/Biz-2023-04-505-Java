package com.callor.bank.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.bank.config.DBConnection;
import com.callor.bank.config.DBContract;
import com.callor.bank.models.AccDto;
import com.callor.bank.models.AccListDto;
import com.callor.bank.service.AccListService;

public class AccListServiceImplV1 implements AccListService {

	Connection dbConn = null;
	
	public AccListServiceImplV1() {
		dbConn = DBConnection.getDBConn();
	}
	
	
	protected AccListDto result2Dto(ResultSet result) throws SQLException {
		
		AccListDto accListDto = new AccListDto();
		accListDto.aioSEQ = result.getInt(DBContract.ACCLIST.AIO_SEQ);
		accListDto.acNum = result.getNString(DBContract.ACCLIST.AIO_NUM);
		accListDto.aioDate = result.getNString(DBContract.ACCLIST.AIO_DATE);
		accListDto.aioTime = result.getNString(DBContract.ACCLIST.AIO_TIME);
		accListDto.aioDiv = result.getNString(DBContract.ACCLIST.AIO_DIV);
		accListDto.aioInput = result.getInt(DBContract.ACCLIST.AIO_INPUT);
		accListDto.aioOutput = result.getInt(DBContract.ACCLIST.AIO_OUTPUT);
		accListDto.aioREM = result.getNString(DBContract.ACCLIST.AIO_REM);
		return accListDto;

	}
	
	public List<AccListDto> db2List(PreparedStatement pStr) throws SQLException {
		List<AccListDto> accListList = new ArrayList<>();
	
		ResultSet result = pStr.executeQuery();
		while(result.next()) { 
			AccListDto accListDto = result2Dto(result);
			accListList.add(accListDto);
		}
		pStr.close();
		result.close();
		return accListList;


	}
	
	
	
	@Override
	public List<AccListDto> selectAll() {

		return null;
	}

	@Override
	public AccListDto findById(long seq) {
		
		return null;
	}

	@Override
	public int insert(AccListDto dto) {
		String sql = "INSERT INTO tbl_accList "
				+ " (aioSEQ, "
				+ " acNUM, aioDate, aiotime, "
				+ " aiodiv, aioinput, aiooutput) "
				+ " VALUES( "
				+ " seq_accList.NEXTVAL, "
				+ " ? , ? , ? , " 	// 계좌번호, 거래일자, 거래시각	
				+ " ? , ? , ? ) ";	// 거래구분(1: 입금, 2:출금), 입금액, 출금액
		
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, dto.acNum);
			pStr.setString(2, dto.aioDate);
			pStr.setString(3, dto.aioTime);
			pStr.setString(4, dto.aioDiv);
			pStr.setInt(5, dto.aioInput);
			pStr.setInt(6, dto.aioOutput);
			
			// 쿼리 실행하는 method
			// SELECT : excuteAuery();
			// INSERT, UPDATE, DELETE : executeUpdate();
			return pStr.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<AccListDto> findByDateDestance(String sDate, String eDate) {
		
		return null;
	}

	@Override
	public List<AccListDto> findByAcNum(String acNum) {
		
		String sql = "SELECT aioSEQ, acNUM, aioDate, aiotime, aiodiv, aioinput, aiooutput,aiorem "
				+ " FROM tbl_accList "
				+ " WHERE acNum = ? ";
		
		PreparedStatement pStr;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, acNum);
			return db2List(pStr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<AccListDto> findByAcNumAndDateDest(String acNum, String sDate, String eDate) {
		
		return null;
	}

	@Override
	public int update(AccListDto dto) {
		
		return 0;
	}

	@Override
	public int delete(Long seq) {
		
		return 0;
	}

}
