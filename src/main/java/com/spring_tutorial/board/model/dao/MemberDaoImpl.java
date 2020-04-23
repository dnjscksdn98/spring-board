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
	public String memberCheck(MemberDto dto) {
		return sqlSession.selectOne("member.memberCheck", dto);
	}
	
	@Override
	public MemberDto viewMember(MemberDto dto) {
		return sqlSession.selectOne("member.viewMember", dto);
	}
	
	@Override
	public void signup(MemberDto dto) {
		sqlSession.insert("member.signup", dto);
	}
	
	@Override
	public boolean idCheck(MemberDto dto) {
		String name = sqlSession.selectOne("member.memberCheck", dto);
		return (name == null) ? false : true;
	}
}
