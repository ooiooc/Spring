package com.myspring.service;

import java.util.List;

import com.myspring.domain.BoardVO;
import com.myspring.domain.Criteria;

public interface BoardService {

	//글쓰기
	public void create(BoardVO vo) throws Exception;
		
	//제목 클릭 후 한 건에 대한 select
	public BoardVO read(BoardVO vo) throws Exception;
		
	//글 수정
	public void update(BoardVO vo) throws Exception;
	
	//글 삭제
	public void delete(BoardVO vo) throws Exception;
		
	//게시글 리스트(여러 건에 대한 select)
	public List<BoardVO> listAll() throws Exception;
	
	//페이징된 게시글 리스트
	public List<BoardVO> listPage(Criteria cri) throws Exception;
	
	//페이징 처리를 위한 카운팅
	public int getTotalCount(Criteria cri) throws Exception;

	
}

