package com.spring_tutorial.board.service;

import javax.servlet.http.HttpSession;

import com.spring_tutorial.board.model.dto.MemberDto;

public interface MemberService {
	
	public void login(MemberDto dto, HttpSession session);
		
	public void logout(HttpSession session);
	
	public void signup(MemberDto dto);
	
	public String pwConfirmCheck(String userPw, String confirmPw);
	
	public boolean pwDecodeCheck(MemberDto dto);
	
}
