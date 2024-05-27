<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 윗부분(header)을 따로 만들어 include -->
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
				작성자:
				<!-- 사용자에 맞춰 존재하지 않으면 null 출력 -->
				<c:choose>
					<c:when test="${board.userId == null}">
										null
					</c:when>
					<c:otherwise>
								${board.userId }
					</c:otherwise>
				</c:choose>
				<!-- model에서 전달된 board 객체의 정보 출력 -->
				<header>
					<h2>${board.title }</h2>
				</header>
				<h4>${board.content }</h4>
				<!-- 버튼 -->
				<ul class="actions">
					<li><a href="edit?idx=${board.idx }"
						class="button icon solid fa-file">수정하기</a></li>
					<!-- js함수에 idx와 category를 넘겨 confirm 후 매핑되도록 함 -->
					<li><a
						onclick="confirmDelete(${board.idx},${board.category })"
						class="button icon solid fa-file">삭제하기</a></li>
				</ul>
			</article>
		</div>

	</div>
</section>

<!-- 아랫부분(footer)을 따로 만들어 include -->
<%@include file="../footer.jsp"%>

<script>
// 정말 삭제할것인지 확인 후 url 이동
function confirmDelete(idx,category) {
    if (confirm("정말 삭제하시겠습니까?")) {
        window.location.href = "delete?idx=" + idx +"&category="+category;
    }
}
</script>