package com.myspring.dbTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myspring.mapper.BoardMapper;
import com.myspring.domain.BoardVO;
import com.myspring.domain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")


public class BoardMapperTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardMapper boardmapper;
	
	@Test
	public void testCreate() throws Exception{
		BoardVO board = new BoardVO();
		
		board.setTitle("새로운 제목을 넣습니다.");
		board.setContent("새로운 내용을 넣습니다.");
		board.setWriter("Salrang");
		
		boardmapper.create(board);
	}
	
	@Test
	public void testRead() throws Exception{
		BoardVO board = new BoardVO();
		board.setBno(1);
		logger.info("제목을 클릭한 후 select = " + boardmapper.read(board));
		
	}
	
	@Test
	public void testUpdate() throws Exception{
		BoardVO board = new BoardVO();
		boardmapper.update(board);
		
	}
	
	@Test
	public void testDelete() throws Exception{
		BoardVO board = new BoardVO();
		board.setBno(1);
		boardmapper.update(board);
		
	}
	
	/*
	 * @Test public void testList() throws Exception{
	 * boardmapper.listAll().forEach(board->logger.info("" + board));
	 * 
	 * }
	 */
	/*
	@Test
	public void testListPage() throws Exception{
		Criteria cri = new Criteria();
		cri.setPageNum(2);
		cri.setAmount(10);
		boardmapper.listPage(cri).forEach(board->logger.info("" + board));
	}
	*/
	
	@Test
	public void testSearch() throws Exception{
		Criteria cri = new Criteria();
		cri.setKeyword("내용");
		cri.setType("C");
		boardmapper.listPage(cri).forEach(board->logger.info("" + board));
	}
	
	
}
