<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@ page import="com.green.study.dto.Board_Dto" %>
<%@ page import="java.util.ArrayList" %>

<% String id = (String)session.getAttribute("idinputLog");%>
<% String postid = request.getParameter("postid");%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="Css/Sec.css">
<link rel="stylesheet" type="text/css" href="Css/Header.css">
<link rel="stylesheet" type="text/css" href="Css/Article.css">
<link rel="stylesheet" type="text/css" href="Css/Footer.css">
<link rel="stylesheet" type="text/css" href="Css/Nav.css">


<!--Using the hamburger menu display code-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="jquery.slides.min.js"></script>
<script type="text/javascript" src="js/superslide.2.1.js"></script>

<title>질문수정</title>
</head>

<body>
		<jsp:include page ="Header2.jsp"></jsp:include>
	<br>
	<nav>
		<div class="menubar" style="line-height: 35px">
			<ul class="underMenu">
				<li><a class="underMenuFont"
					onclick="location.href='BoardHome2.jsp'">질문홈</a></li>

				<li><a class="underMenuFont"
					onclick="location.href='Board_write.jsp'"><p
							style="text-decoration: underline">질문하기</p>&nbsp;&nbsp;&nbsp; </a></li>
			</ul>
		</div>
	</nav>
	<br><br><br>
<section style="Height: 684px;">
		<form name="my_form" action="BoardDb2.jsp" method=post>
				<div id=QnaboardbodyBox align="center">
				<div id=BoardBox align="center" style ="height: 500px;">
				<label class="lnb"> 질문수정 </label>
				
				<jsp:useBean id="bd" class="Dao.Board_Dao"> </jsp:useBean>
					<% ArrayList<Board_Dto> clist = bd.BoardSelect(postid); %>
								 	
			 		<table style= "position:absolute; top:80px; left:150px;">
						<tr>
						<th><font color="red">*</font>ID</th>
						<td colspan="2"><% out.println(clist.get(0).getName()); %> </td>
						</tr>
						<tr>
						<th><input type = "hidden" value="<%=postid%>" > </th>
						</tr>
						<tr>
							<th><font color="red">*</font>Question Title</th>
							<td></td> 
						</tr>
						<tr>
							<td colspan="3"><input type="text" value="<%=clist.get(0).getPosttitle()%>" name="title" size="60"
								maxlength="20"></td>
						</tr>
						<tr>
							<th><font color="red">*</font>Question Category</th>
							<td colspan="2"><select name="category">
									<option SELECTED value="study">스터디</option>
									<option value="quiz">퀴즈</option>
							</select></td>
						</tr>
						<tr>
							<th><font color="red">*</font>Question</th>
						</tr>
						<tr>
							<td colspan="3"><input type="text" value="<%=clist.get(0).getPostcontents()%>" name="contents" size="60"
								maxlength="60"></td>
						</tr>
						
					</table>
					<input type="submit" value="Submit!" name="modifyin"
						style="width: 500px; height: 40px; background-color: #2196f3; position:absolute; top:450px; left:140px;" onclick="empty_check()">
					</div>
				</div>
		</form>
	</section>
	
	<footer>
	</footer>
	
</body>
</html>