<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jspf"%>

<section class="section-1">
	<div class="bg-white shadow-md rounded container mx-auto p-8 mt-8">
		<form action="doWriteTask">
		<div class="detail">
			<div class="detail-head">
				<input type="text" name="title" value="제목을 입력해주세요."/>
			</div>
			<div>
				<input type="text" name="body" value="내용을 입력해주세요."/>
			</div>
		</div>
		<input type="hidden" name="TaskPartId" value="${TaskPartId}">
		<button type="submit">
			업무지시
		</button>
		</form>
	</div>
</section>

<%@ include file="../common/foot.jspf"%>
