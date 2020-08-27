package com.myspring.mapper;

import java.util.List;

import com.myspring.domain.BoardAttachVO;

public interface BoardAttachMapper {

	//파일 업로드를 attach 테이블에 insert 
	public void insert (BoardAttachVO vo);
	
	//파일 업로드를 attach 테이블에 delete 
	public void delete (String uuid);
	
	//파일 업로드를 attach 테이블에 select
	public List<BoardAttachVO> select (int bno);
	
}
