package com.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.domain.Criteria;
import com.myspring.domain.ReplyPageVO;
import com.myspring.domain.ReplyVO;
import com.myspring.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private ReplyMapper remapper;
	
	public ReplyPageVO list (int bno, Criteria cri) throws Exception{
		//cri 안에 pageNum, amount 들어있다는 것 기억
		System.out.println("service bno = " + bno);
		return new ReplyPageVO(remapper.list(bno, cri), remapper.getCountByBno(bno));
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		remapper.create(vo);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		remapper.update(vo);
		
	}

	@Override
	public void delete(int rno) throws Exception {
		remapper.delete(rno);
	}

	
	
}
