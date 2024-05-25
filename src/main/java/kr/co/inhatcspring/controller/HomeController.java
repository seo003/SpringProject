package kr.co.inhatcspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/introdution")
	public String introdution() {
		return "introdution";
	}
	
	@GetMapping("/history")
	public String history() {
		return "history";
	}
}