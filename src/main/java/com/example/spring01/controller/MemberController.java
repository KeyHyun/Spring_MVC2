package com.example.spring01.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.dto.MemberDTO;
import com.example.spring01.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger=
			LoggerFactory.getLogger(MemberController.class);
	@Inject
	MemberService memberService;
	
//	@RequestMapping("member/list.do")
//	public String memberList(Model model) {
//		List<MemberDTO> list=memberService.memberList();
//		model.addAttribute("list",list);
//		return "member/member_list";
//	}
	
	//ȸ�� ������ ���� write page �̵� 
	@RequestMapping("member/write.do")
	public String write() {
		return "member/write";
	}
	//DB�� ȸ������ ���� ���� ��, ���� �������� �̵� (�ð� ������ ȸ������ �Ϸ� â + ����ȭ�� �̵� â)
	@RequestMapping("member/insert.do")
	public String insert(@ModelAttribute MemberDTO dto) {
		memberService.insertMember(dto);
		return "member/home";
	}
	
	//�α����� ���� login page�� �̵�
	@RequestMapping("member/login.do")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("member/login_check.do")
	public ModelAndView login_check(@ModelAttribute MemberDTO dto, HttpSession session) {
		String name=memberService.loginCheck(dto, session);
		logger.info("name:"+name);
		ModelAndView mav=new ModelAndView();
		if(name != null) {
			mav.setViewName("member/home");
		}
		else {
			mav.setViewName("member/login");
			mav.addObject("message","error");
		}
		return mav;
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		
		memberService.logout(session);
		mav.setViewName("member/home");
		mav.addObject("message", "logout");
		return mav;
	}
	
	@RequestMapping("member/view.do")
	public String view(@RequestParam String userid, Model model) {
		model.addAttribute("dto",memberService.viewMember(userid));
		return "member/view";
	}
	
//	@RequestMapping("member/update.do")
//	public String update(@ModelAttribute MemberDTO dto, Model model) {
//		boolean result=memberService.checkPw(
//				dto.getUserid(), dto.getPasswd());
//		logger.info("��й�ȣ Ȯ��:" + result);
//		
//		if(result) {
//			memberService.updateMember(dto);
//			return "redirect:/member/list.do";
//		}
//		else {
//			MemberDTO dto2=memberService.viewMember(dto.getUserid());
//			model.addAttribute("dto",dto);
//			model.addAttribute("message", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
//			return "member/view";
//		}	
//	}
	

//	
//	@RequestMapping("member/delete.do")
//	public String delete(@RequestParam String userid, @RequestParam String passwd, Model model) {
//		boolean result=memberService.checkPw(userid, passwd);
//		logger.info("��й�ȣ Ȯ��:" + result);
//		
//		if(result) {
//			memberService.deleteMember(userid);
//			return "redirect:/member/list.do";
//		}
//		else {
//			model.addAttribute("message", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
//			return "member/view";
//		}	
//	}
}
