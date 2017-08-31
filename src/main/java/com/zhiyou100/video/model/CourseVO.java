package com.zhiyou100.video.model;

public class CourseVO {
	private Course c;
	private int currentPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Course getC() {
		return c;
	}

	public void setC(Course c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "CourseVO [c=" + c + ", currentPage=" + currentPage + "]";
	}

}
