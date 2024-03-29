package com.project.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao dao;
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		return dao.getBoardList(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {

		return dao.getBoard(vo);
	}

	@Override
	public void boardInsert(BoardVO vo) {

		dao.boardInsert(vo);
	}

	@Override
	public void boardUpdate(BoardVO vo) {

		dao.boardUpdate(vo);
	}

	@Override
	public void boardDelete(BoardVO vo) {

		dao.boardDelete(vo);
	}

}
