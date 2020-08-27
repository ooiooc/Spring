package com.myspring.mapper;

import java.util.List;

import com.myspring.domain.BoardVO;
import com.myspring.domain.Criteria;

public interface BoardMapper {

	//글쓰기
	public void create(BoardVO vo) throws Exception;
	
	//제목 클릭 후 한건에 대한 select
	public BoardVO read(BoardVO vo) throws Exception;
	
	//글 수정
	public void update(BoardVO vo) throws Exception;
	
	//글 삭제
	public void delete(BoardVO vo) throws Exception;
	
	//페이징 처리 안된 목록 리스트
	public List<BoardVO> listAll() throws Exception;
	
	//페이징 처리된 목록 리스트
	public List<BoardVO> listPage(Criteria cri) throws Exception;

	//페이징 처리를 위한 카운팅
	public int getTotalCount(Criteria cri);
	
	//조회 수 추가 기능(제목을 클릭했을 때)
	public void updateViewcnt(BoardVO vo) throws Exception;
	
}

