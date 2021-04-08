package com.tsw.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
	private int id;
	private String regDate;
	private String updateDate;
	private int taskPartId;
	private int memberId;
	private String title;
	private String body;
	private boolean blindStatus;
	private String blindDate;
	private boolean delStatus;
	private String delDate;
	private int reciverCount;
	private int hitCount;
	private int replyCount;
	private int goodCount;
}
