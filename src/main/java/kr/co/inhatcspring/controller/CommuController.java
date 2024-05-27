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

// 커뮤니티 컨트롤러
@Controller
public class CommuController {

	@Autowired
	MapperInterface mapper;

	// 자유게시판
	@GetMapping("/board")
	public String board(Model model) {
		List<Board> boardList = mapper.selectAllByBoard(); // 자유게시판 정보 가져오기
		Collections.reverse(boardList); // 리스트 뒤집기 (최신순 나열 위함)
		model.addAttribute("boardList", boardList); // model로 전송
		return "community/board";
	}

	// 공지사항
	@GetMapping("/announce")
	public String announce(Model model) {
		List<Board> boardList = mapper.selectAllByAnnounce(); // 공지사항 정보 가져오기
		Collections.reverse(boardList);
		model.addAttribute("boardList", boardList);
		return "community/announce";
	}

	// FAQ
	@GetMapping("/FAQ")
	public String faq(Model model) {
		List<Board> boardList = mapper.selectAllByFAQ(); // FAQ 정보 가져오기
		Collections.reverse(boardList);
		model.addAttribute("boardList", boardList);
		return "community/FAQ";
	}

	// 글 작성 
	@GetMapping("/write")
	public String write(int category, Model model) {
		model.addAttribute("category", category); // 파라미터로 전달된 카테고리 값 model로 전송
		return "community/write";
	}

	// 글 작성 Post
	@PostMapping("/write")
	public String write(Board board) {
		mapper.insertBoard(board); // 작성된 게시물 저장

		// 카테고리에 맞춰 해당 페이지로 리다이렉트
		return getRedirectUrlByCategory(board.getCategory());

	}

	// 글 내용
	@GetMapping("/view")
	public String view(int idx, Model model) {
		Board board = mapper.selectAllByIdx(idx); // idx값으로 게시물 정보 가져오기
		model.addAttribute("board", board);
		return "community/view";
	}

	// 글 수정 
	@GetMapping("/edit")
	public String edit(int idx, Model model) {
		Board board = mapper.selectAllByIdx(idx);
		model.addAttribute("board", board);
		return "community/edit";
	}

	// 글 수정 Post
	@PostMapping("/edit")
	public String edit(Board board) {
		mapper.editBoard(board); // 수정되어 전달된 값 DB 수정
		return "redirect:/view?idx=" + board.getIdx(); // view페이지에 파라미터 전달하여 리다이렉트
	}

	// 글 삭제
	@GetMapping("/delete")
	public String delete(int idx, int category) {
		mapper.deleteBoard(idx);
		// 삭제된 게시물 카테고리에 맞춰 해당 페이지로 리다이렉트
		return getRedirectUrlByCategory(category);
	}

	// 카테고리별 리다이렉트 URL 반환 함수
	private String getRedirectUrlByCategory(int category) {
		switch (category) {
		case 0:
			return "redirect:/announce"; // 공지사항
		case 1:
			return "redirect:/FAQ"; // FAQ
		case 2:
			return "redirect:/board"; // 자슈게시판
		default:
			return "/";
		}
	}
}