<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.sql.*"%>
<%
String id = (String)session.getAttribute("idinputLog");
%>
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
<script>
function empty_check() {
	var text_len = my_form.title.value.length
	var text_len2 = my_form.contents.value.length
		if ((text_len < 1) || (text_len2 < 1)) {
		alert("빈 칸을 입력해주세요")
		my_form.contents.focus()
	}
	else {
		my_form.submit();
	}
}
</script>

<title>메인페이지</title>
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
		<form name="my_form" action="BoardDb.jsp" method=post>
				<div id=QnaboardbodyBox align="center">
				<div id=BoardBox align="center" style ="height: 500px;">
				
				<label class="lnb"> 질문하기 </label>
				<table style= "position:absolute; top:80px; left:150px;">
						<tr>
							<th><font color="red">*</font>Question Title</th>
							<td></td> 
						</tr>
						<tr>
							<td colspan="3"><input type="text" name="title" id="title" size="60"
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
							<td colspan="3"><input type="text" name="contents" id="contents" size="60"
								maxlength="60"></td>

						</tr>
					</table>
					<input type="button" value="Submit!" name="questionin" onclick="empty_check()"
						style="width: 500px; height: 40px; background-color: #2196f3; position: absolute; top: 450px; left: 140px;">
				</div>
				</div>
		</form>
	</section>
	
	<footer>
	</footer>
	
</body>
</html>