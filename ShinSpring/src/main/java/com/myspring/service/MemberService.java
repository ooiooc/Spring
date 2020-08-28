package com.myspring.service;

import com.myspring.domain.MemberVO;

public interface MemberService {
	
	//로그인 정보 조회(select)
	public void login(MemberVO member);

}
