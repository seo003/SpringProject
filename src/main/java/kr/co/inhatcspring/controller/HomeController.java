package kr.co.inhatcspring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 메인, 오시는 길 컨트롤러
@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/wayToCome")
	public String wayToCome() {
		return "wayToCome";
	}
}