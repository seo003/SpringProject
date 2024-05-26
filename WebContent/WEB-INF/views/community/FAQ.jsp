<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../header.jsp"%>
<!-- Logo -->
<h1 id="logo">
	<a href="/SpringProject/">커뮤니티</a>
</h1>
<p>FAQ</p>
</div>
</section>

<!-- Main -->
<section id="features">
	<a href="write?category=1" class="button">글쓰기</a> <br> <br>
	<div class="container">
		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th>제목</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var='list' items='${boardList }'>
						<tr>
							<td><a href="view?idx=${list.idx }">${list.title }</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</section>

<%@include file="../footer.jsp"%>