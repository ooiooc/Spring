package com.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.domain.BoardVO;
import com.myspring.domain.Criteria;
import com.myspring.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	//±Û¾²±â
	@Override
	public void create(BoardVO vo) throws Exception {
		mapper.create(vo);
	}
	
	@Transactional
	@Override
	public BoardVO read(BoardVO vo) throws Exception {
		mapper.updateViewcnt(vo);
		return mapper.read(vo);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		mapper.update(vo);
	}

	@Override
	public void delete(BoardVO vo) throws Exception {
		mapper.delete(vo);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return mapper.listAll();
	}
	
	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		return mapper.listPage(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) throws Exception {
		return mapper.getTotalCount(cri);
	}
	
	
}
