package com.myspring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterseptor extends HandlerInterceptorAdapter {
	
	public static final Logger logger = LoggerFactory.getLogger(AuthInterseptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		//session 사용 선언
		HttpSession session = request.getSession();
		//session에 로그인 정보가 없으면 (=로그인을 하지 않았으면)
		if(session.getAttribute("login") == null) {
			
			logger.info("user not logined");
			
			//로그인 안한 사용자는 글쓰기 권한이 없으므로 로그인 페이지로 이동
			response.sendRedirect("myapp/login");
			return false; //글쓰기하지 못하도록 false 값
		}
		
		//로그인이 되있으면 권한 주기
		return true;
	}
	
}
