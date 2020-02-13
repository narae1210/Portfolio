<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.sql.*"%>
<%@ page import="java.util.*"%>

<%
request.setCharacterEncoding("utf-8");
String id = (String)session.getAttribute("idinputLog");
String qid2 = request.getParameter("qid"); 
System.out.println("id: "+id);
System.out.println("postid: "+qid2);
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
	<jsp:useBean id="dao" class="Dao.Board_Dao">
		<%	int delete = dao.Delete(id, qid2);
			//System.out.println(delete);	
			%>
		
		<script>
		function alert() {
		if (edit > 0){
			alert("삭제가 완료되었습니다.");
			}
			else {
			alert("삭제할 수 없습니다.");
			}
		}
		</script>
		
		<%	response.sendRedirect("BoardHome2.jsp");
		%>

	</jsp:useBean>
</body>
</html>