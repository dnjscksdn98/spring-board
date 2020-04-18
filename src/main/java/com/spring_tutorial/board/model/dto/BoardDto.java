package com.spring_tutorial.board.model.dto;

import java.util.Date;

public class BoardDto {
	private int boardId;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int views;
	
	public BoardDto() {
		
	}
	
	public BoardDto(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	public BoardDto(int boardId, String title, String content, String writer, Date regDate, int views) {
		this.boardId = boardId;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regDate = regDate;
		this.views = views;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
	
}
