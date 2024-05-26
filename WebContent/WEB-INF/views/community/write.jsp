<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../header.jsp"%>
<!-- Logo -->
<h1 id="logo">

	<a href="board">커뮤니티</a>
</h1>
<c:choose>
	<c:when test="${category == 0}">
		<p>공지사항</p>
	</c:when>
	<c:when test="${category == 1}">
		<p>FAQ</p>
	</c:when>
	<c:otherwise>
		<p>자유게시판</p>
	</c:otherwise>
</c:choose>
</div>
</section>

<section id="main">
	<div class="container">
		<div id="content" class="col-8 col-12-medium">
			<article class="box post">
				<form action='write' method='post'>
					<input type='hidden' name='category' value='${category }' />
					<header>
						<input type='text' name='title' placeholder='제목' /><br>
						<br>
					</header>
					<textarea class='content' type='text' name='content'
						placeholder='내용' /></textarea>
					<!-- 버튼 -->
					<ul class="actions">
						<li><button type='button icon solid fa-file'>글쓰기</button></li>
					</ul>
				</form>
			</article>
		</div>

	</div>
</section>

<%@include file="../footer.jsp"%>