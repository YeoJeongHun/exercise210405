package com.tsw.task.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsw.task.dto.Member;
import com.tsw.task.dto.Task;
import com.tsw.task.service.TaskService;
import com.tsw.task.util.Util;

@Controller
public class MpaUsrTaskController {
	
	private Util util = new Util();
	@Autowired
	private TaskService service;

	@RequestMapping("/mpaUsr/main")
	public String test(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Member LoginedMember = (Member) session.getAttribute("LoginedMember");
		if(LoginedMember==null) {
			return msgAndReplace(req,"로그인 후 이용 가능합니다.","member/LoginPage");
		}
		return "mpaUsr/main";
	}

	// http://localhost:8024/mpaUsr/task/showTasks?TaskPartId=0
	@RequestMapping("/mpaUsr/task/showTasks")
	public String showTasks(HttpServletRequest req, Integer TaskPartId,
			@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "click") String action) {
		HttpSession session = req.getSession();
		Member LoginedMember = (Member) session.getAttribute("LoginedMember");
		if(LoginedMember==null) {
			return msgAndReplace(req,"로그인 후 이용 가능합니다.","/");
		}		
		
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
		HttpSession session = req.getSession();
		Member LoginedMember = (Member) session.getAttribute("LoginedMember");
		if(LoginedMember==null) {
			return msgAndReplace(req,"로그인 후 이용 가능합니다.","/");
		}
		Task task = service.getTask(id);
		req.setAttribute("task", task);
		
		return "mpaUsr/task/showTask";
	}
	
	@RequestMapping("/mpaUsr/task/writeTask")
	public String writeTask(HttpServletRequest req, HttpServletResponse res, Integer TaskPartId) throws IOException {
		HttpSession session = req.getSession();
		Member LoginedMember = (Member) session.getAttribute("LoginedMember");
		if(LoginedMember==null) {
			return msgAndReplace(req,"로그인 후 이용 가능합니다.","/");
		}
		req.setAttribute("TaskPartId", TaskPartId);
		return "mpaUsr/task/writeTask";
	}

	@RequestMapping("/mpaUsr/task/doWriteTask")
	public String doWriteTask(HttpServletRequest req, String title, String body, Integer TaskPartId) {
		HttpSession session = req.getSession();
		Member LoginedMember = (Member) session.getAttribute("LoginedMember");
		if(LoginedMember==null) {
			return msgAndReplace(req,"로그인 후 이용 가능합니다.","/");
		}
		if(title==null) {
			return msgAndBack(req,"제목을 입력해주세요.");
		}
		if(body==null) {
			return msgAndBack(req,"내용을 입력해주세요.");
		}
		if(TaskPartId==null) {
			return msgAndBack(req,"부서를 체크해주세요.");
		}
		
		service.doWriteTask(title,body, LoginedMember.getId(), TaskPartId);
		
		return msgAndReplace(req,"정상적으로 등록되었습니다.","/");
	}
	
	@RequestMapping("/mpaUsr/task/doDeleteTask")
	public String doDeleteTask(HttpServletRequest req, int memberId, int id) {
		HttpSession session = req.getSession();
		Member LoginedMember = (Member) session.getAttribute("LoginedMember");
		if(LoginedMember==null) {
			return msgAndReplace(req,"로그인 후 이용 가능합니다.","/");
		}
		if(memberId!=LoginedMember.getId()) {
			return msgAndBack(req,"작성자만 삭제 할 수 있습니다.");
		}
		service.doDeleteTask(id);
		
		return msgAndReplace(req,"정상적으로 삭제되었습니다.","/");
	}
	
	@RequestMapping("/mpaUsr/task/ModifyTask")
	public String ModifyTask(HttpServletRequest req, int memberId, int id) {
		HttpSession session = req.getSession();
		Member LoginedMember = (Member) session.getAttribute("LoginedMember");
		if(LoginedMember==null) {
			return msgAndReplace(req,"로그인 후 이용 가능합니다.","/");
		}
		if(memberId!=LoginedMember.getId()) {
			return msgAndBack(req,"작성자만 수정 할 수 있습니다.");
		}
		Task task = service.getTask(id);
		req.setAttribute("task", task);
		
		return "mpaUsr/task/ModifyTask";
	}

	@RequestMapping("/mpaUsr/task/doModifyTask")
	public String doModifyTask(HttpServletRequest req, int id, String title, String body) {
		if(title==null) {
			return msgAndBack(req,"제목을 입력해주세요.");
		}
		if(body==null) {
			return msgAndBack(req,"내용을 입력해주세요.");
		}
		
		service.doModifyTask(id, title, body);
		
		return msgAndRelocation(req,"정상적으로 수정되었습니다.","showTask?id="+id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// 추가 함수 relocation

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
	
	private String msgAndRelocation(HttpServletRequest req, String msg, String relocation) {
		req.setAttribute("msg", msg);
		req.setAttribute("relocation", relocation);
		return "mpaUsr/common/redirect";
	}
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
