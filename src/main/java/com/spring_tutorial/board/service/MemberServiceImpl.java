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
	
	// 로그인
	// 회원이 존재하는지 체크하고 존재하면 아이디와 이름을 세션에 저장
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
	
	// 회원 정보 추출
	@Override
	public MemberDto viewMember(MemberDto dto) {
		return memberDao.viewMember(dto);
	}
	
	// 로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();  // 모든 세션 정보 삭제
	}
	
	// 회원 가입
	@Override
	public void signup(MemberDto dto) {
		memberDao.signup(dto);
	}
	
	// 비밀번호 검증
	@Override
	public boolean pwCheck(String userPw, String confirmPw) {
		return (userPw.contentEquals(confirmPw)) ? false : true;
	}
	
	// 아이디 검증
	@Override
	public boolean idCheck(MemberDto dto) {
		return memberDao.idCheck(dto);
	}
}
