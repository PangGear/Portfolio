package com.project.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
	
	List<MemberVO> getMemberList(MemberVO vo);
	MemberVO getMember(MemberVO vo);
	
	void memberInsert(MemberVO vo);
	void memberUpdate(MemberVO vo);
	void memberDelete(MemberVO vo);

}
