<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>c:redirect result</title>
	</head>
	<body>
		<h3> redirect 할때 전달된 param 받기</h3>
		성명: ${param.name }<br>
		이메일: ${param.email}
	</body>
</html>