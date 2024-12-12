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
<jsp:include page="../includes/footer.jsp"></jsp:include>