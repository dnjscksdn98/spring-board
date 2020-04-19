package com.spring_tutorial.board.model.dto;

import java.sql.Date;

public class MemberDto {
	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private Date userRegDate;
	private Date userUpdateDate;
	
	public MemberDto() {
		
	}
	
	public MemberDto(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}

	public MemberDto(String userId, String userPw, String userName, String userEmail) {
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userEmail = userEmail;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserRegDate() {
		return userRegDate;
	}

	public void setUserRegDate(Date userRegDate) {
		this.userRegDate = userRegDate;
	}

	public Date getUserUpdateDate() {
		return userUpdateDate;
	}

	public void setUserUpdateDate(Date userUpdateDate) {
		this.userUpdateDate = userUpdateDate;
	}
	
}
