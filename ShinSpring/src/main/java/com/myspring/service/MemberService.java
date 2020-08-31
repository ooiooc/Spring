package com.myspring.service;

import com.myspring.domain.MemberVO;

public interface MemberService {
	
	//로그인 정보 조회(select)
	public MemberVO login(MemberVO member);
	
	//회원가입 insert하기 위한 service 
	public void createMember(MemberVO vo);
}
