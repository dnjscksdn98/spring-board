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
	public boolean memberCheck(MemberDto dto, HttpSession session) {
		boolean result = memberDao.memberCheck(dto);
		
		if(result) {
			MemberDto dto2 = viewMember(dto);
			
			session.setAttribute("userId", dto2.getUserId());
			session.setAttribute("userName", dto2.getUserName());
		}
		return result;
	}
	
	@Override
	public MemberDto viewMember(MemberDto dto) {
		return memberDao.viewMember(dto);
	}
	
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	@Override
	public void signup(MemberDto dto) {
		memberDao.signup(dto);
	}
	
	@Override
	public boolean pwCheck(String userPw, String confirmPw) {
		return (userPw.contentEquals(confirmPw)) ? true : false;
	}
	
	@Override
	public boolean idCheck(MemberDto dto) {
		return memberDao.idCheck(dto);
	}
}
