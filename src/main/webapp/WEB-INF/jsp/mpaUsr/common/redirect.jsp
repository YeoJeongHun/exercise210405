<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
const alertMsg = '${msg}'.trim();
if ( alertMsg ) {
	alert(alertMsg);
}
const historyBack = '${historyBack}' == 'true';
if ( historyBack ) {
	history.back();
}
const replaceUrl = '${replaceUrl}'.trim();
if ( replaceUrl ) {
	location.replace(replaceUrl);
}
const relocation = '${relocation}'.trim();
if ( relocation ) {
	location.href='${relocation}';
}
</script>