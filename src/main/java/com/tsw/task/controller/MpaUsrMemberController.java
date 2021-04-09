package com.tsw.task.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tsw.task.dto.Member;
import com.tsw.task.service.MemberService;

@Controller
public class MpaUsrMemberController {
	public Member LoginedMember;

	@Autowired
	private MemberService memberservice;
	
	@RequestMapping("/")
	public String showMainRoot(HttpServletRequest req) {
		return "redirect:/mpaUsr/main";
	}
	
	@RequestMapping("/mpaUsr/member/LoginPage")
	public String LoginPage(HttpServletRequest req) {
		if(LoginedMember==null) {
			return "mpaUsr/member/LoginPage";
		}
		return "mpaUsr/main";
	}
	
	@RequestMapping("/mpaUsr/member/doLogin")
	public String doLogin(HttpServletRequest req, String LoginId, String LoginPw) {
		HttpSession session = req.getSession();
		LoginedMember = memberservice.doLogin(LoginId, LoginPw);
		
		if(LoginedMember==null) {
			req.setAttribute("LoginError", "로그인 정보가 일치하지 않습니다.");
			return "redirect:/mpaUsr/member/LoginPage";
		}
		
		session.setAttribute("LoginedMember", LoginedMember);
//		req.setAttribute("LoginedMember", LoginedMember);
		
		return msgAndReplace(req, "로그인 성공! "
		+LoginedMember.getName()+"님 반갑습니다.","/");
	}
	
	@RequestMapping("/mpaUsr/member/doLogout")
	public String doLogout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		LoginedMember=null;
		return "redirect:/mpaUsr/member/LoginPage";
	}
	
	
	
	
	
	
	
	
	
	
	
	//추가 함수
	private String msgAndBack(HttpServletRequest req, String msg) {
		req.setAttribute("msg", msg);
		req.setAttribute("historyBack", true);
		return "mpaUsr/common/redirect";
	}

	private String msgAndReplace(HttpServletRequest req, String msg, String replaceUrl) {
		req.setAttribute("msg", msg);
		req.setAttribute("replaceUrl", replaceUrl);
		return "mpaUsr/common/redirect";
	}
}
