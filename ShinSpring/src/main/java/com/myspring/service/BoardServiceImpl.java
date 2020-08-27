package com.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.domain.BoardAttachVO;
import com.myspring.domain.BoardVO;
import com.myspring.domain.Criteria;
import com.myspring.mapper.BoardAttachMapper;
import com.myspring.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	
	@Autowired
	private BoardAttachMapper attachmapper;
	
	//글쓰기
	@Transactional
	@Override
	
	public void create(BoardVO vo) throws Exception {
		//board테이블에 insert
		mapper.create(vo);
		
		//attach테이블에 insert
		vo.getAttachList().forEach(attach->{
			attach.setBno(vo.getBno());
			attachmapper.insert(attach);
		});
		
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
