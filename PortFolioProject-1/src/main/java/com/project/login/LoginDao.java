package com.project.login;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
	
	List<LoginVO> getLoginList(LoginVO vo);
	LoginVO getLogin(LoginVO vo);
	
	void loginInsert(LoginVO vo);
	void loginUpdate(LoginVO vo);
	void loginDelete(LoginVO vo);

}
