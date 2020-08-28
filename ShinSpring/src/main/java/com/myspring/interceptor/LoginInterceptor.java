package com.myspring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class LoginInterceptor extends HandlerInterceptorAdapter {
	public static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, 
							HttpServletResponse response, Object handler, 
							ModelAndView modelAndView) throws Exception {
	
	//MemberController에 loginPost 메소드에 얻은 select 결과의 model 정보를 interceptor 해서 
	//session 영역에 저장 (model에 있는 userVO를 가져와서 HttpSession에서 로그인 처리
	//session을 사용하기 위해서 아래와 같이 선언해주기
	HttpSession session = request.getSession();
	
	//MemberController에 loginPost 메소드에 얻은 select 결과의 model(userVO) 정보 불러오기
	Object userVO = modelAndView.getModel().get("userVO");
	
	//userVO에 정보가 있으면
	if(userVO != null) {
		logger.info("new login success");
		session.setAttribute("login", userVO);
		response.sendRedirect("/myapp"); //메인으로 돌아가기
		}
		// 세션에 userVO값 저장
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
							HttpServletResponse response, 
							Object handler) throws Exception {
		System.out.println("post handle......");
		return true;
	}
	
}
