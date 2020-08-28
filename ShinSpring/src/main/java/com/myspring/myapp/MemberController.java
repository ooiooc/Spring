package com.myspring.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.domain.MemberVO;
import com.myspring.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService meservice;
	
	//회원가입 화면 폼
	@RequestMapping(value = "member", method = RequestMethod.GET)
	public void memberget() {
		
	}
	
	//로그인 화면 폼
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void loginGet() throws Exception{
		logger.info("로그인 화면 이동");
	}
	
	//로그인 처리
	@RequestMapping(value = "loginPost", method = RequestMethod.POST)
	public void loginPost(MemberVO member, Model model) throws Exception{
		
		logger.info("로그인 처리");
		
		MemberVO vo = meservice.login(member);
		
		logger.info("vo 값은 "+ vo);
	
		
		//로그인이 안되었으면 return 하기 (48번째 라인 실행 x)
		//select된 결과(vo)가 null이면
		if(vo == null) {
			return;
		}
		
		// 로그인 조회 정보를 userVO 변수에 저장해서 login.jsp에 처리
		model.addAttribute("userVO", vo);	
	
	}//end 로그인처리
	
	//
	
}//end
