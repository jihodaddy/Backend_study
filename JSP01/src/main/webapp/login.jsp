<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>forward 액션 태그</title>
	</head>
	<body>
	
	<%
		String user_id = request.getParameter("user_id");
		//null 인 경우에 오류없이 null 출력
		if(user_id == null){ 
	%>
		<h2>로그인</h2>
	<%
		}else{
	%>	
		<h2>ID를 입력하지 않았습니다. ID를 입력해주세요</h2>
	<%
		}
	%>
	  <form name="frmLogin" method="post" action="loginResult.jsp" >
		   아이디  :<input type="text" name="user_id"><br>
	     비밀번호:<input type="password" name="user_pw" ><br>
	    <input type="submit" value="로그인">  <input type="reset" value="다시입력">
	  </form>
	</body>
</html>
