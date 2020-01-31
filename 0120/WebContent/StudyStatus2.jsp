<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>
<%@ page import="com.green.study.dto.RegistrtionDto"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Dao.RegistrtionDao"%>
<%
	String id = (String) session.getAttribute("idinputLog");


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
<script type="text/javascript" src="js/superslide.2.1.js"></script>

<title>StudyStatus</title>
</head>

<body>


	<%
		
	%>

		<jsp:include page ="Header2.jsp"></jsp:include>
	<br>
	<nav>
		<div class="menubar" style="line-height: 35px">
			<ul class="underMenu">
				<li><a class="underMenuFont"
					onclick="location.href='StudyHome2.jsp'">스터디홈
						</p>
				</a></li>
				<li><a class="underMenuFont"
					onclick="location.href='StudyStatus2.jsp'"><p
							style="text-decoration: underline">
							<a class="underMenuFont">스터디현황 </a>
						</p></li>
				<li><a class="underMenuFont"
					onclick="location.href='Registrtion2.jsp'">스터디만들기</a></li>
			</ul>
		</div>
	</nav>



	<section>

		<div id=bodybox align=center>
			<div id=StudyStatusBodybox>
				<table>

				</table>
			</div>
		</div>


		<article>
			<br> <br> <br>
			<jsp:useBean id="dao" class="Dao.RegistrtionDao"></jsp:useBean>
			<%
				ArrayList<RegistrtionDto> dtos = dao.studySelect(id);
				for (int i = 0; i < dtos.size(); i++) {
			%></a>
			<div class=layout id=contents>
				<img src="images\java.JPG" width=160px height=130px>
				<div class=layout id=contentstable>
					<div class="language" align=left>
						<%=dtos.get(i).getMain_language()%>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="studyDetails.jsp?s_num=<%=dtos.get(i).getS_num()%>"><font color = red>상세보기</font></a>
					</div>
					
					<div class="studytitle" align=left></div>
					<%=dtos.get(i).getS_title()%>
					<div class="studyday" align=left><%=dtos.get(i).getS_firstday()%>
						<%
							out.println("~");
						%>
						<%=dtos.get(i).getS_lastday()%></div>
					<div class="membernow" align=right>
						<%
							out.println("현재  ");
						%>
						<%
							out.println("  / ");
						%>
						<%=dtos.get(i).getPeople_num()%>

					</div>
				</div>
			</div>
			<%
				}
			%>
			

		</article>

		<div class=pagenation>
			<img src="img\page.png" width=580px height=50px>
		</div>
	</section>

	<footer> </footer>


</body>
</html>