<%@page import="com.love.baseball.db.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB 연결 테스트 파일</title>
</head>
<body>
	<%
		Connection conn = DBConn.getConnection();
	%>
	<%
		if (conn != null) {
	%>
	<h1>DB 연결 성공!!</h1>
	<%
		} else {
	%>
	<h1>DB 연결 실패ㅠㅜ</h1>
	<%
		}
	%>
</body>
</html>