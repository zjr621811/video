package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.SpeakerMapper;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.utils.Page;

@Service
public class SpeakerServiceImpl implements SpeakerService {
	
	@Autowired
	SpeakerMapper sm;

	@Override
	public List<Speaker> findSpeaker() {
		
		return sm.selectByExample(null);
	}

	@Override
	public List<Speaker> findAllSpeaker() {
		
		return sm.selectByExample(null);
	}

	@Override
	public Speaker findSpeakerById(Integer id) {
		
		return sm.selectByPrimaryKey(id);
	}

	@Override
	public void updateSpeaker(Speaker s) {
		sm.updateByPrimaryKeySelective(s);
		
		
	}

	@Override
	public void deleteSpeakerById(Integer id) {
		sm.deleteByPrimaryKey(id);
		
	}

	@Override
	public void addSpeaker(Speaker s) {
		sm.insert(s);
		
	}

	@Override
	public Page<Speaker> loadPage(Integer currentPage, String speakerName, String speakerJob) {
		
		Page<Speaker> page = new Page<>();
		page.setPage(currentPage);
		page.setSize(5);
		page.setRows(sm.findAllSpeaker(speakerName,speakerJob,(currentPage-1)*5));
		page.setTotal(sm.findAllSpeakerCount(speakerName,speakerJob));
		
		return page;
	}

	@Override
	public Speaker findSpeakerData(Integer speakerId) {
		
		return sm.selectByPrimaryKey(speakerId);
	}

	
}
