package com.tsw.task.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tsw.task.dto.Task;

@Mapper
public interface TaskDao {

	void doWrite(@Param("title") String title, @Param("body") String body);

	void doDelete(@Param("id") int id);

	void doModify(@Param("id") Integer id, @Param("title") String title, @Param("body") String body);
	
	int getNumTask();

	int getNumTaskByPart(@Param("taskPartIdint") int taskPartId);

	List<Task> getListTaskAll(@Param("limitFrom") int limitFrom, @Param("itemsCountInAPage") int itemsCountInAPage);

	List<Task> getListTaskById(@Param("taskPartId") int taskPartId, @Param("limitFrom") int limitFrom, @Param("itemsCountInAPage") int itemsCountInAPage);

	int getTaskAllCount();
	
	int getTaskCount(@Param("taskPartId") int taskPartId);

	Task getTask(@Param("id") int id);
	
}



