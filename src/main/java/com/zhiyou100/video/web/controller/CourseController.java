package com.zhiyou100.video.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.CourseVO;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.service.SubjectService;
import com.zhiyou100.video.utils.Page;

@Controller
@RequestMapping("/admin/course")
public class CourseController {
	
	@Autowired
	CourseService cs;
	@Autowired
	SubjectService ss;
	@RequestMapping("/courseList.action")
	public ModelAndView courseList(CourseVO cv,@RequestParam(name="page",required=true,defaultValue="1") Integer currentPage){
		ModelAndView mv = new ModelAndView();
		Page<Course> page = cs.loadPage(currentPage);
		//System.out.println(page.getRows());
		mv.addObject("page", page);
		mv.setViewName("admin/course/courseList");	
		return mv;
	}
	@RequestMapping("/addCourse.action")
	public String addCourse(HttpServletRequest req){
		List<Subject> subjectList = ss.findSubject();
		req.getSession().setAttribute("subjectList",subjectList);
		return "admin/course/addCourse";
	}
	@RequestMapping(value="/addCourse.action",method=RequestMethod.POST)
	public String addCourse01(Course c){
		
		cs.addCourse(c);
		return "redirect:/admin/course/courseList.action";
	}
	@RequestMapping("/deleteCourse.action")
	@ResponseBody
	public String deleteCourse(Integer id){
		cs.deleteCourseById(id);
		return "success";
	}
	@RequestMapping(value="/updateCourse.action",method=RequestMethod.GET)
	public String updateCourse(Integer id,HttpServletRequest req){
		
		List<Subject> subjectList = ss.findSubject();
		req.getSession().setAttribute("subjectList",subjectList);
		Course c = cs.findCourseById(id);
		req.getSession().setAttribute("course",c);
		return "admin/course/updateCourse";
	}
	@RequestMapping(value="/updateCourse.action",method=RequestMethod.POST)
	public String editCourse(CourseVO cv){
		
		cs.updateCourse(cv.getC());
		return "redirect:/admin/course/courseList.action";
	}
	
	
}
