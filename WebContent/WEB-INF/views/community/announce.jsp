<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 윗부분(header)을 따로 만들어 include -->
<%@include file="../header.jsp"%>
<!-- Logo -->
<h1 id="logo">
	<a href="/SpringProject/">커뮤니티</a>
</h1>
<p>공지사항</p>
</div>
</section>


<section id="features">
	<!-- category 파라미터 전달 -->
	<a href="write?category=0" class="button">글쓰기</a> <br> <br>
	<div class="container">
		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th style="width:50%;">제목</th>
						<th style="width:25%;">사용자</th>
						<th style="width:25%;">날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var='list' items='${boardList }'>
						<tr>
							<!-- idx 파라미터 전달 -->
							<td><a href="view?idx=${list.idx }">${list.title }</a></td>
							<td>
								<!-- 사용자가 비어있을 시 null 출력 --> 
								<c:choose>
									<c:when test="${list.userId == null}">
										null
									</c:when>
									<c:otherwise>
										${list.userId }
									</c:otherwise>
								</c:choose>
							</td>
							<td>${list.createdDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</section>

<!-- 아랫부분(footer)을 따로 만들어 include -->
<%@include file="../footer.jsp"%>