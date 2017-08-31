package com.zhiyou100.video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Statistics;
import com.zhiyou100.video.service.AdminStatisticsService;

@Controller
@RequestMapping("/admin/statistics")
public class AdminStatisticsController {
	
	@Autowired
	AdminStatisticsService ass;
	@RequestMapping("/analyzeList.action")
	public String showStatistics(Model md){
		
		List<Statistics> list = ass.findStatistics();
		
		StringBuffer dataBuffer = new StringBuffer();
		StringBuffer timeBuffer = new StringBuffer();
		
		for(int i = 0; i < list.size(); i++){
			Statistics st = list.get(i);
			/*if(i == 0){
				dataBuffer.append("[");
				timeBuffer.append("]");
			}*/
				dataBuffer.append(st.getCourseName());
				timeBuffer.append(st.getAvgTime());
			if(i != list.size() - 1){
				dataBuffer.append(",");
				timeBuffer.append(",");
			}/*else{
				dataBuffer.append("]");
				timeBuffer.append("]");					
		   }*/
			
		}
		
		md.addAttribute("data",dataBuffer.toString());
		md.addAttribute("times",timeBuffer.toString());
		return "admin/statistics/analyzeList";
		
	}

}
