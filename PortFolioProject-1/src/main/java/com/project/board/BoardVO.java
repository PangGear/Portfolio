package com.project.board;

import lombok.Data;

@Data
public class BoardVO {

	private int id;
	private String title;
	private String content;
	private String reg_id;
	private String reg_dt;
	private String upd_dt;
	
}