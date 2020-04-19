package com.spring_tutorial.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.spring_tutorial.board.model.dto.BoardDto;


public interface BoardService {
	
	public List<BoardDto> listAll(String searchOption, String keyword) throws Exception;
	
	public int countArticle(String searchOption, String keyword) throws Exception;
	
	public void create(BoardDto dto) throws Exception;
	
	public BoardDto detail(int boardId) throws Exception;
	
	public void update(BoardDto dto) throws Exception;
	
	public void delete(int boardId) throws Exception;
	
	public void increaseViews(int boardId, HttpSession session) throws Exception;
}
