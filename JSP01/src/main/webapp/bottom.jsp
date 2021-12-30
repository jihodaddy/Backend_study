<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>bottom.jsp</title>
	</head>
	<body>
	<font color= 'red' size='3pt' >
		bottom.jsp입니다. <p/>
  		작성자<b><%-- <%= name %> --%></b>입니다. 
		<!-- name: 선언되지 않은 변수이기 때문에 오류발생 -->
		<!-- 다른 페이지에 포함되어서 선언되어 있는 name변수 사용시 오류 없음 -->
	</body>
</html>