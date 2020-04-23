package com.spring_tutorial.board.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.spring_tutorial.board.error.MemberNotFoundException;

@ControllerAdvice
public class GlobalControllerAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalControllerAdvice.class);
	
	@ExceptionHandler(MemberNotFoundException.class)
	public ModelAndView handleMemberNotFoundException(MemberNotFoundException e) {
		logger.error(e.getMessage());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		mav.addObject("msg", "loginFailure");
		return mav;
	}
}
