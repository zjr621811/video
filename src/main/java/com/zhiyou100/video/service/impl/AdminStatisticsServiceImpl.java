package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.AdminStatisticsMapper;
import com.zhiyou100.video.model.Statistics;
import com.zhiyou100.video.service.AdminStatisticsService;
@Service
public class AdminStatisticsServiceImpl implements AdminStatisticsService{

	@Autowired
	AdminStatisticsMapper asm;

	@Override
	public List<Statistics> findStatistics() {
		
		return asm.findStatistics();
	}
}
