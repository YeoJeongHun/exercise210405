<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle"
	value="<span><i class='fas fa-home'></i></span> <span>HOME</span>" />

<%@ include file="../common/head.jspf"%>

zzzzzzzzzzzzzzzzzzzzzzz
<table>
	<tbody>
		<tr>
			<td>새로운 업무</td>
			<td>진행중 업무</td>
		</tr>
		<tr>
			<td>이달의 실적</td>
			<td>오늘 상담</td>
		</tr>
		<tr>
			<td colspan="2">기타사항</td>
		</tr>
	</tbody>
</table>


</br>
</br>
</br>
</br>
<div class="section section-article-list">
	<div class="container mx-auto">
		<div class="articles">
			<table>
				<tbody>
					<tr>
						<c:forEach items="${tasks}" var="task">
							<div>
								${task}
							</div>
							<hr />
						</c:forEach>
					</tr>
					</br>
					</br>
					<tr>
						<c:forEach items="${tasks}" var="task">
							<div>
								${task}
							</div>
							<hr />
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>




<%@ include file="../common/foot.jspf"%>
