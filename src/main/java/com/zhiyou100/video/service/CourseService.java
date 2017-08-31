package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Course;
import com.zhiyou100.video.utils.Page;

public interface CourseService {

	List<Course> findCourse();

	List<Course> findAllCourse();

	void addCourse(Course c);

	void deleteCourseById(Integer id);

	Course findCourseById(Integer id);

	void updateCourse(Course c);

	Page<Course> loadPage(Integer currentPage);

	List<Course> findCourseNameById(Integer subjectId);

	Course findCourseData(Integer courseId);


}
