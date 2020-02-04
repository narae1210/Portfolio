<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.green.study.dto.QuizDto" %>
<%@ page import="java.util.ArrayList" %>

<% ArrayList<QuizDto> arr = (ArrayList<QuizDto>)request.getAttribute("data"); %>	

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="Css/Sec.css">
<link rel="stylesheet" type="text/css" href="Css/Header.css">
<link rel="stylesheet" type="text/css" href="Css/Nav.css">
<link rel="stylesheet" type="text/css" href="Css/Article.css">
<link rel="stylesheet" type="text/css" href="Css/Footer.css">
<link rel="stylesheet" type="text/css" href="Css/MyPageBox.css">

<!--Using the hamburger menu display code-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="jquery.slides.min.js"></script>
<script type="text/javascript" src="js/superslide.2.1.js"></script>


<title>Insert title here</title>
</head>

<body>
		<jsp:include page ="Header.jsp"></jsp:include>
	
	<br>
	<nav>
		<div class="menubar" style="line-height: 35px">
			<ul class="underMenu">
				<li><a class="underMenuFont"
					onclick="location.href='QuizdHome.jsp'">문제홈</a></li>

				<li><a class="underMenuFont" href="sang.do?command=select"> 
				<p style="text-decoration: underline">단계별문제</p></a></li>
				
				<li><a class="underMenuFont"
					onclick="location.href='Registrtion.jsp'">랭킹</a></li>
			</ul>
		</div>
	</nav>

	<section style="Height: 1000px;">	
		<center>
		<div
			style="text-align: center; display: inline-block; text-aglin: center; margin-top: -70px;">
		
			<table class="type06">
				<tr>
					<th scope="row">No.</th>
					<th scope="row">주제</th>
					<th scope="row" id="idd">제목</th>
					<th scope="row">난이도</th>
					<th scope="row">답변수</th>
				</tr>
				
 		<%	for(int i=0; i< arr.size(); i++){
		if( i % 2 == 0 ){%> 
				<tr>	
				<td class="even"><% out.println(arr.get(i).getQuizid());%></td>
				<td class="even"><% out.println(arr.get(i).getQuiztheme());%></td>
				<td class="even"><a href="sang.do?command=selectdetail&quizid=<%=arr.get(i).getQuizid()%>"><% out.println(arr.get(i).getQuiztitle());%></a></td>
				<td class="even"><% out.println(arr.get(i).getQuizlevel());%></td>
				<td class="even"><% out.println(arr.get(i).getRe_seq());%></td>
			</tr>
 				<% }
				else{%>
			<tr>
				<td scope="row"><% out.println(arr.get(i).getQuizid()); %></td>
 				<td scope="row"><% out.println(arr.get(i).getQuiztheme());%></td>
				<td scope="row"><a href="sang.do?command=selectdetail&quizid=<%=arr.get(i).getQuizid()%>"><% out.println(arr.get(i).getQuiztitle());%></td>
				<td scope="row"><% out.println(arr.get(i).getQuizlevel());%></td>
				<td scope="row"><% out.println(arr.get(i).getRe_seq());%></td>
			</tr>
 				<%} %>
			<% }
			%> 
		</table>

				</div>

		</center>
	</section>

	<footer> </footer>
</body>
</html>