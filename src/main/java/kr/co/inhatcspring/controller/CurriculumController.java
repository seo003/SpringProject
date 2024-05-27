package kr.co.inhatcspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 교과과정 컨트롤러
@Controller
public class CurriculumController {

	@GetMapping("/grade1")
	public String grade1() {
		return "curriculum/grade1";
	}

	@GetMapping("/grade2")
	public String grade2() {
		return "curriculum/grade2";
	}

	@GetMapping("/grade3")
	public String grade3() {
		return "curriculum/grade3";
	}

	@GetMapping("/grade4")
	public String grade4() {
		return "curriculum/grade4";
	}
}