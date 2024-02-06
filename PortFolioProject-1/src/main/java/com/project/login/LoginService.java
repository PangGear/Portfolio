package com.project.login;

import java.util.List;

public interface LoginService {

	List<LoginVO> getLoginList(LoginVO vo);
	LoginVO getLogin(LoginVO vo);
	
	void loginInsert(LoginVO vo);
	void loginUpdate(LoginVO vo);
	void loginDelete(LoginVO vo);
}
