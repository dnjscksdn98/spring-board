package com.spring_tutorial.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring_tutorial.board.model.dto.BoardDto;
import com.spring_tutorial.board.model.dao.BoardDao;


@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<BoardDto> listAll() throws Exception {
		return boardDao.listAll();
	}
	
	@Override
	public void create(BoardDto dto) throws Exception {
		
	}
	
	@Override
	public BoardDto detail(int boardId) throws Exception {
		
	}
	
	@Override
	public void update(BoardDto dto) throws Exception {
		
	}
	
	@Override
	public void delete(int boardId) throws Exception {
		
	}
	
	@Override
	public void increaseViews(int boardId, HttpSession session) throws Exception {
		
	}
	
}
