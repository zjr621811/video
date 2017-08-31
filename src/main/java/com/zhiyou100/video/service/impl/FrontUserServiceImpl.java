package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.UserMapper;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.UserExample;
import com.zhiyou100.video.service.FrontUserService;
@Service
public class FrontUserServiceImpl implements FrontUserService {
	
	@Autowired
	UserMapper um;

	@Override
	public User findUserEmailAndPassword(User us) {
		
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(us.getEmail()).andPasswordEqualTo(us.getPassword());
		List<User> list = um.selectByExample(example);
		
		User u = new User();
		if(list.size()==0){
			u = null;
		}else{
			u = list.get(0);
		}		
		return u;
	}

	@Override
	public User findUserById(Integer id) {
		return um.selectByPrimaryKey(id);
	}

	@Override
	public User findUser(Integer id) {
		//System.out.println(id);
		return um.selectByPrimaryKey(id);
	}

	@Override
	public void updateUser(User us) {
		um.updateByPrimaryKeySelective(us);
		
	}

	@Override
	public void updateUserHeadUrl02(User us) {
		um.updateByPrimaryKeySelective(us);
		
	}

	@Override
	public void updatePwd02(User us) {
		um.updateByPrimaryKeySelective(us);
	}

	@Override
	public void userRegist(User us) {
		 um.insert(us);
		
	}

	@Override
	public User findUserEmail(String email) {
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(email);
		List<User> list = um.selectByExample(example);
		User u = new User();
		if(list.size()==0){
			u = null;
		}else{
			u = list.get(0);
		}		
		return u;
	}

	@Override
	public void updateCaptcha(User us) {
		um.updateByPrimaryKeySelective(us);
		
	}

	@Override
	public User findUserCaptcha(String captcha) {
		UserExample example = new UserExample();
		example.createCriteria().andCaptchaEqualTo(captcha);
		List<User> list = um.selectByExample(example);
		User u = new User();
		if(list.size()==0){
			u = null;
		}else{
			u = list.get(0);
		}		
		return u;
	}

	@Override
	public void resetPwd(User us) {
		um.updateByPrimaryKeySelective(us);
		
	}

	
	
}
