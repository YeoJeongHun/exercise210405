package com.tsw.task.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tsw.task.dto.Member;

@Mapper
public interface MemberDao {

	List<Member> getAllMember();

}
