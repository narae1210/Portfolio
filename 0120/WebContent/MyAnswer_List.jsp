<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.green.study.dto.QuizAnswerDto" %>
<%@ page import="java.util.ArrayList" %>
<%
String id = (String)session.getAttribute("idinputLog");
%>
<% ArrayList<QuizAnswerDto> arr = (ArrayList<QuizAnswerDto>)request.getAttribute("data"); %>	

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="Css/Sec.css">
<link rel="stylesheet" type="text/css" href="Css/Header.css">
<link rel="stylesheet" type="text/css" href="Css/Nav.css">
<link rel="stylesheet" type="text/css" href="Css/Article.css">
<link rel="stylesheet" type="text/css" href="Css/Footer.css">


<!--Using the hamburger menu display code-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="jquery.slides.min.js"></script>
<script type="text/javascript" src="js/superslide.2.1.js"></script>


<title>Insert title here</title>
</head>

<body>

		<jsp:include page ="Header2.jsp"></jsp:include>

	
	<br>
	<nav>
		<div class="menubar" style="line-height: 35px">
			<ul class="underMenu">
				<li><a class="underMenuFont"
					onclick="location.href='MyPage.jsp'"><p
							style="text-decoration: underline">마이페이지</p></a></li>

			</ul>
		</div>
	</nav>
	

My Answer List 
	<section style="Height: 800px;">	
		<center>
		<div
			style="text-align: center; display: inline-block; text-aglin: center; margin-top: -70px;">
					
		<table class="type06">
		<tr>
			<th scope="row">채점번호</th>
			<th scope="row" id="idd">제목</th>
			<th scope="row">문제번호</th>
			<th scope="row">결과</th>
			<th scope="row">언어</th>
		</tr>
<%-- 		<tr>
			<th scope="even"><% out.println(arr.get(0).getSeq()); %></th>
			<th scope="even" id="idd">제목</th>
			<th scope="even">문제번호</th>
			<th scope="even">결과</th>
			<th scope="even">언어</th>
		</tr> --%>
		</table>
		
		</div>
		</center>
		</section>
</body>
</html>