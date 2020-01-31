<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.green.study.dto.Board_Dto" %>
<%@ page import="java.util.ArrayList" %>
<% String postid = request.getParameter("postid"); //url에 표시되는 내용, 23번 게시물 a링크를 탈 경우 postid = 23임.
%>

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
		<jsp:include page ="Header2.jsp"></jsp:include>
	</header>

	<br>

	<nav>
		<div class="menubar" style="line-height: 35px">
			<ul class="underMenu">
				<li><a class="underMenuFont"
					onclick="location.href='BoardHome.jsp'"><p
							style="text-decoration: underline">질문홈</p></a></li>

				<li><a class="underMenuFont"
					onclick="location.href='Board_write.jsp'">질문하기&nbsp;&nbsp;&nbsp; </a></li>
			</ul>
		</div>
	</nav>

	<section style="Height: 584px;">	
		<center>
		<div
			style="text-align: center; margin-top: 70px;">
			<label class="lnb2"> 질문보기 </label>
			<div id=QnaboardbodyBox align=center>
				<jsp:useBean id="bd" class="Dao.Board_Dao"> </jsp:useBean>
					<% ArrayList<Board_Dto> clist = bd.BoardSelect(postid); %>
					
					<table class="type07">
						<tr>
						<td scope="row" id='idd'><font color="red">*</font>Name</td>
						<th colspan="2" id='iddd'> <% out.println(clist.get(0).getName()); %> </th>
						</tr>
						<tr>
							<td><font color="red" id='idd'>*</font>Question Title</td>
							<th colspan="2" id='iddd'><% out.println(clist.get(0).getPosttitle()); %></th>
						</tr>
						<tr>
							<td scope="row"  id='idd'><font color="red">*</font>Question Category</td>
							<th colspan="2"  id='iddd'> <% out.println(clist.get(0).getPostcategory()); %></th>
						</td>
						</tr>
						<tr>
						<td scope="row" id='idd'><font color="red">*</font>Question</td>
						<th colspan="2" id='iddd'><% out.println(clist.get(0).getPostcontents()); %></th>
						</tr>
					</table>
								
			</div> 
						
			<article>
			<div class="BoardmenubarColor" style="line-height: 35px">
				<ul class="BoardUnderMenu" style="margin-left: 420px;">
					<li><a class="BoardUnderMenuFont" href="Board_Modify.jsp?postid=<%=postid%>">수정 </a></li>
					<li><a class="BoardUnderMenuFont" href="BoardDb3.jsp?postid=<%=postid%>">삭제  </a></li>
					<li><a class="BoardUnderMenuFont"
						onclick="location.href='BoardHome2.jsp'"> 목록 </a></li>
				</ul>

			</div>
		</article>
		
<!-- 				<div id="BoardBox" align="center">
					<table>
					<tr>
					<td><font color="red">*</font>Answer</td>
						</tr>
						<tr>
						<td colspan="3"><textarea rows="10" cols=70% name="qnabody"></textarea></td>
						</tr>
					</table>
				<input type="submit" value="Submit!" name="questionin" style=" width: 500px; height: 40px; background-color: #2196f3;">
				</div> -->
				</div>
			</center>
	</section>
	
	<footer>
	</footer>
	
</body>
</html>