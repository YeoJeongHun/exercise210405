package com.tsw.task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsw.task.dao.TaskDao;
import com.tsw.task.dto.ResultData;
import com.tsw.task.dto.Task;

@Service
public class TaskService {

	@Autowired
	private TaskDao taskdao;

	public ResultData doWrite(String title, String body) {
		taskdao.doWrite(title, body);
		return new ResultData("S-1", "업무가 정상적으로 등록되었습니다.");
	}

	public ResultData showAll() {
		List<Task> tasks = new ArrayList<>();

		int countTask = taskdao.getNumTask();
		
		if(countTask==0) {
			return new ResultData("S-1", "업무 기록이 없습니다.");
		}
		
		for (int i = 1; i <= countTask; i++) {
			Task task = taskdao.getTask(i);
			if (task.isDelStatus()) {
				continue;
			}
			tasks.add(task);
		}
		
		return new ResultData("S-2", "모든 업무 기록을 표시합니다.", "모든 업무 기록", tasks);
	}

	public ResultData doDelete(int id) {
		taskdao.doDelete(id);
		
		if(taskdao.isDelete(id)) {
			return new ResultData("S-1", "정상적으로 삭제되었습니다.");
		}
		return new ResultData("F-2", "삭제에 실패했습니다.");
	}

	public ResultData doModify(Integer id, String title, String body) {
		taskdao.doModify(id, title, body);
		Task task = taskdao.getTask(id);
		if(task.getTitle().equals(title)&&task.getBody().equals(body)) {
			return new ResultData("S-1", "정상적으로 수정되었습니다.","result",task);
		}
		return null;
	}

	public ResultData showTask(Integer id) {
		Task task = taskdao.getTask(id);
		if(task==null) {
			return new ResultData("F-1", "해당 업무가 존재하지 않습니다.");
		}
		if(task.isDelStatus()) {
			return new ResultData("F-2", "해당 업무가 삭제되었습니다.");
		}
		return new ResultData("S-1", "해당 업무를 표시합니다.","result",task);
	}

}
