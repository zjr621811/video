package com.zhiyou100.video.service.impl;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.VideoMapper;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoExample;
import com.zhiyou100.video.model.VideoVO;
import com.zhiyou100.video.service.VideoService;
import com.zhiyou100.video.utils.Page;
@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	VideoMapper vm;

	

	@Override
	public Video findVideoById(Integer theId) {
		
		return vm.selectByPrimaryKey(theId);
	}

	@Override
	public void updateVideo(Video v) {
		
		vm.updateByPrimaryKeySelective(v);
		
	}

	@Override
	public void addVideo(Video v) {
		vm.insert(v);
		
	}

	@Override
	public void deleteVideoById(Integer id) {
		vm.deleteByPrimaryKey(id);
		
	}

	@Override
	public Page<Video> loadPage(Integer currentPage, String videoTitle, int videoSpeaker, int videoCourse) {
		
		Page<Video> page = new Page<>();
		page.setPage(currentPage);
		page.setSize(5);
		
		VideoVO vv = new VideoVO();
		vv.setCurrentPage((currentPage-1)*5);
		vv.setVideoCourse(videoCourse);
		vv.setVideoSpeaker(videoSpeaker);
		vv.setVideoTitle(videoTitle);
		
		page.setTotal(vm.findAllVideoCount(vv));
		page.setRows(vm.findAllVideo(vv));
		return page;
	}

	@Override
	public void batchDelete(Integer[] checkid) {
		VideoExample ve = new VideoExample();
		ve.createCriteria().andIdIn(Arrays.asList(checkid));
		vm.deleteByExample(ve);	
	}

	@Override
	public void findVideoPlaytimes() {
		vm.findVideoPlaytimes(null);
		
	}

	@Override
	public Video findVideoDataById(Integer videoId) {
		
		return vm.selectByPrimaryKey(videoId);
	}

	@Override
	public List<Video> findVideoData(Integer id) {
		
		return vm.findVideoData(id);
	}



}

	

	


