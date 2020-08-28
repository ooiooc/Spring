package com.myspring.mapper;

import java.util.List;

import com.myspring.domain.MemberVO;

public interface MemberDAO {
	
	//회원가입(insert)
	public void createMember(MemberVO vo);
	
	//회원가입(내정보) 수정하기 전 데이터 조회
	//public MemberVO memberRead(String userid);
	public MemberVO memberRead(MemberVO vo);
	public List<MemberVO> memberList();
	//레코드 값을 다 불러오기 위해 () 안에 특정 인자값을 넣지 않아도 된다
	public void updateMember(MemberVO vo);
	
	public void deleteMember(MemberVO vo);

	//로그인 정보 조회 (select)
	public MemberVO login(MemberVO vo);
	

}