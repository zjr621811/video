package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.SubjectMapper;
import com.zhiyou100.video.model.Subject;
import com.zhiyou100.video.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	SubjectMapper sm;

	@Override
	public List<Subject> findSubject() {
		
		return sm.selectByExample(null);
	}

	@Override
	public Subject findSubjectNameById(Integer subjectId) {
		
		return sm.selectByPrimaryKey(subjectId);
	}

	@Override
	public Subject findSubjectName(Integer subjectId) {
		// TODO Auto-generated method stub
		return sm.selectByPrimaryKey(subjectId);
	}

}
