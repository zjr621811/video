package com.zhiyou100.video.service;




import java.util.List;

import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.utils.Page;

public interface VideoService {

	

	Video findVideoById(Integer theId);

	void updateVideo(Video v);

	void addVideo(Video v);

	void deleteVideoById(Integer id);

	Page<Video> loadPage(Integer currentPage, String videoTitle, int videoSpeaker, int videoCourse);

	void batchDelete(Integer[] checkid);

	void findVideoPlaytimes();
	
	Video findVideoDataById(Integer videoId);

	List<Video> findVideoData(Integer id);





	

}
