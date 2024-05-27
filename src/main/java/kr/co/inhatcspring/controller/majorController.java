package kr.co.inhatcspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 학과 안내 컨트롤러
@Controller
public class majorController {
	@GetMapping("/introdution")
	public String introdution() {
		return "majorInfo/introdution";
	}
	
	@GetMapping("/history")
	public String history() {
		return "majorInfo/history";
	}
}