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
	
	@RequestMapping("login_view.do")
	public String loginView() {
		return "member/login";
	}
	
	@RequestMapping("login.do")
	public ModelAndView login(@ModelAttribute MemberDto dto, HttpSession session) {
		memberService.login(dto, session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		mav.addObject("msg", "loginSuccess");
		return mav;
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		memberService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("signup_view.do")
	public String signupView() {
		return "member/signup";
	}
	
	@RequestMapping(value="signup.do", method=RequestMethod.POST)
	public ModelAndView signup(@RequestParam String userId, @RequestParam String userPw,
							   @RequestParam String confirmPw, @RequestParam String userName, 
							   @RequestParam String userEmail) {
		
		String encodedPw = memberService.pwConfirmCheck(userPw, confirmPw);
		memberService.signup(new MemberDto(userId, encodedPw, userName, userEmail));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		mav.addObject("msg", "signupSuccess");
		return mav;
	}
}
