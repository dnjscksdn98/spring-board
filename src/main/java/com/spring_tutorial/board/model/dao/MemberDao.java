package com.spring_tutorial.board.model.dao;

import com.spring_tutorial.board.model.dto.MemberDto;

public interface MemberDao {
	
	public String memberCheck(MemberDto dto);
	
	public MemberDto viewMember(MemberDto dto);
	
	public void signup(MemberDto dto);
	
	public boolean idCheck(MemberDto dto);
}
