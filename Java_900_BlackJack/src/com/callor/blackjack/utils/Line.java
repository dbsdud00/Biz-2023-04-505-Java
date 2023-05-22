package com.callor.blackjack.utils;

public class Line {
	
	public static String dLine = "=".repeat(60);
	public static String sLine = "-".repeat(60);
	
	public static String dLine(int length) {
		return "=".repeat(length);
	}
	public static String sLine(int length) {
		return "-".repeat(length);
	}
	
}
