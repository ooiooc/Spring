package com.myspring.dbTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myspring.domain.Criteria;
import com.myspring.domain.ReplyVO;
import com.myspring.mapper.ReplyMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class ReplyMapperTest {

private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ReplyMapper remapper;
	
	//댓글 리스트
//	@Test
//	public void testList() throws Exception{
//		ReplyVO vo = new ReplyVO();
//		Criteria cri = new Criteria();
//		
//		vo.setBno(2);
//		List<ReplyVO> replies = remapper.list(vo, cri);
//		replies.forEach(reply->logger.info("" + reply));
//	}
	
	//댓글 추가
	@Test public void testCreate() throws Exception{ 
		
		ReplyVO vo = new ReplyVO();
	  
		//게시글번호 
		vo.setBno(3); 
		//게시글
		vo.setReplytext("댓글댓글댓글 끄적끄적"); 
		//작성자
		vo.setReplyer("관리자");
	 
	 remapper.create(vo); 
	}
	 
	//댓글 수정
	@Test
	public void testUpdate() throws Exception{
		
		ReplyVO vo = new ReplyVO();
		vo.setRno(2);
		vo.setReplytext("댓글 수정 테스트");
		
		remapper.update(vo);
		
	}
	
	//댓글 삭제
	@Test
	public void testDelete(int rno) throws Exception{
		
		ReplyVO vo = new ReplyVO();
		
		vo.setRno(4);
		remapper.delete(rno);
		
	}
	
}
