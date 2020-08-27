package com.myspring.service;

import com.myspring.domain.Criteria;
import com.myspring.domain.ReplyPageVO;
import com.myspring.domain.ReplyVO;

public interface ReplyService {
	
	//´ñ±Û ¸®½ºÆ® 
	public ReplyPageVO list(int bno, Criteria cri) throws Exception;

	//´ñ±Û ¾²±â
	public void create(ReplyVO vo) throws Exception;
	
	//´ñ±Û ¼öÁ¤
	public void update(ReplyVO vo) throws Exception;
	
	//´ñ±Û »èÁ¦
	public void delete(int rno) throws Exception;

}
