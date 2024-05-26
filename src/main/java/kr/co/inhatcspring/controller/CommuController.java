package kr.co.inhatcspring.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.inhatcspring.beans.Board;
import kr.co.inhatcspring.database.MapperInterface;

@Controller
public class CommuController {
	
	@Autowired
	MapperInterface mapper;
	
	// 자유게시판 Get
	@GetMapping("/board")
	public String board(Model model) {
		List<Board> boardList = mapper.selectAllByBoard(); //자유게시판 정보 가져오기
		Collections.reverse(boardList); // 리스트 뒤집기 (최신순 나열 위함)
		model.addAttribute("boardList", boardList); //model로 전송
		return "community/board";
	}
	
	// 공지사항 Get
	@GetMapping("/announce")
	public String announce(Model model) {
		List<Board> boardList = mapper.selectAllByAnnounce(); //공지사항 정보 가져오기
		Collections.reverse(boardList);
		model.addAttribute("boardList", boardList);
		return "community/announce";
	}

	//FAQ Get
	@GetMapping("/FAQ")
	public String faq(Model model) {
		List<Board> boardList = mapper.selectAllByFAQ(); //FAQ 정보 가져오기
		Collections.reverse(boardList);
		model.addAttribute("boardList", boardList);
		return "community/FAQ";
	}

	//글 작성 Get
	@GetMapping("/write")
	public String write(int category, Model model) {
		model.addAttribute("category", category); // 파라미터로 전달된 카테고리 값 model로 전송
		return "community/write";
	}
	
	//글 작성 Post
	@PostMapping("/write")
	public String write(Board board) {
		mapper.insertBoard(board); //전달된 객체 DB 저장
		
		// 카테고리에 맞춰 해당 페이지로 리다이렉트
		if (board.getCategory()==0) {
			return "redirect:/announce";
		}else if (board.getCategory()==1) {
			return "redirect:/FAQ";
		} else return "redirect:/board";
		
	}
	
	//글 내용 보기 Get
	@GetMapping("/view")
	public String view(int idx, Model model) {
		Board board = mapper.selectAllByIdx(idx); //idx값으로 게시물 정보 가져오기
		model.addAttribute("board", board);
		return "community/view";
	}
	
	//글 수정 Get
	@GetMapping("/edit")
	public String edit(int idx, Model model) {
		Board board = mapper.selectAllByIdx(idx); 
		model.addAttribute("board", board);
		return "community/edit";
	}
	
	//글 수정 Post
	@PostMapping("/edit")
	public String edit(Board board) {
		mapper.editBoard(board); //수정되어 전달된 값 DB 수정
		return "redirect:/view?idx=" + board.getIdx(); //view페이지에 파라미터 전달하여 리다이렉트
	}
}