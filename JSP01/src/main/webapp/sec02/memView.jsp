<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*;" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>memView</title>
	</head>
	<body>
		<h3>회원 정보 조회</h3>
		<table border="1">
			<tr><th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입일</th></tr>
			<c:forEach var='mem' items="${memList }">
			<tr>
				<td>${mem.id}</td>
				<td>${mem.pwd}</td>
				<td>${mem.name}</td>
				<td>${mem.email}</td>
				<td>${mem.joinData}</td>
				<td><a href='/Servlet01/memberDelete?id="id"'>삭제</a></td>
			</tr>
		</c:forEach>
		</table>
	</body>
</html>