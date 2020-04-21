package com.spring_tutorial.board.service;

public class BoardPager {
	public static final int PAGE_SCALE = 5;  // 페이지당 게시물 수
	public static final int BLOCK_SCALE = 5;  // 블록당 페이지 수
	
	private int curPage;  // 현재 페이지
	private int prevPage;  // 이전 페이지
	private int nextPage;  // 다음 페이지
	private int totPage;  // 전체 페이지 수
	private int totBlock;  // 전체 블록 수
	private int curBlock;  // 현재 페이지 블록
	private int prevBlock;  // 이전 페이지 블록
	private int nextBlock;  // 다음 페이지 블록
	private int pageBegin;  // 현재 페이지 시작 번호
	private int pageEnd;  // 현재 페이지 끝 번호
	private int blockBegin;  // 현재 블록 시작 번호
	private int blockEnd;  // 현재 블록 끝 번호
	
	// 레코드 개수, 현재 페이지 번호
	public BoardPager(int count, int curPage) {
		this.curBlock = 1;
		this.curPage = curPage;
		setTotPage(count);
		setPageRange();
		setTotBlock();
		setBlockRange();
	}
	
	public void setBlockRange() {
		curBlock = (int)Math.ceil((curPage - 1) / BLOCK_SCALE) + 1;  // 현재 페이지가 몇번째 블록에 속하는지 계산
		blockBegin = (curBlock - 1) * BLOCK_SCALE + 1;  // 현재 페이지의 블록 시작 번호 계산
		blockEnd = blockBegin + BLOCK_SCALE - 1;  // 현재 페이지의 블록 끝 번호 계산
		if(blockEnd > totPage) blockEnd = totPage;  // 마지막 블록이 범위를 초과하지 않도록 계산
		prevPage = (curPage == 1) ? 1 : (curBlock - 1) * BLOCK_SCALE;  // 이전을 눌렀을때 이동할 페이지의 블록 시작 번호
		nextPage = curBlock > totBlock ? (curBlock * BLOCK_SCALE) : (curBlock * BLOCK_SCALE) + 1;  // 다음을 눌렀을때 이동할 페이지의 블록 끝번호
		if(nextPage >= totPage) nextPage = totPage;  // 마지막 페이지가 범위를 초과하지 않도록 계산
	}
	
	public void setPageRange() {
		pageBegin = (curPage - 1) * PAGE_SCALE + 1;
		pageEnd = pageBegin + PAGE_SCALE - 1;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotPage() {
		return totPage;
	}

	public void setTotPage(int count) {
		totPage = (int)Math.ceil(count * 1.0 / PAGE_SCALE);
	}

	public int getTotBlock() {
		return totBlock;
	}

	public void setTotBlock() {
		totBlock = (int)Math.ceil(totPage / BLOCK_SCALE);
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}

	public int getPrevBlock() {
		return prevBlock;
	}

	public void setPrevBlock(int prevBlock) {
		this.prevBlock = prevBlock;
	}

	public int getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(int nextBlock) {
		this.nextBlock = nextBlock;
	}

	public int getPageBegin() {
		return pageBegin;
	}

	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}

	public int getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getBlockBegin() {
		return blockBegin;
	}

	public void setBlockBegin(int blockBegin) {
		this.blockBegin = blockBegin;
	}

	public int getBlockEnd() {
		return blockEnd;
	}

	public void setBlockEnd(int blockEnd) {
		this.blockEnd = blockEnd;
	}
	
}
