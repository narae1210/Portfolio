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
		my_form.text_len.focus()
	}
	else {
		my_form.submit();
	}
}
</script>

<title>메인페이지</title>
</head>

<body>
		<jsp:include page ="Header.jsp"></jsp:include>
	<br>
	<nav>
		<div class="menubar" style="line-height: 35px">
			<ul class="underMenu">
				<li><a class="underMenuFont"
					onclick="location.href='QuizHome.jsp'">문제홈</a></li>

				<li><a class="underMenuFont" href="sang.do?command=select"> 
				<p style="text-decoration: underline">단계별문제</p></a></li>
				
				<li><a class="underMenuFont"
					onclick="location.href='Registrtion.jsp'">랭킹</a></li>
			</ul>
		</div>
	</nav>
	<br><br><br>
<section style="Height: 684px;">
		<form name="my_form" action="Sang.do?command=answerwritepro" method=post>  <!--서블릿에서 받는 명령어 if (command.equals("answerwritepro")) {e -->
				<div id=QnaboardbodyBox align="center">
				<div id=BoardBox align="center" style ="height: 500px;">
				
				<label class="lnb"> 문제풀기 </label>
				<table style= "position:absolute; top:80px; left:150px;">
				<!-- input type hidden:  퀴즈아이디, 댓글ref, 댓글seq --> 
	
						<tr>
							<th><font color="red">*</font>언어</th>
							<td colspan="2"><select name="uselang">
								<option SELECTED value="Java">Java</option>
								<option value="C++14">C++14</option>
								<option value="python3">python3</option>
								<option value="C11">C11</option>
								<option value="pypy3">pypy3</option>
								<option value="C++14">C++14</option>
								<option value="C">C</option>
								<option value="C++">C++</option>
								<option value="C++11">C++11</option>
								<option value="C++17">C++17</option>
								<option value="Java(OpenJDK)">Java(OpenJDK)</option>
								<option value="python2">python2</option>
								<option value="pypy2">pypy2</option>
								<option value="Ruby2.5">Ruby2.5</option>
								<option value="Kotlin(JVM)">Kotlin(JVM)</option>
								<option value="Kotlin(Native)">Kotlin(Native)</option>
								<option value="Swift">Swift</option>
								<option value="node.js">node.js</option>
								<option value="Text">Text</option>
								<option value="C#6.0">C#6.0</option>
								<option value="Go">Go</option>
								<option value="D">D</option>
								<option value="PHP">PHP</option>
								<option value="Rust">Rust</option>
								<option value="Rust2018">Rust2018</option>
							</select></td>
						</tr>
						<tr>
							<th><font color="red">*</font>소스코드</th>
						</tr>
						<tr>
							<td colspan="3"><input type="text" name="contents" id="contents" size="60"
								maxlength="60"></td> 
							</form>

						</tr>
					</table>
					<input type="submit" value="Submit!" name="quizanswerin"
						style="width: 500px; height: 40px; background-color: #2196f3; position:absolute; top:450px; left:140px;" onclick="empty_check()">
					</div>
				</div>
		</form>
	</section>
	
	<footer>
	</footer>
	
</body>
</html>