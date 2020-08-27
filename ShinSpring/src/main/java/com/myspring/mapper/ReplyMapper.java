package com.myspring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myspring.domain.Criteria;
import com.myspring.domain.ReplyPageVO;
import com.myspring.domain.ReplyVO;

public interface ReplyMapper {

	//댓글 리스트
	//@param 쓰는 원인 : caused by mybatis. 기본적으로 parameter 값을 한 개만 인지 
	public List<ReplyVO> list(@Param("bno") int bno, @Param("cri") Criteria cri) throws Exception;

	//현재 게시물 전체 댓글 수
	public int getCountByBno(int bno);
	
	//댓글 쓰기
	public void create(ReplyVO vo) throws Exception;
	
	//댓글 수정
	public void update(ReplyVO vo) throws Exception;

	//댓글 삭제
	public void delete(int rno) throws Exception;

	
}
