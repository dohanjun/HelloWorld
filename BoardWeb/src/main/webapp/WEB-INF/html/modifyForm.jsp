<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>수정화면입니다.</h3>

<form action="modifyBoard.do">
<input name="board_no" value="${board.boardNo }">
<input type="hidden" name="searchCondition" value="${searchCondition }">
<input type="hidden" name="keyword" value="${keyword }">
<input type="hidden" name="page" value="${page }">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${board.boardNo }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input type="text" name="title" value="${board.title }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input type="text" name="content" value="${board.content }"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer }</td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td>${board.creationDate }</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			<input type="submit" class="btn btn-warning" value="저장" ></td>
		</tr>
	</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>