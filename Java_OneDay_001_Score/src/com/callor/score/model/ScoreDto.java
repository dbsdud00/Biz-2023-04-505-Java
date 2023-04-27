package com.callor.score.model;

public class ScoreDto { // 학생의 성적 정보에 들어갈 요소
	
	public String stnum; // 학번
	public int scKor;	// 국어점수
	public int scEng;	// 영어점수
	public int scMath;	// 수학점수
	public int scMusic; // 음악점수
	public int scArt;	// 미술점수
	
	public int getTotal() { // 총점 계산
		int total = scKor;
		total += scEng;
		total += scMath;
		total += scMusic;
		total += scArt;
		return total;
	}
	public float getAvg() {	// 평균 계산
		float avg = (float)getTotal()/5;
		return avg;
	}
}
