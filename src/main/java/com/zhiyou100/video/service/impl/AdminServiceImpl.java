package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.AdminMapper;
import com.zhiyou100.video.model.Admin;
import com.zhiyou100.video.model.AdminExample;
import com.zhiyou100.video.model.AdminVO;
import com.zhiyou100.video.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper am;

	@Override
	public Admin findAdmin(AdminVO av) {
		
		AdminExample example = new AdminExample();
		example.createCriteria().andLoginNameEqualTo(av.getLoginName()).andLoginPwdEqualTo(av.getLoginPwd());
		List<Admin> list = am.selectByExample(example);
		Admin a = new Admin();
		if(list.size()==0){
			a = null;
		}else{
			a = list.get(0);
		}
		return a;
	}

	
	
}
