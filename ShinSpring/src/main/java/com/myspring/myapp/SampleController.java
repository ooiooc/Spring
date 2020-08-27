package com.myspring.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.domain.SampleDTO;
import com.myspring.domain.SampleDTOList;

@Controller
@RequestMapping(value="board")
public class SampleController {
	
	public static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//첫번째 방법
	@RequestMapping(value="doW", method = RequestMethod.GET)
	public void doW(@RequestParam("id") String id,  @RequestParam("password") String password, @RequestParam("name") String name, @RequestParam("phone") int phone) {
		logger.info("@RequestMapping doW가 호출되었습니다");
	}
	//두번째 방법 메모리 관리 측면에서 효율성은 DTO 제작하는 것이 낫다
	//DTO는 주소값만 넘기는 것이므로 많은 수의 데이터를 넘길 때는 두번째 방법을 활용하는 것이 좋다
	@RequestMapping(value="doM", method = RequestMethod.GET)
	public String doM(SampleDTO sdto) {
		logger.info("@RequestMapping doM이 호출되었습니다");
		return("aaa"); //데이터 전달 x 단순 화면 이동
	}
	
	@RequestMapping(value="doD", method = RequestMethod.GET)
	public String doD(SampleDTOList list, Model model) {		
		logger.info("SampleDTOList" + list);
		logger.info("@RequestMapping doD가 호출되었습니다");
		
		model.addAttribute("abc", "doD에 전달하고자 하는 데이터");
		
		return("bbb"); //데이터 전달(bbb.jsp)
	}
	
	@RequestMapping(value="doR", method = RequestMethod.GET)
	public void doR() {
		logger.info("@RequestMapping doR이 호출되었습니다");
	}
	
	//redirect 처리
	@RequestMapping(value = "doE", method = RequestMethod.GET)
	public String doE(RedirectAttributes rttr) {
		logger.info("doE 실행완료");
		rttr.addFlashAttribute("msg", "리다이렉트에 보낼 메세지 :D");
		return "redirect:/board/doF";
	}
	
	@RequestMapping(value = "doF", method = RequestMethod.GET)
	public void doF() {
		logger.info("doF 실행완료");
	}
	
	//JSON 데이터 처리
	@RequestMapping(value= "/doJSON", method = RequestMethod.GET)
	public @ResponseBody SampleDTO doJSON () {
		SampleDTO dto = new SampleDTO();
		dto.setId("abc");
		dto.setPassword("1234");
		
		return dto;
	}
	
	
}