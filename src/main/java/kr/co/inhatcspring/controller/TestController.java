package kr.co.inhatcspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.inhatcspring.beans.DataBean;
import kr.co.inhatcspring.database.MapperInterface;

@Controller
public class TestController {

	// 쿼리를 날려주는 mapper 파일 자동 주입
	@Autowired
	MapperInterface mapper1;

	@GetMapping("/input_data")
	public String input_data() {
		return "input_data";
	}

	// 객체를 통해 넘겨받은 값을 mapper1 객체에 세팅
	@PostMapping("/input_pro")
	public String input_pro(DataBean dataBean) {
		mapper1.insert_data(dataBean);
		return "input_pro";
	}

	// mapper 객체를 통해 받은 값 list로 받은 후 출력
	@GetMapping("/read_data")
	public String read_data(Model model) {
		List<DataBean> list = mapper1.select_data();
		model.addAttribute("list", list);
		return "read_data";
	}
}