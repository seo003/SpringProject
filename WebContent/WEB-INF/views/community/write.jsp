<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 윗부분(header)을 따로 만들어 include -->
<%@include file="../header.jsp"%>
<!-- Logo -->
<h1 id="logo">

	<a href="board">커뮤니티</a>
</h1>
<!-- 카테고리에 맞춰 내용 변경 -->
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
					<!-- type을 hidden으로 하여 category값도 같이 전달 -> category에 맞춰 글 저장 -->
					<input type='hidden' name='category' value='${category }' />
					<header>
						<input type='text' name='title' placeholder='제목' /><br>
						<br>
					</header>
					<textarea class='content' type='text' name='content'
						placeholder='내용' /></textarea>
					
					<ul class="actions">
						<li><button type='button icon solid fa-file'>글쓰기</button></li>
					</ul>
				</form>
			</article>
		</div>

	</div>
</section>

<!-- 아랫부분(footer)을 따로 만들어 include -->
<%@include file="../footer.jsp"%>