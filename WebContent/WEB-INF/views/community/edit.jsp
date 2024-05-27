<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.jsp"%>
<!-- Logo -->
<h1 id="logo">
	<a href="board">커뮤니티</a>
</h1>
<p>자유게시판</p>
</div>
</section>

<section id="main">
	<div class="container">
			<div id="content" class="col-8 col-12-medium">
				<article class="box post">
					<form action='edit' method='post'>
						<!-- model에서 전달된 board의 값 출력 -->
						<input type='hidden' name='idx' value='${board.idx}'>
						<header>
							<input type='text' name='title' value='${board.title }'/><br><br>
						</header>
						<textarea class='content' type='text' name='content' />${board.content }</textarea>
						<!-- 버튼 -->
						<ul class="actions">
							<li><button type='button icon solid fa-file'>완료</button></li>
						</ul>
					</form>
				</article>
			</div>

		</div>
</section>

<%@include file="../footer.jsp"%>