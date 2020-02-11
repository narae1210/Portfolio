<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.HashMap"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/Join_Js.js"></script>
</head>
<body>
	<jsp:useBean id="dao" class="Dao.Db_Dao">
	<p>
		<%
		//dao.Db_Dao(); 쓰지 않는 파일일 가능성 높음 ***************************************************************************************************************
		//dao.DbConnect();
		
		String id = request.getParameter("idinputLog");

		int n = dao.Jungbok(id);
		int n2 = id.length();
		
		
		if(n == 1) {
			out.println("이미 있는 ID입니다.");
		}
		else {
			out.println("사용 가능한 ID입니다.");
		}
		
				

		%>
</p>
	</jsp:useBean>
</body>
</html>