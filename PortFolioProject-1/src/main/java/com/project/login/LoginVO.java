package com.project.login;

import lombok.Data;

@Data
public class LoginVO {

	private int seq;
	
	private String username;
	private String password;
	private String role;
	private String name;
	private String postcode;
	private String roadAddress;
	private String detailAddress;
	private String tel;
	
	private String ch1;
	private String ch2;
}
