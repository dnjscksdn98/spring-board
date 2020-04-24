package com.spring_tutorial.board.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring_tutorial.board.model.dao.MemberDaoImpl;
import com.spring_tutorial.board.model.dto.MemberDto;

import com.spring_tutorial.board.error.MemberNotFoundException;
import com.spring_tutorial.board.error.PasswordDismatchException;
import com.spring_tutorial.board.error.IdAlreadyExistsException;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDaoImpl memberDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	// 로그인
	@Override
	public void memberCheck(MemberDto dto, HttpSession session) {
		String name = memberDao.memberCheck(dto);
		if(name == null) {
			throw new MemberNotFoundException("존재하지 않는 회원입니다");
		}
		session.setAttribute("userId", dto.getUserId());
		session.setAttribute("userName", name);
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
	public String pwCheck(String userPw, String confirmPw) {
		if(!userPw.contentEquals(confirmPw)) {
			throw new PasswordDismatchException("비밀번호 불일치");
		}
		return passwordEncoder.encode(userPw);
	}
	
	// 아이디 검증
	@Override
	public void idCheck(MemberDto dto) {
		boolean result = memberDao.idCheck(dto);
		if(!result) { 
			throw new IdAlreadyExistsException("아이디가 이미 존재합니다");
		}
	}
	
}
