package com.project.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao dao;
	
	@Override
	public List<LoginVO> getLoginList(LoginVO vo) {
		
		return dao.getLoginList(vo);
	}

	@Override
	public LoginVO getLogin(LoginVO vo) {
		
		return dao.getLogin(vo);
	}

	@Override
	public void loginInsert(LoginVO vo) {
		
		dao.loginInsert(vo);
	}

	@Override
	public void loginUpdate(LoginVO vo) {
		
		dao.loginUpdate(vo);
	}

	@Override
	public void loginDelete(LoginVO vo) {
		
		dao.loginDelete(vo);
	}

}
