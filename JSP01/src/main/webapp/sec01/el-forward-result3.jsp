<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>빈 객체 ArrayList 담아서 바인딩</title>
	</head>
	<body>
		<!-- 바인딩된 ArrayList에서 인덱스 사용하여 데이터 출력 -->
		<table border="1">
			<tr><th>학번</th><th>성명</th><th>전화</th><th>주소</th><th>학년</th></tr>
			<tr><td>${stdList[0].stdNo }</td>
					<td>${stdList[0].stdName }</td>
					<td>${stdList[0].stdPhone }</td>
					<td>${stdList[0].stdAddress }</td>
					<td>${stdList[0].stdYear}</td></tr>
			<tr><td>${stdList[1].stdNo }</td>
					<td>${stdList[1].stdName }</td>
					<td>${stdList[1].stdPhone }</td>
					<td>${stdList[1].stdAddress }</td>
					<td>${stdList[1].stdYear}</td></tr>
			<tr><td>${stdList[2].stdNo }</td>
					<td>${stdList[2].stdName }</td>
					<td>${stdList[2].stdPhone }</td>
					<td>${stdList[2].stdAddress }</td>
					<td>${stdList[2].stdYear}</td></tr>
		</table>
		<!-- JSTL 배운후 for문 (for each)사용해서 출력 -->
		<h3>c:forEach 사용</h3>
		<%-- <c:set var="stdlist" value="${stdList}" /> --%>
		<table border="1">
		<c:forEach var='data' items="${stdList }">
			<tr><th>학번</th><th>성명</th><th>전화</th><th>주소</th><th>학년</th></tr>
			<tr>
				<td> ${data.stdNo}</td>
				<td>${data.stdName}</td>
				<td>${data.stdPhone}</td>
				<td>${data.stdAddress}</td>
				<td>${data.stdYear}</td>
			</tr>
		</c:forEach>
		</table> 
	</body>
</html>