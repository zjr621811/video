package com.zhiyou100.video.model;

public class VideoVO {
	private Video v;
	private String videoTitle;
	private int videoSpeaker;
	private int videoCourse;
	private int currentPage;
	public Video getV() {
		return v;
	}
	public void setV(Video v) {
		this.v = v;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public int getVideoSpeaker() {
		return videoSpeaker;
	}
	public void setVideoSpeaker(int videoSpeaker) {
		this.videoSpeaker = videoSpeaker;
	}
	public int getVideoCourse() {
		return videoCourse;
	}
	public void setVideoCourse(int videoCourse) {
		this.videoCourse = videoCourse;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "VideoVO [v=" + v + ", videoTitle=" + videoTitle + ", videoSpeaker=" + videoSpeaker + ", videoCourse="
				+ videoCourse + ", currentPage=" + currentPage + "]";
	}
	
	
	
}
