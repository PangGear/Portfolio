package com.project.member;

import java.util.List;

public interface MemberService {

	List<MemberVO> getMemberList(MemberVO vo);
	MemberVO getMember(MemberVO vo);
	
	void memberInsert(MemberVO vo);
	void memberUpdate(MemberVO vo);
	void memberDelete(MemberVO vo);
}
