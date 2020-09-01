package com.myspring.myapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspring.domain.MemberVO;
import com.myspring.domain.ReplyPageVO;
import com.myspring.domain.ReplyVO;
import com.myspring.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService meservice;
	
	//회원가입 화면 폼  =================================================
	@RequestMapping(value = "member", method = RequestMethod.GET)
	public void memberget() {
		logger.info("회원가입 폼으로 이동");
	}
	
	//회원가입 처리  =================================================
	@RequestMapping(value = "member", method = RequestMethod.POST)
	public void memberpost(MemberVO vo) {
		meservice.createMember(vo); //service불러오기
			
	}
	
	//로그인 화면 폼  =================================================
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void loginGet() throws Exception{
		logger.info("로그인 화면 이동");
	}
	
	//로그인 처리 =================================================
	@RequestMapping(value = "loginPost", method = RequestMethod.POST)
	public String loginPost(MemberVO member, Model model, HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession();
		
		logger.info("로그인 처리");
		
		MemberVO vo = meservice.login(member);
		
		//만약에 interceptor를 사용하지 않고 로그인 처리를 하고자 할 때는 아래처럼 작성할 것
		if(vo != null ) { //로그인이 되었으면
			
			session.setAttribute("login", vo);
			logger.info("세션 값은 " + session.getAttribute("login"));
			return "redirect:/";
		
		}else{ //로그인이 되어있지 않으면, login.jsp로 이동
			
			return "redirect:/member/login";
			
		}

	
	}//end 로그인처리
	
	//아이디 중복체크
	@ResponseBody
	@RequestMapping(value = "checkId/{userid}", method = RequestMethod.GET)
		public ResponseEntity<Integer> idChk(@PathVariable("userid") String userid) throws Exception{
		logger.info("aaa");
		int result=meservice.idChk(userid);
		
		logger.info(userid);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	//end 아이디 중복체크

	
}//end
