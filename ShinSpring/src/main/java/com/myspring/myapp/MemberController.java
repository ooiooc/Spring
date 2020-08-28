package com.myspring.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("member")
public class MemberController {
	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	//회원가입 화면 폼
	@RequestMapping(value = "member", method = RequestMethod.GET)
	public void memberget() {
		
	}
	
	//로그인 화면 폼
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void loginGet() throws Exception{
		logger.info("로그인 화면 이동");
	}
	
	//
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public void loginPost() throws Exception{
		logger.info("로그인 화면");
	}
	
	
}//end
