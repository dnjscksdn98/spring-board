package com.spring_tutorial.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring_tutorial.board.model.dto.MemberDto;
import com.spring_tutorial.board.service.MemberServiceImpl;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	MemberServiceImpl memberService;
	
	// 로그인 페이지
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}
	
	// 로그인
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberDto dto, HttpSession session) {
		memberService.login(dto, session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("msg", "loginSuccess");
		return mav;
	}
	
	// 로그아웃
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		memberService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
	// 회원가입 페이지
	@RequestMapping("signup.do")
	public String signup() {
		return "member/signup";
	}
	
	// 회원가입
	@RequestMapping(value="signupCheck.do", method=RequestMethod.POST)
	public ModelAndView signupCheck(@RequestParam String userId, @RequestParam String userPw,
									@RequestParam String confirmPw, @RequestParam String userName, 
									@RequestParam String userEmail) {
		
		String encodedPw = memberService.pwConfirmCheck(userPw, confirmPw);  // 암호화된 비밀번호 반환
		memberService.signup(new MemberDto(userId, encodedPw, userName, userEmail));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		mav.addObject("msg", "signupSuccess");
		return mav;
	}
}
