<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>상세화면입니다.</h3>

<form action="modifyForm.do">
<input type="hidden" name="board_no" value="${board.boardNo }">
<input type="hidden" name="searchCondition" value="${searchCondition }">
<input type="hidden" name="keyword" value="${keyword }">
<input type="hidden" name="page" value="${page }">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${board.boardNo }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea rows="2" class="form=control">${board.content }</textarea></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title }</td>
			<th>이미지</th>
			<td><img src="images/${board.img }"width="100px"></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td>${board.creationDate }</td>
		</tr>
		<tr>
		<c:choose>
			<c:when test="${!empty logId and board.writer == logId }">
			<td colspan="4" align="center"><input type="submit"
				class="btn btn-warning" value="수정화면"></td>
			</c:when>
			<c:otherwise>
				<td colspan="4" align="center"><input type="submit"
				class="btn btn-warning" value="수정화면" disabled></td>
			</c:otherwise>
		</c:choose>
		</tr>
	</table>
</form>
<style>
	div.reply .content ul {
		list-style-type: none;
	}
	div.reply .content span{
		display: inline-block;
	}
</style>
<div class="reply">
	<div class="header"></div>
	댓글내용:<input type="text" id="reply" class="form-control col-sm-8">
	<button id="addBtn" class="col-sm-2 btn btn-primary">댓글등록</button>
	<div class="content">
		<ul class="title">
			<li>
				<span class="col-sm-2">글번호</span>
				<span class="col-sm-5">내용</span>
				<span class="col-sm-2">작성자</span>
				<span class="col-sm-2">삭제</span>
				
			</li>
		</ul>
		<ul class="list"></ul>
	</div>
	
	<div class="footer">
	<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
	</div>
</div>
<script>
	let bno ="${board.boardNo }"; // 원본글 번호.
	let logId = "${logId}";
</script>
<script src="js/board.js"></script>
<jsp:include page="../includes/footer.jsp"></jsp:include>