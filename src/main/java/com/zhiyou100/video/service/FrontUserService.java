package com.zhiyou100.video.service;


import com.zhiyou100.video.model.User;

public interface FrontUserService {

	User findUserEmailAndPassword(User us);

	User findUserById(Integer id);

	User findUser(Integer id);

	void updateUser(User us);

	void updateUserHeadUrl02(User us);

	void updatePwd02(User us);

	void userRegist(User us);

	User findUserEmail(String email);

	void updateCaptcha(User us);

	User findUserCaptcha(String captcha);

	void resetPwd(User us);


}

