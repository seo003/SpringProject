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
		List<Board> boardList = mapper.selectAllByBoard();
		Collections.reverse(boardList); // 리스트 뒤집기 (최신순 나열 위함)
		model.addAttribute("boardList", boardList);
		return "community/board";
	}
	
	// 공지사항 Get
	@GetMapping("/announce")
	public String announce(Model model) {
		List<Board> boardList = mapper.selectAllByAnnounce();
		Collections.reverse(boardList); 
		model.addAttribute("boardList", boardList);
		return "community/announce";
	}

	//FAQ Get
	@GetMapping("/FAQ")
	public String faq(Model model) {
		List<Board> boardList = mapper.selectAllByFAQ();
		Collections.reverse(boardList);
		model.addAttribute("boardList", boardList);
		return "community/FAQ";
	}

	//글 작성 Get
	@GetMapping("/write")
	public String write(int category, Model model) {
		model.addAttribute("category", category);
		return "community/write";
	}
	
	//글 작성 Post
	@PostMapping("/write")
	public String write(Board board) {
		mapper.insertBoard(board);
		if (board.getCategory()==0) {
			return "redirect:/announce";
		}else if (board.getCategory()==1) {
			return "redirect:/FAQ";
		} else return "redirect:/board";
		
	}
	
	//글 내용 보기 Get
	@GetMapping("/view")
	public String view(int idx, Model model) {
		Board board = mapper.selectAllByIdx(idx);
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
		mapper.editBoard(board);
		return "redirect:/view?idx=" + board.getIdx();
	}
}