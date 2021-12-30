<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>type ConversionOk</title>
	</head>
	<body>
		<%
			int row = Integer.parseInt(request.getParameter("row"));
			int col = Integer.parseInt(request.getParameter("col"));
		
		%>
		
		사각형의 넓이 : <%= row * col %>
		
	</body>
</html>