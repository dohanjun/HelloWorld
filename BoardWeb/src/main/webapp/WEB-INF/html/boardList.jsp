<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>글목록(boardList.jsp))</h3>

<p>${searchCondition }</p>
<form action="boardList.do">
	<div class="row">
		<div class="col-sm-4">
			<select name="searchCondition" class="form-control">
				<option value="">선택하세요</option>
				<option value="T"
					${not empty searchCondition and secrchCondition eq 'T' ? 'selected' : ''}>제목</option>
				<option value="W"
					${!empty searchCondition and secrchCondition eq 'W' ? 'selected' : ''}>작성자</option>
				<option value="TW"
					${searchCondition ne null && secrchCondition == 'TW' ? 'selected' : ''}>제목
					& 작성자</option>
			</select>
		</div>
		<div class="col-sm-6">
			<input type="text" name="keyword"
				value="${not empty keyword ? keyword : '' }" class="form-control">
		</div>
		<div class="col">
			<input type="submit" value="검색" class="form-control">
		</div>
	</div>
</form>
<table border="1" class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
		</tr>
	<tbody>

		<c:forEach var="bvo" items="${list }">
			<tr>
				<td>
				<a href="board.do?page=${paging.currentPage }
								  &keyword=${empty keyword ? '' : keyword  }
								  &searchCondition=${empty searchCondition ? '' : searchCondition }
								  &board_no=${bvo.boardNo }">${bvo.boardNo }</td>
				<td><c:out value="${bvo.title }" /></td>
				<td><c:out value="${bvo.writer }" /></td>
				<td><c:out value="${bvo.creationDate }" /></td>

			</tr>
		</c:forEach>

	</tbody>
</table>
<!-- paging -->
<p>${paging.currentPage }</p>
<nav aria-label="...">
	<ul class="pagination">

		<!--  이전 10개 목록이 존재하면 Previous를 활성화.-->
		<c:choose>
			<c:when test="${paging.prev}">

				<li class="page-item"><a class="page-link"
					href="boardList.do?keyword=${empty keyword ? '' : keyword  }
									   &searchCondition=${empty searchCondition ? '' : searchCondition }
									   &page=${paging.startPage -1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><span class="page-link">Previous</span>
				</li>
			</c:otherwise>
		</c:choose>

		<c:forEach var="p" begin="${paging.startPage }"
			end="${paging.endPage }" step="1">
			<c:choose>
				<c:when test="${paging.currentPage == p}">
					<li class="page-item active" aria-current="page"><span
						class="page-link">${p }</span></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="boardList.do?keyword=${empty keyword ? '' : keyword  }
										   &searchCondition=${empty searchCondition ? '' : searchCondition 
										   }&page=${p }">${p }</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${paging.Next}">

				<li class="page-item"><a class="page-link"
					href="boardList.do?keyword=${empty keyword ? '' : keyword  }
									   &searchCondition=${empty searchCondition ? '' : searchCondition }
									   &page=${paging.currentPage +1}">Next</a></li>
			</c:when>
			<c:otherwise>
			
			<li class="page-item disabled"><span class="page-link">Next</span>
				</li>
			</c:otherwise>
		</c:choose>


	</ul>
</nav>
<!-- paging -->

<jsp:include page="../includes/footer.jsp"></jsp:include>