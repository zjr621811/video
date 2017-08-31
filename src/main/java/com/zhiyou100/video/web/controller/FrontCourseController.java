package com.zhiyou100.video.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SubjectService;
@Controller
@RequestMapping("front/course")
public class FrontCourseController {
	
	@Autowired
	CourseService cs;
	@Autowired
	SubjectService ss;
	
	@RequestMapping("/index.action")
	public String frontCourse(Integer subjectId,Model md){
		//获取subjectName
		Subject subject = ss.findSubjectNameById(subjectId);
		//System.out.println(subject);
		md.addAttribute("subject", subject);
		md.addAttribute("subjectId", subjectId);
		
		List<Course> course = cs.findCourseNameById(subjectId);
		//System.out.println(course);
		md.addAttribute("courses", course);
		return "front/course/index";
		
	}
	

}
