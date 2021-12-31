<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>빈 객체 바인딩</title>
	</head>
	<body>
		<h3>학생 정보 출력(빈 객체 사용)</h3>
			학번: ${student.stdNo}<br>
			성명: ${student.stdName }<br>
			전화번호: ${student.stdPhone }<br>
			주소: ${student.stdAddress }<br>
			학년: ${student.stdYear }<br>
	</body>
</html>