package com.callor.test.model;

public class GuideDto {
	public String guideId;
	public String guideName;
	public int guideSeq;
	public String guideDes;
	
	
	
	public GuideDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public GuideDto(String guideId, String guideName, int guideSeq, String guideDes) {
		super();
		this.guideId = guideId;
		this.guideName = guideName;
		this.guideSeq = guideSeq;
		this.guideDes = guideDes;
	}



	@Override
	public String toString() {
		return "GuideDto [guideId=" + guideId + ", guideName=" + guideName + ", guideSeq=" + guideSeq + ", guideDes="
				+ guideDes + "]";
	}




	
	
	
	

	
	
	
}
