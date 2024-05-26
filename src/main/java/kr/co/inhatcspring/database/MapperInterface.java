package kr.co.inhatcspring.database;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.inhatcspring.beans.Board;

public interface MapperInterface {
	// 게시판 DB(schoolPost)에 데이터 저장
	@Insert("insert into schoolPost (title, content, category) values (#{title}, #{content}, ${category})")
	void insertBoard(Board board);

	// 공지사항 내용 검색
	@Select("select * from schoolPost where category=0")
	List<Board> selectAllByAnnounce();

	// FAQ 내용 검색
	@Select("select * from schoolPost where category=1")
	List<Board> selectAllByFAQ();

	// 자유게시판 내용 검색
	@Select("select * from schoolPost where category=2")
	List<Board> selectAllByBoard();
	
	// idx로 내용 검색(게시물 내용 보기)
	@Select("select * from schoolPost where idx = #{idx}")
	Board selectAllByIdx(int idx);
	
	// 게시물 수정
	@Update("update schoolPost set title=#{title}, content=#{content} where idx = #{idx}")
	void editBoard(Board board);
}