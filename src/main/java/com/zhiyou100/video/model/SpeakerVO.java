package com.zhiyou100.video.model;

public class SpeakerVO {
	private Speaker s;
	private int currentPage;
	

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Speaker getS() {
		return s;
	}

	public void setS(Speaker s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "SpeakerVO [s=" + s + "]";
	}

}
