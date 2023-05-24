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
import com.callor.bank.service.AccService;

public class AccServiceV1 implements AccService {

	// DB 에 연결 session 을 구축하는 도구
	protected final Connection dbConn;
	public AccServiceV1() {
		// dbConn 도구를 이미 만들어 둔 DBConnection 클래스 코드를 사용하여 초기화 한다.
		dbConn = DBConnection.getDBConn(); // DB 접속
	}
	
	/*
	 * throws ...
	 * try ... catch ... 으로 처리해야 하는 코드가 있을 경우
	 * 직접 처리하지 않고 이 method를 호출한 곳으로 exception을 대리 처리하도록 하는 조치
	 */
	// 여기서 exception 이 발생해도 여기서 처리 안하고 나를 호출한 곳에서 처리할 것임 -> throws
	protected AccDto result2Dto(ResultSet result) throws SQLException {
	
		AccDto accDto = new AccDto();
		accDto.acNum = result.getNString(DBContract.ACC.ACC_NUM);
		accDto.acDiv = result.getNString(DBContract.ACC.ACC_DIV);
		accDto.acBuId = result.getNString(DBContract.ACC.ACC_BUID);
		// SELECT 된 데이터의 type 이 확실하게 tntwkgud(특히 정수형)인 경우
		// getInt() method 를 사용하여 직접 정수형으로 변환 후 받을 수 있다.
		accDto.acBalance = result.getInt(DBContract.ACC.ACC_BALANCE);	
		return accDto;

	}
	
	public List<AccDto> db2List(PreparedStatement pStr) throws SQLException {
		List<AccDto> accList = new ArrayList<>();
	
		ResultSet result = pStr.executeQuery(); // 아직까지 데이터가 온것은 아님
		while(result.next()) { // 데이터가 있으면 한줄의 데이터를 보내달라 
			AccDto accDto = result2Dto(result);
			accList.add(accDto);
		}
		pStr.close();
		result.close();
		return accList;


	}
	
	
	/*
	 *  selectAll() method
	 *  1. DMBS 에 접속
	 *  2. tbl_acc Table 의 전체 데이터를 select
	 *  3. List<AccDto> type 으로 변환하여 return
	 */
	@Override
	public List<AccDto> selectAll() {
		
		String sql = " SELECT acnum, acdiv, acbuid, acbalance "
				+ " FROM tbl_acc "
				+ " ORDER BY acnum "; // acnum으로 정렬
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			List<AccDto> accList = db2List(pStr);
			return accList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public AccDto findById(String acNum) {
		// TODO Auto-generated method stub
		String sql = " SELECT acnum, acdiv, acbuid, acbalance "
				+ " FROM tbl_acc "
				+ " WHERE acnum = ? ";
		AccDto dto = null;
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, acNum);
			ResultSet result = pStr.executeQuery();
			
			if (result.next()) {
				dto = result2Dto(result);
			}
			pStr.close();
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	

	@Override
	public List<AccDto> findByBuId(String acBuId) {
		String sql = "SELECT acnum, acdiv, acbuid, acbalance "
				+ " FROM tbl_acc "
				+ " WHERE acbuid = ? "
				+ " ORDER BY acnum ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, acBuId);
			List<AccDto> acBuidList = db2List(pStr);
			return acBuidList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public int insert(AccDto dto) {
		String sql = " INSERT INTO tbl_acc(acnum, acdiv, acbuid, acbalance) "
				+ " VALUES ( ?, ?, ?, ? ) ";
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, dto.acNum);
			pStr.setString(2, dto.acDiv);
			pStr.setString(3, dto.acBuId);
			pStr.setString(4, dto.acBalance + "");
			
			int result = pStr.executeUpdate();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(AccDto dto) {
		
		return 0;
	}

	@Override
	public int delete(String acNum) {
		
		return 0;
	}

	public String maxAcNum(String date) {
		String sql = " SELECT substr(max(acNum),9) "
				+ " FROM tbl_acc "
				+ " WHERE substr(acNum,0,8) = ? ";
		
		try {
			PreparedStatement pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, date);
			ResultSet result = pStr.executeQuery();
			if(result.next()) {
				return result.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "00";
	}


}
