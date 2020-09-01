package com.myspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myspring.domain.MemberVO;
import com.myspring.mapper.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDAO memapper;
	
	public MemberVO login(MemberVO member) {
		return memapper.login(member);
	}

	@Override
	public void createMember(MemberVO vo) {
		memapper.createMember(vo);
	}

	@Override
	public int idChk(String userid){
		return memapper.idChk(userid);
	}
	
}
