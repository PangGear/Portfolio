package com.project.board;

import lombok.Data;

@Data
public class BoardVO {

	private int boardIdx;
	private String username;
	private String title;
	private String content;
	private String reg_date;
	private String upd_date;
}