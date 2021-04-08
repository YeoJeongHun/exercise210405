<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jspf"%>
id : ${task.id}
<br/>
title : ${task.title}
<br/>
body : ${task.body}
<br/>
regDate : ${task.regDate}
<br/>
updateDate : ${task.updateDate}
<br/>
taskPartId : ${task.taskPartId}
<br/>
memberId : ${task.memberId}
<br/>
<%@ include file="../common/foot.jspf"%>
