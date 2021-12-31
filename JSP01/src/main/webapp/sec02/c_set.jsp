<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 변수 설정 -->
<c:set var="id" value="hong" scope="page" />
<c:set var="pwd" value="1234" scope="page" />
<c:set var="name" value="${'홍길동'}" scope="page" />
<c:set var="age" value="${20 }" scope="page" />
<!-- value 값으로 EL 사용해도 됨 -->

<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!-- 복잡한 속성명을 짧게 줄여서 사용 -->


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSPL c:set 태그 </title>
	</head>
	<body>
		${id }<br>
		${pwd }<br>
		${name }<br>
		${age }<br>
		
		<a href="${contextPath}/sec01/login.jsp">로그인</a>
	</body>
</html>