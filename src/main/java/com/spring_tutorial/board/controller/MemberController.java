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
		boolean result = memberService.loginCheck(dto, session);
		ModelAndView mav = new ModelAndView();
		
		if(result) {
			mav.setViewName("home");
			mav.addObject("msg", "success");
		}
		else {
			mav.setViewName("member/login");
			mav.addObject("msg", "failure");
		}
		return mav;
	}
}
