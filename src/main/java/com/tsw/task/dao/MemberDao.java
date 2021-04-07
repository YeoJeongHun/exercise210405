package com.tsw.task.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tsw.task.dto.Member;

@Mapper
public interface MemberDao {

	public Member doLogin(@Param("loginId") String loginId, @Param("loginPw") String loginPw);

}
