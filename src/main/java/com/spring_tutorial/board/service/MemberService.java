package com.spring_tutorial.board.service;

import javax.servlet.http.HttpSession;

import com.spring_tutorial.board.model.dto.MemberDto;

public interface MemberService {
	
	public boolean loginCheck(MemberDto dto, HttpSession session);
	
	public MemberDto viewMember(MemberDto dto);
	
	public void logout(HttpSession session);
}
