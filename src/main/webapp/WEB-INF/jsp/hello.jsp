<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="css/app.css" />" rel="stylesheet" type="text/css">
<title>Hello World!</title>
</head>
<body class="security-app">
	<div class="details">
		<h2>Spring Security - JDBC Authentication</h2>
		<a href="https://github.com/trifonnt/example-spring-security-web/archive/master.zip" class="button red small">Download</a>
	</div>

	<div class="lc-block">
		<h1>
			Hello <b><c:out value="${pageContext.request.remoteUser}"></c:out></b>
		</h1>
		<form action="/logout" method="post">
			<input type="submit" class="button red big" value="Sign Out" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>