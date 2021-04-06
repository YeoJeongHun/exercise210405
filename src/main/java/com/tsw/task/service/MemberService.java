package com.tsw.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsw.task.dao.MemberDao;
import com.tsw.task.dto.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberdao;

	public List<Member> getAllMember() {
		return memberdao.getAllMember();
	}
	
}
