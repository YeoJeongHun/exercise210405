package com.tsw.task.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tsw.task.dto.ResultData;
import com.tsw.task.dto.Task;
import com.tsw.task.service.TaskService;
import com.tsw.task.util.Util;

@Controller
public class MpaUsrTaskController {

	private Util util = new Util();
	@Autowired
	private TaskService service;

	@RequestMapping("/")
	public String showMainRoot() {
		return "redirect:/mpaUsr/main";
	}

	@RequestMapping("/mpaUsr/main")
	public String test(HttpServletRequest req) {
		req.setAttribute("pageTitle", "메인페이지");
		return "mpaUsr/main";
	}

	// http://localhost:8024/mpaUsr/task/showTasks?TaskPartId=0
	@RequestMapping("/mpaUsr/task/showTasks")
	public String showTasks(HttpServletRequest req, Integer TaskPartId,
			@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "click") String action) {
		int totalItemsCount = service.getTaskAllCount(TaskPartId);
		int itemsCountInAPage = 10;

		List<Task> tasks = service.getTasksByPart(TaskPartId, itemsCountInAPage, page);
		req.setAttribute("tasks", tasks);
		Map<String, Object> map = util.getPage(page, totalItemsCount, action);
		req.setAttribute("startPage", map.get("startPage"));
		req.setAttribute("finishPage", map.get("finishPage"));
		req.setAttribute("page", map.get("page"));
		//아래는 테스트용
		req.setAttribute("TaskPartId", TaskPartId);
		req.setAttribute("action", action);
		req.setAttribute("totalItemsCount", totalItemsCount);

		return "mpaUsr/task/showTasks";
	}
	
	@RequestMapping("/mpaUsr/task/showTask")
	public String showTasks(HttpServletRequest req, Integer id) {
		if(id==null) {
			//콜백함수
		}
		Task task = service.getTask(id);
		req.setAttribute("task", task);
		
		return "mpaUsr/task/showTask";
	}


	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// 추가 함수

//	private String msgAndBack(HttpServletRequest req, String msg) {
//		req.setAttribute("msg", msg);
//		req.setAttribute("historyBack", true);
//		return "common/redirect";
//	}
//
//	private String msgAndReplace(HttpServletRequest req, String msg, String replaceUrl) {
//		req.setAttribute("msg", msg);
//		req.setAttribute("replaceUrl", replaceUrl);
//		return "common/redirect";
//	}
//
//	@RequestMapping("/mpaUsr/task/getTask")
//	public String getTask(HttpServletRequest req, Integer taskId) {
//		List<Task> tasks = service.getTask(taskId);
//		req.setAttribute("tasks", tasks);
//		return "mpaUsr/task/taskAll";
//	}
//
//	@RequestMapping("/mpaUsr/task/doWrite")
//	@ResponseBody
//	public ResultData doWrite(String title, String body) {
//		if (title == null) {
//			return new ResultData("F-1", "제목을 입력해주세요.");
//		}
//		if (body == null) {
//			return new ResultData("F-2", "내용을 입력해주세요.");
//		}
//
//		return service.doWrite(title, body);
//	}
//
////	@RequestMapping("/mpaUsr/task/showAll")
////	@ResponseBody
////	public ResultData showAll() {
////		return service.showAll();
////	}
//
//	@RequestMapping("/mpaUsr/task/doDelete")
//	@ResponseBody
//	public ResultData doDelete(Integer id) {
//		if (id == null) {
//			return new ResultData("F-1", "id를 입력해주세요.");
//		}
//
//		return service.doDelete(id);
//	}
//
//	@RequestMapping("/mpaUsr/task/doModify")
//	@ResponseBody
//	public ResultData doModify(Integer id, String title, String body) {
//		if (id == null) {
//			return new ResultData("F-1", "id를 입력해주세요.");
//		}
//		if (title == null) {
//			return new ResultData("F-2", "제목을 입력해주세요.");
//		}
//		if (body == null) {
//			return new ResultData("F-3", "내용을 입력해주세요.");
//		}
//
//		return service.doModify(id, title, body);
//	}

}
