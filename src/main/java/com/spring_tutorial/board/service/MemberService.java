package com.spring_tutorial.board.service;

import javax.servlet.http.HttpSession;

import com.spring_tutorial.board.model.dto.MemberDto;

public interface MemberService {
	
	public void memberCheck(MemberDto dto, HttpSession session);
	
	public MemberDto viewMember(MemberDto dto);
	
	public void logout(HttpSession session);
	
	public void signup(MemberDto dto);
	
	public void pwCheck(String userPw, String confirmPw);
	
	public void idCheck(MemberDto dto);
}
