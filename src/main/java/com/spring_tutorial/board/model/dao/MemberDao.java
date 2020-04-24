package com.spring_tutorial.board.model.dao;

import com.spring_tutorial.board.model.dto.MemberDto;

public interface MemberDao {
		
	public String getUserName(String userId);
	
	public String getEncodedPassword(String userId);
	
	public void signup(MemberDto dto);
	
}
