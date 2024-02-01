package com.project.board;

import java.util.List;

public interface BoardService {

	List<BoardVO> getBoardList(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	
	void boardInsert(BoardVO vo);
	void boardUpdate(BoardVO vo);
	void boardDelete(BoardVO vo);
}
