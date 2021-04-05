package com.tsw.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Recivers {
	private int id;
	private int memberId;
	private String checkDate;
	private int taskId;
}
