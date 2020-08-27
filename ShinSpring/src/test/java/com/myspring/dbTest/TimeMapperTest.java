package com.myspring.dbTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.myspring.mapper.TimeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

public class TimeMapperTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TimeMapper timeMapper;
	
	@Test 
	public void testGetTime() {
		
			logger.info(timeMapper.getClass().getName());
			logger.info(timeMapper.getTime());
			//콘솔에서 출력되는 지 확인
		
	}
	
	@Test 
	public void testGetTime2() {
		
			logger.info(timeMapper.getClass().getName());
			logger.info(timeMapper.getTime2());
			//콘솔에서 출력되는 지 확인
		
	}

}
