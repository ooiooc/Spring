package com.myspring.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Trans1Mapper {
	
	@Insert("insert into transaction1 values (#{data})")
	public int insertCol1(String data);
	
}
