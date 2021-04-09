<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jspf"%>

<section class="section-1">
	<div class="bg-white shadow-md rounded container mx-auto p-8 mt-8">
		<form action="doModifyTask">
		<div class="detail">
			<div class="detail-head">
				<div class="detail-head-title">
					<input type="text" name="title" value="${task.title}" >
				</div>
				<div class="detail-head-sub">
					<div class="detail-head-sub-left">
						<div class="detail-head-writer">
							작성자 : ${task.memberId}
						</div>
						<div class="detail-head-date_hit">
							${task.regDate}
						</div>
					</div>
					<div class="detail-reply-good">
						<div class="detail-title-reply">댓글:${task.replyCount}</div>
						<div class="detail-title-good">좋아요:${task.goodCount}</div>
					</div>
				</div>
			</div>
			<div class="detail-body">
				<input type="text" name="body" value="${task.body}" >
			</div>
			<div>
				<input type="hidden" name="memberId" value="${task.memberId}">
				<input type="hidden" name="id" value="${task.id}">
				<button type="submit">
					<수정 완료>
				</button>
			</div>
		</div>
		</form>
	</div>
</section>


<%@ include file="../common/foot.jspf"%>
