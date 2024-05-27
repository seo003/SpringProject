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
					<!-- model에서 전달된 board 객체의 정보 출력 -->
					<header>
						<h2>${board.title }</h2>
					</header>
					<p>${board.content }</p>
					<!-- 버튼 -->
					<ul class="actions">
						<li><a href="edit?idx=${board.idx }" class="button icon solid fa-file">수정하기</a></li>
						<!-- js함수에 idx와 category를 넘겨 confirm 후 매핑되도록 함 -->
						<li><a onclick="confirmDelete(${board.idx},${board.category })" class="button icon solid fa-file">삭제하기</a></li>
					</ul>
				</article>
			</div>

		</div>
</section>

<%@include file="../footer.jsp"%>

<script>
function confirmDelete(idx,category) {
    if (confirm("정말 삭제하시겠습니까?")) {
        window.location.href = "delete?idx=" + idx +"&category="+category;
    }
}
</script>