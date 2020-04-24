package com.spring_tutorial.board.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.spring_tutorial.board.error.MemberNotFoundException;
import com.spring_tutorial.board.error.PasswordDismatchException;
import com.spring_tutorial.board.error.IdAlreadyExistsException;


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
	
	@ExceptionHandler(PasswordDismatchException.class)
	public ModelAndView handlePasswordDismatchException(PasswordDismatchException e) {
		logger.error(e.getMessage());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/signup");
		mav.addObject("msg", "pwError");
		return mav;
	}
	
	@ExceptionHandler(IdAlreadyExistsException.class)
	public ModelAndView handleIdAlreadyExistsException(IdAlreadyExistsException e) {
		logger.error(e.getMessage());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/signup");
		mav.addObject("msg", "idError");
		return mav;
	}
}
