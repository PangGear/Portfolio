package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.login.BCrypt;
import com.project.login.LoginService;
import com.project.login.LoginVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private LoginService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/getLoginList.do")
	String getMemberList(Model model, LoginVO vo) {
		
		model.addAttribute("li", service.getLoginList(vo));
		
		return "/admin/getMemberList.jsp";
	}
	
	@GetMapping("/memberInsert.do")
	String memberInsert() {
		
		return "/admin/memberInsert.jsp";
	}
	
	@PostMapping("/memberInsert.do")
	String memberInsert(LoginVO vo) {
		
		String pwd = passwordEncoder.encode(vo.getPassword());
		vo.setPassword(pwd);
		service.loginInsert(vo);
		
		return "redirect:/getLoginList.do";
	}
	
	@GetMapping("Login.do")
	public  String MemberLogin( ) {
		return "/login/member_login.jsp";
	}

	@GetMapping("LogOut.do")
	public  String MemberLogOut(HttpSession session) {		
		session.invalidate();
		return "/login/member_login.jsp";		
	}

	@GetMapping("accessDenied.do")
	 String accessDenied() {
		System.out.println("===> accessDenied.do");
	   return "/login/accessDenied.jsp";		
	}
}
