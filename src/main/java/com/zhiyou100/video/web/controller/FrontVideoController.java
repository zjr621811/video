package com.zhiyou100.video.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.service.SubjectService;
import com.zhiyou100.video.service.VideoService;

@Controller
@RequestMapping("front/video")
public class FrontVideoController {
	@Autowired
	VideoService vs;
	@Autowired
	SubjectService ss;
	@Autowired
	SpeakerService se;
	@Autowired
	CourseService cs;
	@RequestMapping("/index.action")
	public String frontVideo(Integer subjectId,Integer videoId,Model md){
		md.addAttribute("videoId", videoId);
		Subject subject = ss.findSubjectName(subjectId);
		md.addAttribute("subject", subject);
		return "front/video/index";
	}
	@RequestMapping("/videoData.action")
	public String findVideoData(Integer videoId,Model md){
		
		Video video = vs.findVideoDataById(videoId);
		md.addAttribute("video", video);
		
		Speaker speaker = se.findSpeakerData(video.getSpeakerId());
		md.addAttribute("speaker", speaker);
		
		Course course = cs.findCourseData(video.getCourseId());
		md.addAttribute("course", course);
		
		List<Video> videoList = vs.findVideoData(course.getId());
		md.addAttribute("videoList", videoList);
		
		return "front/video/content";
	}
}
