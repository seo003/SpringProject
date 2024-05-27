package kr.co.inhatcspring.beans;

//게시물
public class Board {
	private int idx; // 게시물 번호(1부터 자동 증가)
	private String title; // 게시물 제목
	private String content; // 게시물 내용
	private int category; //게시판 종류(0:공지사항, 1:FAQ, 2:자유게시판)

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

}
