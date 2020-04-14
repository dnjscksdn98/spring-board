package com.spring_tutorial.board.model.dao;

import java.util.List;

import com.spring_tutorial.board.model.dto.BoardDto;

public interface BoardDao {
	
	public List<BoardDto> listAll() throws Exception;
	
	public void create(BoardDto dto) throws Exception;
	
	public BoardDto detail(int boardId) throws Exception;
	
	public void update(BoardDto dto) throws Exception;
	
	public void delete(int boardId) throws Exception;
	
	public void increaseViews(int boardId) throws Exception;
}