package com.spring_tutorial.board.model.dao;

import javax.servlet.http.HttpSession;

import com.spring_tutorial.board.model.dto.MemberDto;

public interface MemberDao {
	
	public boolean loginCheck(MemberDto dto);
	
	public MemberDto viewMember(MemberDto dto);
	
	public void logout(HttpSession session);
}
