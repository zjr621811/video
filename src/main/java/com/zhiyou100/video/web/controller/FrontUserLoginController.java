package com.zhiyou100.video.web.controller;

import java.io.File;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.video.model.Result;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.FrontUserService;
import com.zhiyou100.video.utils.MailUtil;

@Controller
@RequestMapping("/front/user")
public class FrontUserLoginController {
	@Autowired
	FrontUserService fus;
	
	@RequestMapping("/login.action")
	@ResponseBody
	public Result userLogin(User us,HttpSession session){
		//System.out.println(1);
		Result re = new Result();
		us.getEmail();
		us.getPassword();
		User u = fus.findUserEmailAndPassword(us);
		if(u != null){
			session.setAttribute("_front_user", u);
			re.setSuccess(true);
		}else{
			re.setMessage("error");
		}
		return re;
	}
	@RequestMapping("/index.action")
	public String findUser(Integer id,HttpSession session){		
		session.setAttribute("user",fus.findUserById(id));
		return "front/user/index";		
	}
	@RequestMapping("/profile.action")
	public String updateUser(){
		/*User u = fus.findUser(id);
		//System.out.println(u);
		session.setAttribute("user",u);*/
		return "front/user/profile";
	}
	@RequestMapping(value="/profile.action",method=RequestMethod.POST)
	public String editUser(User us){
		//System.out.println(us);
		fus.updateUser(us);
		return "redirect:/front/user/index.action?id="+us.getId();
	}
	@RequestMapping("/avatar.action")
	public String updateUserHeadUrl(){
		/*User user = fus.findUserById(id);
		session.setAttribute("user", user);*/
		return "front/user/avatar";
	}
	@RequestMapping(value="/avatar.action",method=RequestMethod.POST)
	public String updateUserHeadUrl02(User us,MultipartFile image_file) throws Exception{
		
		//System.out.println(us);
		String str = UUID.randomUUID().toString().replaceAll("-","");
		String ext = FilenameUtils.getExtension(image_file.getOriginalFilename());
		//System.out.println("11111111111");
		String fileName = str + "." + ext;
		us.setHeadUrl(fileName);
		fus.updateUserHeadUrl02(us);
		String path = "D:\\upload";
		image_file.transferTo(new File(path+"\\"+fileName));
		
		return "redirect:/front/user/index.action?id="+us.getId();
	}
	@RequestMapping("/password.action")
	public String updatePwd(){
		return "front/user/password";
	}
	@RequestMapping(value="/password.action",method=RequestMethod.POST)
	public String updatePwd02(User us,HttpSession session){
		User findUserById = fus.findUserById(us.getId());
		//System.out.println(us);
		
		if(us.getOldPassword().equals(findUserById.getPassword())){
			us.setPassword(us.getNewPassword());
			fus.updatePwd02(us);
			session.invalidate();
			return "redirect:/index.jsp";
		}else{
			return "front/user/password";
		}
	}
	
	@RequestMapping(value="/regist.action",method=RequestMethod.POST)
	@ResponseBody
	public Result userRegist(User us){
		String md = DigestUtils.md5DigestAsHex(us.getPassword().getBytes());
		us.setPassword(md);
		Result re = new Result();
		fus.userRegist(us);
		//System.out.println(us);
		if(us != null){
			//session.setAttribute("_front_user",us);
			re.setSuccess(true);
		}
		return re;		
	}
	@RequestMapping("/logout.action")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/index.jsp";
	}
	//忘记密码
	@RequestMapping("/forgetpwd.action")
	public String forgetPwd(){
		return "front/user/forget_pwd";
	}
	@RequestMapping(value="/forgetpwd.action",method=RequestMethod.POST)
	public String forgetPwd02(String captcha,Model md){
		User us = fus.findUserCaptcha(captcha);
		if(us != null){
			md.addAttribute("user", us);
			return "front/user/reset_pwd";
		}
		return "front/user/forget_pwd";
	}
	@RequestMapping("/sendemail.action")
	@ResponseBody
	public Result sendEmail(String email) throws Exception{
		Random ran = new Random();
		String a =""+(ran.nextInt(99999-10000+1)+10000);
		
		Result re = new Result();
		User us = fus.findUserEmail(email);
		if(us != null){
			MailUtil.send(email, "邮件",a);
			us.setCaptcha(a);
			fus.updateCaptcha(us);
			re.setSuccess(true);
		}
		re.setMessage("error");
		return re;		
	} 
	
	@RequestMapping(value="/resetpwd.action",method=RequestMethod.POST)
	public String resetPwd(User u){
		//System.out.println(u);
		User user = fus.findUserById(u.getId());
		user.setPassword(u.getPassword());
		fus.resetPwd(user);
		return "redirect:/index.jsp";
	}
	
	
	
}	