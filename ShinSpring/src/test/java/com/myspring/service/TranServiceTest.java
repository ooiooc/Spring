package com.myspring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TranServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TranService service;
	
	@Test
	public void testTran() {
		String str="원자성: dsfd 하나의 트랜잭션은 모두 하나의 단위로 처리되어야 합니다. "
				+ "좀 더 쉽게 말하자면 어떤 트랜잭션이 A와 B로 구성된다면 항상 A,B의 처리결과는 동일한 결과여야 합니다."
				+ " 즉~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
		service.addData(str);
		
	}
}
