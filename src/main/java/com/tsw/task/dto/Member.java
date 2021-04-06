package com.tsw.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Member {
	private int id;
	private String loginId;
	private String loginPw;
	private String name;
	private int department;
	private String departmentName;
	private String workStartDate;
	private String workFinishDate;
	private String birthDate;
	private boolean gender;
	private String rank;
}
