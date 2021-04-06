package com.tsw.task.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsw.task.dto.Member;
import com.tsw.task.service.MemberService;

@Controller
public class MpaUsrMemberController {
	@Autowired
	private MemberService memberservice;
	
	@RequestMapping("/mpaUsr/member/test")
	public String test(HttpServletRequest req) {
		List<Member> members = memberservice.getAllMember();
		req.setAttribute("members", members);
		
		return "mpaUsr/member/test";
	}
}
