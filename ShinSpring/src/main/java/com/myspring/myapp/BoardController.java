package com.myspring.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.domain.BoardVO;
import com.myspring.domain.Criteria;
import com.myspring.domain.PageDTO;
import com.myspring.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	
@Autowired
 	private BoardService service;

 	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

//글쓰기를 하기 위한 화면 폼
@RequestMapping(value="register", method=RequestMethod.GET)
	public void registerGET() throws Exception{
		logger.info("register get........");
		
	}

//실제 글쓰기가 이루어지는 공간
@RequestMapping(value="register", method = RequestMethod.POST)
	public String registerPost(BoardVO board, Model model) throws Exception{
		logger.info("register post.......");
		logger.info("BoardVO에 저장되어 있는 값 :" + board);
		
		service.create(board); //insert SQL
		model.addAttribute("result", "success");
		
		return "redirect:/board/list";

	}

@RequestMapping(value = "list", method = RequestMethod.GET)
	public void listGet(Model model, Criteria cri) throws Exception{ //모델 안에 넣어주기 위해서(select된 내용을 화면에 보여주기) 위에 model 선언
		logger.info("list.get......."+cri);
		model.addAttribute("list", service.listPage(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotalCount(cri)));
//		model.addAttribute("list", service.listAll()); 
		//select된 결과를 list 변수 안에 넣어주기
		//변수를 list.jsp로 들고가서 list에서 select된 내용 view단으로 보여주기
		//list 배열	
	}

@RequestMapping(value = "read", method = RequestMethod.GET)
	public void readGet(BoardVO board, @ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		logger.info("read.get........" + board);
		logger.info("read.get........" + cri);
		//출력값 : read.get........BoardVO [bno=7, title=null, content=null, writer=null, regdate=null, viewcnt=0] 
		model.addAttribute("read", service.read(board));
		
	}
//수정화면 이동을 위해 이동
@RequestMapping(value="modify", method = RequestMethod.GET) //수정은 화면이 필요하기 때문에 GET
	public void modifyGet(BoardVO board, @ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		logger.info("modify.get..........");
		model.addAttribute("modify", service.read(board));
		
	}

//실제 수정이 이루어지는 곳
@RequestMapping(value="modify", method = RequestMethod.POST)
	public String modifyPost(BoardVO board, Criteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("modify post.........." + board);
		service.update(board);
		//수정했을때 아래의 내용을 같이 보낸다
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS!");
		return "redirect:/board/list";
	}

@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String removePost(BoardVO board, Criteria cri, RedirectAttributes rttr) throws Exception{
		logger.info("remove post");
		service.delete(board);	
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addFlashAttribute("msg", "DSUCCESS!");
		return "redirect:/board/list";
	}	

}

