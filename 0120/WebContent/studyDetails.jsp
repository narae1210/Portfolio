<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>
<%@ page import = "com.green.study.dto.RegistrtionDto"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "Dao.RegistrtionDao"%>
<%
String id = (String)session.getAttribute("idinputLog");
String s_num2 = request.getParameter("s_num");
int s_num = Integer.parseInt(s_num2);
%>
<!DOCTYPE html>
<html>
<head>


<script src="//code.jquery.com/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="Css/Sec.css">
<link rel="stylesheet" type="text/css" href="Css/Header.css">
<link rel="stylesheet" type="text/css" href="Css/Nav.css">
<link rel="stylesheet" type="text/css" href="Css/Article.css">
<link rel="stylesheet" type="text/css" href="Css/Footer.css">


<!--Using the hamburger menu display code-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="jquery.slides.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<header>
		<div class="Title">
			<a onclick="location.href='Main.jsp'"><font size="6px;"
				weight="bold" text-align="center" color=#2196f3>그린스터디</font></a>
		</div>

		<ul class="topMenu">
			<li><a class="topMenuFont" onclick="location.href='StudyHome.jsp'">&nbsp;&nbsp;&nbsp;스터디 </a></li>
			<li><a class="topMenuFont">아카이브 </a></li>
			<li><a class="topMenuFont" onclick="location.href='QuizHome.jsp'">문제 </a></li>
			<li><a class="topMenuFont" onclick="location.href='BoardHome.jsp'">게시판 </a></li>
		</ul>
		<ul class="Login">
			<li><a class="LoginFont" onclick="location.href='Login.jsp'">로그인<a></li>
			<li><a class="LoginFont" onclick="location.href='Join.jsp'">회원가입&nbsp;&nbsp;&nbsp;</a></li>
		</ul>

	</header>
	<br>
	<nav>
		<div class="menubar" style="line-height: 35px">
			<ul class="underMenu">
				<li><a class="underMenuFont"
					onclick="location.href='StudyHome.jsp'">스터디홈
						</p>
				</a></li>
				<li><a class="underMenuFont"
					onclick="location.href='StudyStatus.jsp'">스터디현황 </a></li>
				<li><a class="underMenuFont"
					onclick="location.href='Registrtion.jsp'"><p
							style="text-decoration: underline">
							<a class="underMenuFont">스터디만들기 
						</p></a></li>
			</ul>
		</div>
	</nav>
	<section style="Height : 880px;">
			<jsp:useBean id="dao" class="Dao.RegistrtionDao"></jsp:useBean>
			<%
			ArrayList<RegistrtionDto> dtos = dao.studySelect2(s_num);
			%>
			<div id=bodybox align=center>
			<div id=MyPageBox>
				<div style="float: left; margin-left: -280px";>
					<ul style="list-style: none; float: left; margin-left: -330px;">
					<li>제목 : <%=dtos.get(0).getS_title()%></li>
					<li>유형 : <%=dtos.get(0).getS_type()%></li>
					<li>주 언어 : <%=dtos.get(0).getMain_language()%></li>
					<li>보조 언어 <%=dtos.get(0).getSecound_language()%></li>
					<li>모집 인원 <%=dtos.get(0).getPeople_num()%></li>
					<li>시작 날짜 : <%=dtos.get(0).getS_firstday()%></li>
					<li>종료 날짜 : <%=dtos.get(0).getS_lastday()%></li>
					<li>개요 : <%=dtos.get(0).getS_summary()%></li>
					<li>주요 내용 및 에상 결과물 : <%=dtos.get(0).getS_expect()%></li>
					<li>기대 효과 및 활요 분야 : <%=dtos.get(0).getS_effect()%></li>
					</ul>
				</div>
			</div>
		</div>
		</div>
	</section>
	<footer>
	</footer>
</body>
</html>