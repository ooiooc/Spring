package com.myspring.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	//현재 시간과 날짜 조회하는 sql
	@Select("select sysdate()")
	
	public String getTime(); //추상메소드
	
	public String getTime2(); //추상메소드
	
}
