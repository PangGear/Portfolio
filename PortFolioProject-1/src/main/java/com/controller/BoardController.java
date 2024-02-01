package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.board.BoardService;
import com.project.board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;

	@GetMapping("getBoardList.do")
	String getBoardList(Model model, BoardVO vo) {
		
		model.addAttribute("li", service.getBoardList(vo));
		return "/board/getBoardList";
	}
	
	@GetMapping("getBoard.do")
	String getBoard(Model model, BoardVO vo) {
		
		model.addAttribute("m", service.getBoard(vo));
		return "/board/getBoard";
	}
	
	@GetMapping("boardInsert.do")
	String boardInsert(BoardVO vo) {
		
		service.boardInsert(vo);
		return "/board/boardInsert";
	}
	
	@GetMapping("boardUpdate.do")
	String boardUpdate(BoardVO vo) {
		
		service.boardUpdate(vo);
		return "/board/boardUpdate";
	}
}
