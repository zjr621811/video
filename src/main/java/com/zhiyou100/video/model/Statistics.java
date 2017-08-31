package com.zhiyou100.video.model;

public class Statistics {
	private String courseName;
	private Integer avgTime;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getAvgTime() {
		return avgTime;
	}
	public void setAvgTime(Integer avTime) {
		this.avgTime = avTime;
	}
	@Override
	public String toString() {
		return "Statistics [courseName=" + courseName + ", avgTime=" + avgTime + "]";
	}

}
