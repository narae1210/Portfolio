<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.sql.*"%>
<%@ page import="java.util.*"%>

<%
request.setCharacterEncoding("utf-8");
String id = (String)session.getAttribute("idinputLog");
String posttitle = request.getParameter("title");
String qid2 = request.getParameter("qid");
String postcontents = request.getParameter("contents");
String category = request.getParameter("category");
System.out.println("qid: "+qid2);
System.out.println("postcontents: "+postcontents);
System.out.println("posttitle: "+posttitle);
System.out.println("category: "+category);
%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dao" class="Dao.Board_Dao"/> <!-- Board_DAO 파일의 메소드를 불러오기 위한 jsp명령어 -->
		<% int edit = dao.Update(posttitle, postcontents, id, qid2);
	
		if (edit > 0){ 
		      out.println("<script>alert('d')</script>");
		 	  
		 }
		else {
		out.println("<script>alert('dfsdf')</script>");
	
		}
				
		response.sendRedirect("BoardHome2.jsp"); 

%>
</body>
</html>