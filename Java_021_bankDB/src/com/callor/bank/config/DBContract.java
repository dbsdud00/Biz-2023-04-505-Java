package com.callor.bank.config;

/*
 *  DB와 연결하는 Session(통로)를 만든 클래스 도구
 */
public class DBContract {
	// DB에 연결할때 필요한 정보
	public static final String jdbcDriver = "oracle.jdbc.driver.OracleDriver"; // oracle jdbc 와 연결하기 위해서 oracle Driver를 쓰겠다
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // jdbc를 통해서 oracle한테 접속을 하는데 oracle driver 내의 thin으로 간단하게 연결. localhost에 설치되어 있는 1521 에 접속(?) 
	public static final String USER_NAME = "C##myuser";
	public static final String PASSWORD = "12341234";
	
	public static class BUYER {
		public static final int BUID = 1;
		public static final int BUNAME = 2;
		public static final int BUTEL = 3;
		public static final int BUADDR = 4;
		public static final int BUBIRTH = 5;
		public static final int BUJOB = 6;
	}
	public static class ACC {
		public static final int ACC_NUM = 1;
		public static final int ACC_DIV = 2;
		public static final int ACC_BUID = 3;
		public static final int ACC_BALANCE = 4;
	}
	
	public static String[] ACC_DIV = {
			"입출금계좌", "적금계좌", "대출계좌"
	};
}
