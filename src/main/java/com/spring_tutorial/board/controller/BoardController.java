package com.spring_tutorial.board.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring_tutorial.board.model.dto.BoardDto;
import com.spring_tutorial.board.service.BoardPager;
import com.spring_tutorial.board.service.BoardServiceImpl;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	BoardServiceImpl boardService;
	
	// 게시글 목록
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue="title") String searchOption,
							@RequestParam(defaultValue="") String keyword,
							@RequestParam(defaultValue="1") int curPage) throws Exception {
		
		// 게시글 수 계산
		int count = boardService.countArticle(searchOption, keyword);
		
		// 페이징
		BoardPager boardPager = new BoardPager(count, curPage);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		// 조회
		List<BoardDto> list = boardService.listAll(start, end, searchOption, keyword);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("boardPager", boardPager);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("board/list");
		
		return mav;
	}
	
	// 글쓰기 페이지
	@RequestMapping(value="write.do", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	
	// 글 수정 페이지
	@RequestMapping(value="update_view.do", method=RequestMethod.GET)
	public ModelAndView updateView(@RequestParam int boardId) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("board/update");
		mav.addObject("dto", boardService.detail(boardId));
		
		return mav;
	}
	
	// 글쓰기
	@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public String create(@ModelAttribute BoardDto dto, HttpSession session) throws Exception {
		String writer = (String)session.getAttribute("userId");
		dto.setWriter(writer);
		boardService.create(dto);
		return "redirect:list.do";
	}
	
	// 게시글 상세 정보 페이지
	@RequestMapping(value="detail.do", method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam int boardId, HttpSession session) throws Exception {
		String userId = (String)session.getAttribute("userId");
		if(userId != null) {
			boardService.increaseViews(boardId, userId);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/detail");
		mav.addObject("dto", boardService.detail(boardId));
		
		return mav;
	}
	
	// 글 수정
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute BoardDto dto) throws Exception {
		boardService.update(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/detail");
		mav.addObject("dto", boardService.detail(dto.getBoardId()));
		
		return mav;
	}
	
	// 글 삭제
	@RequestMapping(value="delete.do")
	public String delete(@RequestParam int boardId) throws Exception {
		boardService.delete(boardId);
		return "redirect:list.do";
	}
	
}
