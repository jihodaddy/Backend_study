<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	Date date = new Date();
%>

	<font color= 'blue' size='3' >
		top.jsp입니다. <p/>
		<%= date.toLocaleString() %>
