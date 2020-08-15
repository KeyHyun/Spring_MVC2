package com.example.spring01.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring01.model.dto.MemberDTO;
import com.example.spring01.model.dto.MovieDTO;
import com.example.spring01.service.MemberService;

@Controller
public class MovieController {
	private static final Logger logger=
			LoggerFactory.getLogger(MemberController.class);
	@Inject
	MemberService memberService;
	
	@RequestMapping("movie/copy.do")
	public String moviecopy () {
		logger.info("¼º°ø");
		return "movie/copy";
	}
	
	//@RequestMapping("movie/insert.do")
	//public String insert (@ModelAttribute MovieDTO dto) {
		
//	}
	
}
