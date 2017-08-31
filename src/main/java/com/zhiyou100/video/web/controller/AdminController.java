package com.zhiyou100.video.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.model.AdminVO;
import com.zhiyou100.video.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService as;
	
	@RequestMapping("/user/adminLogin.action")
	public String login(AdminVO av,HttpServletRequest req){
		String md = DigestUtils.md5DigestAsHex(av.getLoginPwd().getBytes());
		av.getLoginName();
		av.setLoginPwd(md);
		av.getLoginPwd();
		
		Admin a = as.findAdmin(av);
		if(a==null){
			
			return "redirect:/index.jsp";
		}else{
			req.getSession().setAttribute("admin",a);
			return "redirect:/admin/video/videoList.action";
		}
		
	}
		
		

	
}
