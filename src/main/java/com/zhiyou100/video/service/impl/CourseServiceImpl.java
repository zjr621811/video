package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.CourseMapper;
import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.model.CourseVO;
import com.zhiyou100.video.service.CourseService;
import com.zhiyou100.video.utils.Page;
@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseMapper cm;

	@Override
	public List<Course> findCourse() {
		
		return cm.findCourse();
	}

	@Override
	public List<Course> findAllCourse() {
		
		return cm.selectByExample(null);
	}

	@Override
	public void addCourse(Course c) {
		cm.insert(c);
		
	}

	@Override
	public void deleteCourseById(Integer id) {
		cm.deleteByPrimaryKey(id);
		
	}

	@Override
	public Course findCourseById(Integer id) {
		
		return cm.selectByPrimaryKey(id);
	}

	@Override
	public void updateCourse(Course c) {
		cm.updateByPrimaryKeySelective(c);
		
	}

	@Override
	public Page<Course> loadPage(Integer currentPage) {
		
		Page<Course> page = new Page<>();
		page.setPage(currentPage);
		page.setSize(5);
		
		CourseVO cv = new CourseVO();
		cv.setCurrentPage((currentPage-1)*5);
		
		page.setTotal(cm.findAllVideoCount(cv));
		page.setRows(cm.findAllVideo(cv));
		return page;
	}

	@Override
	public List<Course> findCourseNameById(Integer subjectId) {
		
		return cm.findCourseNameById(subjectId);
	}

	@Override
	public Course findCourseData(Integer courseId) {
		
		return cm.selectByPrimaryKey(courseId);
	}


	
	

}
