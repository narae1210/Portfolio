<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.green.study.dto.QuizDto"%>
<%@ page import="java.util.ArrayList" %>

<% String quizid = request.getParameter("quizid"); //url에 표시되는 내용, 15번 게시물 a링크를 탈 경우 quizid = 15임.%>
<% ArrayList<QuizDto> clist = (ArrayList<QuizDto>)request.getAttribute("data"); %>	

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
	<header>
		<jsp:include page ="Header.jsp"></jsp:include>
	</header>

	<br>

	<nav>
		<div class="menubar" style="line-height: 35px">
			<ul class="underMenu">
				<li><a class="underMenuFont"
					onclick="location.href='QuizHome.jsp'">문제홈</a></li>

				<li><a class="underMenuFont" href="sang.do?command=select"> 
				<p style="text-decoration: underline">단계별문제</p></a></li>
				
				<li><a class="underMenuFont"
					onclick="location.href='sang.do?command=select'">랭킹</a></li>
			</ul>
		</div>
	</nav>

	<section style="Height: 584px;">	
		<center>
		<div
			style="text-align: center; margin-top: 70px;">
			<label class="lnb2"> 문제보기 </label>
			<div id=QnaboardbodyBox align=center>
					
					<table class="type07">
						<tr>
						<td scope="row" id='idd'><font color="red">*</font>문제</td>
						<th colspan="2" id='iddd'> <% out.println(clist.get(0).getQuiz()); %> </th>
						</tr>
						<tr>
							<td><font color="red" id='idd'>*</font>입력</td>
							<th colspan="2" id='iddd'><% out.println(clist.get(0).getQuizin()); %></th>
						</tr>
						<tr>
							<td scope="row"  id='idd'><font color="red">*</font>출력</td>
							<th colspan="2"  id='iddd'> <% out.println(clist.get(0).getQuizout()); %></th>
						</td>
						</tr>
						<tr>
						<td scope="row" id='idd'><font color="red">*</font>예제입력</td>
						<th colspan="2" id='iddd'><% out.println(clist.get(0).getQuizinex()); %></th>
						</tr>
						<tr>
						<td scope="row" id='idd'><font color="red">*</font>예제출력</td>
						<th colspan="2" id='iddd'><% out.println(clist.get(0).getQuizoutex()); %></th>
						</tr>
					</table>
								
			</div> 
						

				</div>
			</center>
	</section>
	
	<footer>
	</footer>
	
</body>
</html>