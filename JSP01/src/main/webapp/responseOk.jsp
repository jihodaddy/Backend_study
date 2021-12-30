<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>responseOk.jsp</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("utf-8");
			String answer = request.getParameter("answer");
			
			//"서울" 이면 response.sendRedirect("pass.jsp");
			if(answer.equals("서울")){
					response.sendRedirect("pass.jsp");
			}else{
					response.sendRedirect("fail.jsp");
			}
			
			%>
			
	
	</body>
</html>