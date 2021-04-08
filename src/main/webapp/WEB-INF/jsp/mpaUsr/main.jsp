<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle"
	value="<span><i class='fas fa-home'></i></span> <span>HOME</span>" />

<%@ include file="common/head.jspf"%>

	상태 : ${LoginError}
	로그인 상태 : ${LoginedMember}
	테스트 : ${test}
	<br/>
	asdf:${sessionScope.LoginedMember.id }

    <table class="table_main">
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
          <td colspan="2">이달의 실적</td>
        </tr>
      </tbody>
    </table>





<%@ include file="common/foot.jspf"%>
