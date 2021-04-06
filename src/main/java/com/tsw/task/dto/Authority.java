package com.tsw.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Authority {
	private int id;
	private int memberId;
	private boolean TMTaskStatus;
	private boolean SalesTaskStatus;
	private boolean SurportTaskStatus;
	private boolean TechTaskStatus;
	private boolean StockStatus;
	private boolean TMPerformanceStatus;
	private boolean SalesPerformanceStatus;
	private boolean AuthorityStatus;
	private boolean MemberManagementStatus;
}
