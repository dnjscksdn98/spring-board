package com.spring_tutorial.board.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.dao.DuplicateKeyException;
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
	public void login(MemberDto dto, HttpSession session) throws MemberNotFoundException {
		if(pwDecodeCheck(dto)) {
			String name = memberDao.getUserName(dto.getUserId());
			session.setAttribute("userId", dto.getUserId());
			session.setAttribute("userName", name);
		}
	}
	
	// 로그아웃
	@Override
	public void logout(HttpSession session) {
		session.invalidate();  // 모든 세션 정보 삭제
	}
	
	// 회원 가입
	@Override
	public void signup(MemberDto dto) {
		try {
			memberDao.signup(dto);
		} catch(DuplicateKeyException e) {
			throw new IdAlreadyExistsException("아이디가 이미 존재합니다");
		}
	}
	
	// 비밀번호 검증
	@Override
	public String pwConfirmCheck(String userPw, String confirmPw) {
		if(!userPw.contentEquals(confirmPw)) throw new PasswordDismatchException("비밀번호 불일치");
		return passwordEncoder.encode(userPw);  // 비밀번호를 암호화 후에 리턴
	}
	
	// 비밀번호 디코딩 비교
	@Override
	public boolean pwDecodeCheck(MemberDto dto) {
		String rawPassword = dto.getUserPw();
		String encodedPassword = memberDao.getEncodedPassword(dto.getUserId());
		
		if(encodedPassword == null) throw new MemberNotFoundException("존재하지 않는 회원입니다");
		
		boolean result = passwordEncoder.matches(rawPassword, encodedPassword);
		return result;
	}
	
}
