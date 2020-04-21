package com.spring_tutorial.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring_tutorial.board.model.dto.BoardDto;
import com.spring_tutorial.board.model.dao.BoardDaoImpl;


@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDaoImpl boardDao;
	
	@Override
	public List<BoardDto> listAll(int start, int end, String searchOption, String keyword) throws Exception {
		return boardDao.listAll(start, end, searchOption, keyword);
	}
	
	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		return boardDao.countArticle(searchOption, keyword);
	}
	
	@Override
	public void create(BoardDto dto) throws Exception {
		boardDao.create(dto);
	}
	
	@Override
	public BoardDto detail(int boardId) throws Exception {
		return boardDao.detail(boardId);
	}
	
	@Override
	public void update(BoardDto dto) throws Exception {
		boardDao.update(dto);
	}
	
	@Override
	public void delete(int boardId) throws Exception {
		boardDao.delete(boardId);
	}
	
	@Override
	public void increaseViews(int boardId, String userId) throws Exception {
		boardDao.increaseViews(boardId, userId);
	}
	
}
