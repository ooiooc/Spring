package com.myspring.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Trans2Mapper {

	@Insert("insert into transaction2 values (#{data})")
	public int insertCol1(String data);
	
}
