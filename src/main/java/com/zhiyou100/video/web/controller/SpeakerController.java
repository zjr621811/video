package com.zhiyou100.video.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.Speaker;
import com.zhiyou100.video.model.SpeakerVO;
import com.zhiyou100.video.service.SpeakerService;
import com.zhiyou100.video.utils.Page;

@Controller
@RequestMapping("/admin/speaker")
public class SpeakerController {
	
	@Autowired
	SpeakerService ss;
	@RequestMapping("/speakerList.action")
	public ModelAndView speakerList(@RequestParam(value="page",required=true,defaultValue="1") Integer currentPage,
									@RequestParam(value="speakerName",required=true,defaultValue="") String speakerName,
									@RequestParam(value="speakerJob",required=true,defaultValue="") String speakerJob ){
		Page<Speaker> page = ss.loadPage(currentPage,speakerName,speakerJob);
		//System.out.println(page.getRows());
		ModelAndView mv = new ModelAndView();
		mv.addObject("speakerName", speakerName);
		mv.addObject("speakerJob", speakerJob);
		mv.addObject("page", page);
		
		mv.setViewName("admin/speaker/speakerList");
		return mv;
	}

	@RequestMapping(value="/updateSpeaker.action",method=RequestMethod.GET)
	public ModelAndView updateSpeaker(Integer id){
		Speaker s= ss.findSpeakerById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("speaker", s);
		mv.setViewName("admin/speaker/updateSpeaker");
		return mv;
	}
	@RequestMapping(value="/updateSpeaker.action",method=RequestMethod.POST)
	public String editSpeaker(SpeakerVO sv){
		
		ss.updateSpeaker(sv.getS());
		//System.out.println(sv);
		return "redirect:/admin/speaker/speakerList.action";
	}
	@RequestMapping("/deleteSpeaker.action")
	@ResponseBody
	public String deleteSpeaker(Integer id){
		ss.deleteSpeakerById(id);
		return "success";
	}
	@RequestMapping(value="/addSpeaker.action",method=RequestMethod.GET)
	public String addSpeaker(){
		return "admin/speaker/addSpeaker";
	}
	@RequestMapping(value="/addSpeaker.action",method=RequestMethod.POST)
	public String addSpeaker01(Speaker s){
		ss.addSpeaker(s);
		return "redirect:/admin/speaker/speakerList.action";
	}
}
