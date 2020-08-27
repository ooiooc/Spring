package com.myspring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myspring.mapper.Trans1Mapper;
import com.myspring.mapper.Trans2Mapper;

@Service
public class TranServiceImpl implements TranService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Trans1Mapper tmapper1;
	
	@Autowired
	private Trans2Mapper tmapper2;
	
	@Override
	public void addData(String value) {
		logger.info("transaction 적용하기 전");
		
		tmapper1.insertCol1(value);
		
		tmapper2.insertCol1(value);
		
	}


	
}
