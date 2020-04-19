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
	
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberDto dto, HttpSession session) {
		boolean result = memberService.memberCheck(dto, session);
		ModelAndView mav = new ModelAndView();
		
		if(result) {
			mav.setViewName("main");
			mav.addObject("msg", "loginSuccess");
		}
		else {
			mav.setViewName("member/login");
			mav.addObject("msg", "loginFailure");
		}
		return mav;
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		memberService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("signup.do")
	public String signup() {
		return "member/signup";
	}
	
	@RequestMapping(value="signupCheck.do", method=RequestMethod.POST)
	public ModelAndView signupCheck(@RequestParam String userId, @RequestParam String userPw,
								@RequestParam String confirmPw, @RequestParam String userName, 
								@RequestParam String userEmail) {
		
		ModelAndView mav = new ModelAndView();
		
		// password validation
		boolean result1 = memberService.pwCheck(userPw, confirmPw);
		if(!result1) {
			mav.setViewName("member/signup");
			mav.addObject("msg", "pwError");
			return mav;
		}
		
		// id validation
		boolean result2 = memberService.idCheck(new MemberDto(userId, userPw));
		if(result2) {
			mav.setViewName("member/signup");
			mav.addObject("msg", "idError");
			return mav;
		}
		
		// signup
		memberService.signup(new MemberDto(userId, userPw, userName, userEmail));
		mav.setViewName("member/login");
		mav.addObject("msg", "signupSuccess");
		
		return mav;
	}
}
