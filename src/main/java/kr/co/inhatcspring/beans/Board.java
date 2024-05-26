package kr.co.inhatcspring.beans;

public class Board {
	private int idx;
	private String title;
	private String content;
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
