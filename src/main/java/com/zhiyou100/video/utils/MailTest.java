package com.zhiyou100.video.utils;

import org.junit.Test;

public class MailTest {
	
	@Test
	public void test01() throws Exception{
		/*
		 * 
		 * <a href=\"http://www.baidu.com\">百度</a>
		 */
		MailUtil.send("1319909772@qq.com", "邮件", "明天不用来上班了!!你被炒鱿鱼了");
		/*
		 * 0. MD5(邮箱+密码+当前时间)就是激活码  24小时有效
		 * 1.id(uuid)  邮箱地址   状态(0未激活,1表示激活)   激活码     失效时间
		 * 2.http://localhost:8080/Test/Mail/active.action?id=id&activeCode=激活码 
		 */
		
		
		
	}

}
