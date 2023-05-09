package com.callor.classes.models;

public class ScoreDto {

	private String stNum;
	private int scKor;
	private int scEng;
	private int scMath;
	private int scMusic;
	private int scArt;
	private int scSoftware;
	private int scDatabase;
	

	public ScoreDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ScoreDto(String stNum, int scKor, int scEng, int scMath, int scMusic, int scArt, int scSoftware,
			int scDatabase) {
		super();
		this.stNum = stNum;
		this.scKor = scKor;
		this.scEng = scEng;
		this.scMath = scMath;
		this.scMusic = scMusic;
		this.scArt = scArt;
		this.scSoftware = scSoftware;
		this.scDatabase = scDatabase;
	}
	
	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public int getScKor() {
		return scKor;
	}
	public void setScKor(int scKor) {
		this.scKor = scKor;
	}
	public int getScEng() {
		return scEng;
	}
	public void setScEng(int scEng) {
		this.scEng = scEng;
	}
	public int getScMath() {
		return scMath;
	}
	public void setScMath(int scMath) {
		this.scMath = scMath;
	}
	public int getScMusic() {
		return scMusic;
	}
	public void setScMusic(int scMusic) {
		this.scMusic = scMusic;
	}
	public int getScArt() {
		return scArt;
	}
	public void setScArt(int scArt) {
		this.scArt = scArt;
	}
	public int getScSoftware() {
		return scSoftware;
	}
	public void setScSoftware(int scSoftware) {
		this.scSoftware = scSoftware;
	}
	public int getScDatabase() {
		return scDatabase;
	}
	public void setScDatabase(int scDatabase) {
		this.scDatabase = scDatabase;
	}
	@Override
	public String toString() {
		return "ScoreDto [stNum=" + stNum + ", scKor=" + scKor + ", scEng=" + scEng + ", scMath=" + scMath
				+ ", scMusic=" + scMusic + ", scArt=" + scArt + ", scSoftware=" + scSoftware + ", scDatabase="
				+ scDatabase + "]";
	}
	
	
	

	
	
	
	
	
}
