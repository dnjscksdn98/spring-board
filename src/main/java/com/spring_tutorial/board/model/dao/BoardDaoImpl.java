package com.spring_tutorial.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring_tutorial.board.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BoardDto> listAll() throws Exception {
		return sqlSession.selectList("board.listAll");
	}
	
	@Override
	public void create(BoardDto dto) throws Exception {
		sqlSession.insert("board.create", dto);
	}
	
	@Override
	public BoardDto detail(int boardId) throws Exception {
		return sqlSession.selectOne("board.detail", boardId);
	}
	
	@Override
	public void update(BoardDto dto) throws Exception {
		sqlSession.update("board.update", dto);
	}
	
	@Override
	public void delete(int boardId) throws Exception {
		sqlSession.delete("board.delete", boardId);
	}
	
	@Override
	public void increaseViews(int boardId) throws Exception {
		
	}
}
