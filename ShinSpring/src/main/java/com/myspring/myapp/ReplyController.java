package com.myspring.myapp;

import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.domain.Criteria;
import com.myspring.domain.ReplyPageVO;
import com.myspring.domain.ReplyVO;
import com.myspring.service.ReplyService;

@RestController
@RequestMapping("replies")
public class ReplyController {

	@Autowired
 	private ReplyService reservice;
//	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//´ñ±Û ¸ñ·Ï ¸®½ºÆ®
	@RequestMapping(value = "all/{bno}/{page}", method = RequestMethod.GET)
	public ResponseEntity<ReplyPageVO> list(@PathVariable("bno") int bno, @PathVariable("page") int page) throws Exception{
		System.out.println("bno=" + bno);
		Criteria cri = new Criteria(page,10);
		return new ResponseEntity<>(reservice.list(bno, cri), HttpStatus.OK);
	}
	
	//´ñ±Û ¾²±â
	@RequestMapping(value="", method = RequestMethod.POST)
	public ResponseEntity<String> list(@RequestBody ReplyVO vo) throws Exception{
//		logger.info("reply create post" + vo);	
		ResponseEntity<String> entity = null;
		
		try {
			reservice.create(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//´ñ±Û ¼öÁ¤
	@RequestMapping(value="{rno}", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable("rno") int rno, @RequestBody ReplyVO vo) throws Exception{
		
		ResponseEntity<String> entity = null;
		
		try {
			vo.setRno(rno);
			reservice.update(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//´ñ±Û »èÁ¦
	@RequestMapping(value="{rno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("rno") int rno) throws Exception{
		
		ResponseEntity<String> entity = null;
		
		try {
		
			reservice.delete(rno);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
