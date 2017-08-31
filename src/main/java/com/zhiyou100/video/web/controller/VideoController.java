package com.zhiyou100.video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.Video;
import com.zhiyou100.video.model.VideoVO;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.service.VideoService;
import com.zhiyou100.video.utils.Page;

@Controller
@RequestMapping("/admin/video")
public class VideoController {
	@Autowired
	VideoService vs;
	@Autowired
	SpeakerService ss;
	@Autowired
	CourseService cs;
	
	@RequestMapping("/videoList.action")
	public ModelAndView videoList(@RequestParam(value="page",required=true,defaultValue="1") Integer currentPage,
			  @RequestParam(value="videoTitle",required=true,defaultValue="") String videoTitle,
			  @RequestParam(value="videoSpeaker",required=true,defaultValue="0") int videoSpeaker,
			  @RequestParam(value="videoCourse",required=true,defaultValue="0") int videoCourse){
		//System.out.println(vv);
		Page<Video> p = vs.loadPage(currentPage, videoTitle, videoSpeaker, videoCourse);
		
		ModelAndView mv = new ModelAndView();
		List<Speaker> speakerList = ss.findAllSpeaker();
		List<Course> courseList = cs.findAllCourse();
		//System.out.println(videoList);
		VideoVO vv = new VideoVO();
		vv.setCurrentPage((currentPage-1)*5);
		vv.setVideoCourse(videoCourse);
		vv.setVideoTitle(videoTitle);
		vv.setVideoSpeaker(videoSpeaker);
		mv.addObject("VideoVO", vv);
		mv.addObject("speakerList",speakerList);
		mv.addObject("courseList",courseList);
		mv.addObject("page",p);
		mv.setViewName("admin/video/videoList");
		return mv;
	}
	@RequestMapping(value="/updateVideo.action",method=RequestMethod.GET)
	public ModelAndView updateVideo(@RequestParam(value="id",required=true,defaultValue="1") Integer theId){
		List<Speaker> speakerList = ss.findAllSpeaker();
		List<Course> courseList = cs.findAllCourse();
		Video v = vs.findVideoById(theId);
		ModelAndView mv = new ModelAndView();
		//System.out.println(theId);
		
		mv.addObject("speakerList",speakerList);
		mv.addObject("courseList",courseList);
		mv.addObject("video",v);
		mv.setViewName("admin/video/updateVideo");
		return mv;
	}
	@RequestMapping(value="/updateVideo.action",method=RequestMethod.POST)
	public String editVideo(VideoVO vv){
		//System.out.println(vv);
		vs.updateVideo(vv.getV());
		return "redirect:/admin/video/videoList.action";	
	}
	@RequestMapping(value="/addVideo.action",method=RequestMethod.GET)
	public ModelAndView addVideo(){
		List<Speaker> speakerList = ss.findAllSpeaker();
		List<Course> courseList = cs.findAllCourse();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("speakerList",speakerList);
		mv.addObject("courseList",courseList);
		mv.setViewName("admin/video/addVideo");
		//System.out.println("99999999999");
		return mv;
	}
	@RequestMapping(value="/addVideo.action",method=RequestMethod.POST)
	public String addVideo01(Video v){
		
		vs.addVideo(v);
		//System.out.println(v);
		return "redirect:/admin/video/videoList.action";
	}
	@RequestMapping("/deleteVideo.action")
	@ResponseBody
	public String deleteVideo(Integer id){
		vs.deleteVideoById(id);
		return "success";
	}
	@RequestMapping("/batchDelete.action")
	public String videoBatchDelete(Integer[]checkid){
		//System.out.println(Arrays.toString(checkid));
		vs.batchDelete(checkid);
		return "redirect:/admin/video/videoList.action";	
	}
	
}
