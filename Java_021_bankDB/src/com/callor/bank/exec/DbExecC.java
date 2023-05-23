package com.callor.bank.exec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.bank.config.DBContract;
import com.callor.bank.models.BuyerDto;

public class DbExecC {
	/*
	 *  DB 로부터 가져와서 리스트로 만들기
	 */
	public static void main(String[] args) {

		String sql = " SELECT "
				+ " buid, buname, butel, buaddr, bubirth, bujob "
				+ " FROM tbl_buyer ";

		Connection conn = null;

		try {
			Class.forName(DBContract.jdbcDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {

			conn = DriverManager.getConnection(
					DBContract.DB_URL, 
					DBContract.USER_NAME, 
					DBContract.PASSWORD
					);

			PreparedStatement pStr = conn.prepareStatement(sql);
			ResultSet result = pStr.executeQuery();

			List<BuyerDto> buyerList = new ArrayList<>();
			
			while (result.next()) {
				BuyerDto buyerDto = new BuyerDto();
				buyerDto.buId = result.getString(DBContract.BUYER.BUID);
				buyerDto.buName = result.getString(DBContract.BUYER.BUNAME);
				buyerDto.buTel = result.getString(DBContract.BUYER.BUTEL);
				buyerDto.buAddr = result.getString(DBContract.BUYER.BUADDR);
				buyerDto.buBirth = result.getString(DBContract.BUYER.BUBIRTH);
				buyerDto.buJob = result.getString(DBContract.BUYER.BUJOB);
				
				buyerList.add(buyerDto);
			}
			System.out.println(buyerList);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
