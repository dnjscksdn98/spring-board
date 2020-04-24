package com.spring_tutorial.board.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring_tutorial.board.model.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public String getUserName(String userId) {
		return sqlSession.selectOne("member.getUserName", userId);
	}
	
	@Override
	public String getEncodedPassword(String userId) {
		return sqlSession.selectOne("member.getEncodedPassword", userId);
	}
	
	@Override
	public void signup(MemberDto dto) {
		sqlSession.insert("member.signup", dto);
	}
	
}
