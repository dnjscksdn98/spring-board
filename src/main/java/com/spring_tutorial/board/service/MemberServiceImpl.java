package com.spring_tutorial.board.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring_tutorial.board.model.dao.MemberDaoImpl;
import com.spring_tutorial.board.model.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDaoImpl memberDao;
	
	@Override
	public boolean loginCheck(MemberDto dto, HttpSession session) {
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
