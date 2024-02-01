package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.member.BCrypt;
import com.project.member.MemberService;
import com.project.member.MemberVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/getMemberList.do")
	String getMemberList(Model model, MemberVO vo) {
		
		model.addAttribute("li", service.getMemberList(vo));
		
		return "/member/getMemberList";
	}
	
	@GetMapping("/memberInsert.do")
	String memberInsert() {
		
		return "/member/memberInsert";
	}
	
	@PostMapping("/memberInsert.do")
	String memberInsert(MemberVO vo) {
		
		String Bpwd = BCrypt.hashpw(vo.getBcrypt(), BCrypt.gensalt());
		vo.setBcrypt(Bpwd);
		service.memberInsert(vo);
		
		return "redirect:/getMemberList.do";
	}
	
	@PostMapping("memberLogin.do")
	public  String MemberLogin( ) {
		return "/member/member_login";
	}
	
//	@PostMapping("memberLogin.do")
//	public  String MemberLogin( MemberVO vo , HttpSession session ) {		
//	
//		MemberVO m = service.getLoginOne(vo);
//		// System.out.println("===> m 확인: "+ m);
//		
//		if (m != null) {
//			
//			// System.out.println(" 암호 확인 : " + vo.getPwd()+":"+m.getPwd());
//			
//			if (BCrypt.checkpw(vo.getBcrypt(),  m.getBcrypt())) {
//			  
//			  session.setAttribute("sessionMemberid", m.getMemberid());
//			  session.setAttribute("sessionName", m.getName());
//			  session.setAttribute("sessionPwd", vo.getBcrypt());
//			  
//			  return "/member/member_success.jsp";		
//			} else {
//			  // System.out.println("************> 불일치");	
//			  return "/member/member_login.jsp";
//			}
//		} else {
//			 return "/member/member_login.jsp";
//		}		
//		
//	}


	@PostMapping("memberLogOut.do")
	public  String MemberLogOut(HttpSession session ) {		
		session.invalidate();
		return "/member/member_login.jsp";		
	}
}
