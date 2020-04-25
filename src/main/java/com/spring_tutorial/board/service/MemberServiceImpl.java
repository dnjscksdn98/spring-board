package com.spring_tutorial.board.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring_tutorial.board.model.dao.MemberDaoImpl;
import com.spring_tutorial.board.model.dto.MemberDto;

import com.spring_tutorial.board.error.MemberNotFoundException;
import com.spring_tutorial.board.error.ConfirmPwDismatchException;
import com.spring_tutorial.board.error.IdAlreadyExistsException;
import com.spring_tutorial.board.error.InvalidPasswordException;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDaoImpl memberDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void login(MemberDto dto, HttpSession session) 
			throws MemberNotFoundException, InvalidPasswordException {
		if(pwDecodeCheck(dto)) {
			String name = memberDao.getUserName(dto.getUserId());
			session.setAttribute("userId", dto.getUserId());
			session.setAttribute("userName", name);
		}
	}
	
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	@Override
	public void signup(MemberDto dto) {
		try {
			memberDao.signup(dto);
		} catch(DuplicateKeyException e) {
			throw new IdAlreadyExistsException("이미 존재하는 아이디입니다");
		}
	}
	
	@Override
	public String pwConfirmCheck(String userPw, String confirmPw) {
		if(!userPw.contentEquals(confirmPw)) throw new ConfirmPwDismatchException("비밀번호가 불일치합니다");
		return passwordEncoder.encode(userPw);
	}
	
	@Override
	public boolean pwDecodeCheck(MemberDto dto) {
		String rawPassword = dto.getUserPw();
		String encodedPassword = memberDao.getEncodedPassword(dto.getUserId());
		if(encodedPassword == null) throw new MemberNotFoundException("존재하지 않는 회원입니다");
		
		boolean result = passwordEncoder.matches(rawPassword, encodedPassword);
		if(!result) throw new InvalidPasswordException("비밀번호가 틀렸습니다");
		return result;
	}
	
}
