package com.spring_tutorial.board.model.dao;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring_tutorial.board.model.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public boolean loginCheck(MemberDto dto) {
		String name = sqlSession.selectOne("member.loginCheck", dto);
		return (name == null) ? false : true;
	}
	
	@Override
	public MemberDto viewMember(MemberDto dto) {
		return sqlSession.selectOne("member.viewMember", dto);
	}
	
	@Override
	public void logout(HttpSession session) {
		
	}
}
