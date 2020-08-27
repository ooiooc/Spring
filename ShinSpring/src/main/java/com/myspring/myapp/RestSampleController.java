package com.myspring.myapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.domain.SampleVO;

@RestController
@RequestMapping("sample")
public class RestSampleController {

	@RequestMapping("hello")
	public String sayHello() {
		return "Hello World";
		//RestController는 .jsp 존재하지 않으므로 뒤에 .jsp 안 붙이고 hello world 문자열 처리
	}
	
	@RequestMapping("sendVO")
	public SampleVO sendVo() {
		SampleVO vo = new SampleVO();
		vo.setFirstName("조이");
		vo.setLastName("킹");
		vo.setMno(123);
		return vo;
	}
	
	@RequestMapping("/sendList")
	public List<SampleVO> sendList(){
		
		List<SampleVO> list = new ArrayList<>();
		for(int i=0; i<10; i++){
			SampleVO vo = new SampleVO();
			vo.setFirstName("조이");
			vo.setLastName("킹");
			vo.setMno(i);
			list.add(vo);
		}
		return list;	
	}	
	
	//HashMap<Key값, Value값> 사용
	@RequestMapping("/sendMap")
	public Map<Integer,SampleVO> sendMap(){
		
		Map<Integer,SampleVO> map = new HashMap<>();		
		for(int i=0; i<10; i++){
			SampleVO vo = new SampleVO();
			vo.setFirstName("조이");
			vo.setLastName("킹");
			vo.setMno(i);
			map.put(i, vo);
		}
		return map;	
	}	

}
