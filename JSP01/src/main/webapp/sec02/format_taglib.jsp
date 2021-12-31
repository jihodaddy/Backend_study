<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ page import="java.util.*;" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>포메팅 태그 라이브러리</title>
	</head>
	<body>
		<h3>formatNumber: 숫자 포메팅</h3>
		<c:set var="price" value="10000000" />
		
		<fmt:formatNumber type="number" value="${price }" var="priceNumber" />
		일반 숫자로 표현시 : ${priceNumber } <br>
	 	통화로 표현: <fmt:formatNumber type="currency" value="${price }" groupingUsed="true"/><br> 
		달러로 표현: <fmt:formatNumber type="currency" currencySymbol="$" value="${price }" /><br>
		<!-- 천단위 구분 표시: groupingUsed="true" 또는 "false / "true" 디폴트 -->
		퍼센트로 표현: <fmt:formatNumber type="percent" value="${price }" groupingUsed="true"/><br>
		<!-- 속성 이름은 반드시 whitespace 다음에 나타나야 합니다.: 속성명은 띄어쓰기 해야함 -->
		
		<h2>formatDate : 날짜 포메팅</h2>
		<c:set var="now" value="<%= new Date() %>" />
		<fmt:formatDate type="date" value="${now }" dateStyle="full" /><br>
		<fmt:formatDate type="date" value="${now }" dateStyle="short" /><br><br>
		
		<fmt:formatDate type="time" value="${now }" /><br>
		<fmt:formatDate type="both" value="${now }" /><br>
		<fmt:formatDate type="both" value="${now }" dateStyle="full" timeStyle="full"/><br>
		<fmt:formatDate value="${now }" pattern="yyyy-MM-dd :hh:mm:ss"/><br>
		
		한국 현재 시간:
		<fmt:formatDate value=""/>
		
	</body>
</html>