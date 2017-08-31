package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.Subject;

public interface SubjectService {

	List<Subject> findSubject();

	Subject findSubjectNameById(Integer subjectId);

	Subject findSubjectName(Integer subjectId);

}
