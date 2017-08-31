package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.utils.Page;

public interface SpeakerService {

	List<Speaker> findSpeaker();

	List<Speaker> findAllSpeaker();

	Speaker findSpeakerById(Integer id);

	void updateSpeaker(Speaker s);

	void deleteSpeakerById(Integer id);

	void addSpeaker(Speaker s);

	Page<Speaker> loadPage(Integer currentPage, String speakerName, String speakerJob);

	Speaker findSpeakerData(Integer speakerId);

	

}
