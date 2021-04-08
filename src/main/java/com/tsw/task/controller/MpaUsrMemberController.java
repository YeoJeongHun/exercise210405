package com.tsw.task.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tsw.task.dto.Member;
import com.tsw.task.service.MemberService;

@Controller
@SessionAttributes("LoginedMember")
public class MpaUsrMemberController {
	public Member LoginedMember;
	HttpSession session;

	@Autowired
	private MemberService memberservice;
	
	@RequestMapping("/")
	public String showMainRoot(HttpServletRequest req) {
		return "redirect:/mpaUsr/main";
	}
	
	@RequestMapping("/mpaUsr/member/LoginPage")
	public String LoginPage(HttpServletRequest req) {
		if(isMemberNull()) {
			return "mpaUsr/member/LoginPage";
		}
		return "mpaUsr/main";
	}
	
	@RequestMapping("/mpaUsr/member/doLogin")
	public String doLogin(HttpServletRequest req, String LoginId, String LoginPw) {
		session = req.getSession();
		LoginedMember = memberservice.doLogin(LoginId, LoginPw);
		
		if(LoginedMember==null) {
			req.setAttribute("LoginError", "로그인 정보가 일치하지 않습니다.");
			return "redirect:/mpaUsr/member/LoginPage";
		}
		session.setAttribute("LoginedMember", LoginedMember);
		req.setAttribute("LoginedMember", LoginedMember);
		
		return "redirect:/mpaUsr/main";
	}
	
	@RequestMapping("/mpaUsr/member/doLogout")
	public String doLogout(HttpServletRequest req) {
		req.setAttribute("session", null);
		LoginedMember=null;
		return "mpaUsr/member/LoginPage";
	}
	
	
	
	
	
	//로그인 확인
	public boolean isMemberNull() {
		if(LoginedMember==null) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	//추가 함수
	private String msgAndBack(HttpServletRequest req, String msg) {
		req.setAttribute("msg", msg);
		req.setAttribute("historyBack", true);
		return "mpaUsr/redirect";
	}

	private String msgAndReplace(HttpServletRequest req, String msg, String replaceUrl) {
		req.setAttribute("msg", msg);
		req.setAttribute("replaceUrl", replaceUrl);
		return "common/redirect";
	}
}
