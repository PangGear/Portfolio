package com.project.member;

import lombok.Data;

@Data
public class MemberVO {

	private int seq;
	
	private String memberid;
	private String bcrypt;
	private String name;
	private String postcode;
	private String roadAddress;
	private String detailAddress;
	private String tel;
	private String grade;
	
	private String ch1;
	private String ch2;
}
