package com.tsw.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tsw.task.dto.ResultData;
import com.tsw.task.service.TaskService;

@Controller
public class MpaUsrTaskController {
	
	@Autowired
	private TaskService service;
	
	@RequestMapping("/mpaUsr/task/doWrite")
	@ResponseBody
	public ResultData doWrite(String title, String body) {
		if(title==null) {
			return new ResultData("F-1","제목을 입력해주세요.");
		}
		if(body==null) {
			return new ResultData("F-2","내용을 입력해주세요.");
		}
		
		return service.doWrite(title, body);
	}
	
	@RequestMapping("/mpaUsr/task/showAll")
	@ResponseBody
	public ResultData showAll() {
		return service.showAll();
	}
	
	@RequestMapping("/mpaUsr/task/doDelete")
	@ResponseBody
	public ResultData doDelete(Integer id) {
		if(id==null) {
			return new ResultData("F-1","id를 입력해주세요.");
		}
		
		return service.doDelete(id);
	}
	
	@RequestMapping("/mpaUsr/task/doModify")
	@ResponseBody
	public ResultData doModify(Integer id, String title, String body) {
		if(id==null) {
			return new ResultData("F-1","id를 입력해주세요.");
		}
		if(title==null) {
			return new ResultData("F-2","제목을 입력해주세요.");
		}
		if(body==null) {
			return new ResultData("F-3","내용을 입력해주세요.");
		}
		
		return service.doModify(id, title, body);
	}
	
	@RequestMapping("/mpaUsr/task/showTask")
	@ResponseBody
	public ResultData showTask(Integer id) {
		if(id==null) {
			return new ResultData("F-1","id를 입력해주세요.");
		}
		return service.showTask(id);
	}
	
	
}
