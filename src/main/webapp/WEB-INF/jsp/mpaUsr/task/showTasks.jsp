<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jspf"%>

<div class="section section-article-list">
	<div class="container mx-auto">
		<div class="articles">
			<table>
				<tbody>				
					<tr>
						<td colspan="4">
							<div class="TaskTitle">진행중 업무</div>
						</td>
					</tr>
					<tr>
						<td style="width:10%;">번호</td>
						<td style="width:55%;">제목</td>
						<td style="width:25%;">작성일</td>
						<td style="width:15%;">작성자</td>
					</tr>
					<c:forEach items="${tasks}" var="task">
						<tr>
							<td>${task.id}</td>
							<td>${task.title}</td>
							<td>${task.regDate}</td>
							<td>${task.memberId}</td>
						</tr>
					</c:forEach>					
					<tr>
						<td colspan="4">
							<div class="TaskTitle">완료된 업무</div>
						</td>
					</tr>
					<tr>
						<td style="width:10%;">번호</td>
						<td style="width:55%;">제목</td>
						<td style="width:25%;">작성일</td>
						<td style="width:15%;">작성자</td>
					</tr>
					<c:forEach items="${tasks}" var="task">
						<tr>
							<td>${task.id}</td>
							<td>${task.title}</td>
							<td>${task.regDate}</td>
							<td>${task.memberId}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>




<%@ include file="../common/foot.jspf"%>
