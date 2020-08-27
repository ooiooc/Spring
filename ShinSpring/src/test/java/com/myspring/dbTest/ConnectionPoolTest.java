package com.myspring.dbTest;

import static org.junit.Assert.fail;

import java.sql.Connection;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

	public class ConnectionPoolTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataSource dataSource; //DataSource dataSource = new DataSource();
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	//@Autowired란
	//생성자나 세터 등을 사용하여 의존성 주입을 하려고 할 때, 해당 빈을 찾아서 주입해주는 annotation이다.
	
	@Test //ConnectionPool 테스트
	public void testConnection() {
		try(Connection con = dataSource.getConnection()) {
			logger.info("커넥션 풀 연결 = " + con);
		
		} catch (Exception e) {
			fail(e.getMessage());
		
		}
	}
	
	@Test
	public void testMyBatis() {
		
		try(SqlSession session = sqlSessionFactory.openSession(); 
			Connection con = dataSource.getConnection()){
		
			logger.info("mybatis 연결 = " + session);
			logger.info("커넥션 풀 연결 = " + con);
			
		} catch (Exception e) {
			fail(e.getMessage());
		
		}
	}
		
}
