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
		return false;
	}
	
	@Override
	public MemberDto viewMember(MemberDto dto) {
		return null;
	}
	
	@Override
	public void logout(HttpSession session) {
		
	}
}
