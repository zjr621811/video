package com.zhiyou100.video.model;

public class AdminVO {
	private Admin a;

	private String loginName;
	private String loginPwd;
	
	
	public Admin getA() {
		return a;
	}

	public void setA(Admin a) {
		this.a = a;
	}
	

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	@Override
	public String toString() {
		return "AdminVO [a=" + a + ", loginName=" + loginName + ", loginPwd=" + loginPwd + "]";
	}

}
